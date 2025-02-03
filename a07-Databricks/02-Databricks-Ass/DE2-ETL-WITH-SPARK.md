# CONTENT
- [2-1-Querying-Files-Directly](#2-1-Querying-Files-Directly)
- [2-2-External-Sources](#2-2-External-Sources)


---

# 2-1-Querying-Files-Directly
To query the data contained in a single file, execute the query with the following pattern:  

```sql
SELECT * FROM file_format.`/path/to/file`
```

Make special note of the use of back-ticks (not single quotes) around the path.   

### A. Create reference to file

**1. USING VIEW**  
```sql
CREATE OR REPLACE VIEW event_view
AS SELECT * FROM json.`path`
```


**2. USING TEMP VIEW**: Temporary views similarly alias queries to a name that's easier to reference in later queries. It exists only for the current SparkSession. On Databricks, this means they are isolated to the current notebook, job, or DBSQL query.  
```sql
CREATE OR REPLACE TEMP VIEW events_temp_view
AS SELECT * FROM json.`path`
```

### B. Apply CTEs for Reference within a Query
Common table expressions (CTEs) are perfect when you want a short-lived, human-readable reference to the results of a query.
```sql
WITH cte_table
AS (SELECT * FROM json.`path`)
SELECT * FROM cte_table
```


### C. Load Text file
When working with text-based files (which include JSON, CSV, TSV, and TXT formats), you can use the **`text`** format to load each line of the file as a row with one string column named **`value`**.  
```sql
SELECT * FROM text.`path` -- loading text file

SELECT * FROM binaryFile.`${DA.paths.kafka_events}` -- loading binary file
```

---

# 2-2-External-Sources
### A. CSV format

```sql
select * from csv.`file_path`;
```


> [!NOTE]
> When above query not return the desire result then we can use the below option using delimiter option

#### I. Creating table from CSV file
```sql
CREATE TABLE table_identifier (col_name1 col_type1, ...)
USING data_source
OPTIONS (key1 = val1, key2 = val2, ...)
LOCATION = path
```

#### II. Creating temp view from CSV file
```sql
CREATE OR REPLACE TEMP VIEW view_name
USING CSV
OPTIONS (
  header = "true",
  delimiter = "|",
  path = "path_name"
);
```

Same query we can submit using spark.sql("query")  

>[!warning]
>If you are using the external data source then you have to refresh the table data in-order to reflect the current data

#### III. Saving data as CSV file
```python
(spark.read
      .option("header", "true")
      .option("delimiter", "|")
      .csv("source_file_name_with_absolute_path")
      .write.mode("append")
      .format("csv")
      .save("target_path_with_file_name", header="true"))
```

As Mentioned above, we have to refresh the table after appending the file
```sql
REFRESH TABLE table_name;
```

### B. Extracting Data from SQL Database
SQL databases are an extremely common data source, and Databricks has a standard JDBC driver for connecting with many flavors of SQL.  

The general syntax for creating these connections is:
```sql
CREATE TABLE
USING JDBC
OPTIONS (
    url = "jdbc:{databaseServerType}://{jdbcHostname}:{jdbcPort}",
    dbtable = "{jdbcDatabase}.table",
    user = "{jdbcUsername}",
    password = "{jdbcPassword}"
)

-- CREATING TEMP VIEW FOR ACCESS TABLE FOR CURRENT SESSION
CREATE OR REPLACE TEMP VIEW external_table
USING JDBC
OPTIONS (
  url = "jdbc:sqlite:${DA.paths.ecommerce_db}",
  dbtable = "users"
);

-- ACCESSING TEMP VIEW
SELECT * FROM external_table limit 5;
```


# 2-3-Extract-Data-Lab


# 2-4-Cleaning-Data
As we inspect and clean our data, we'll need to construct various column expressions and queries to express transformations to apply on our dataset.  
Many standard SQL query commands **(e.g. DISTINCT, WHERE, GROUP BY, etc.)** are available in Spark SQL to express transformations.  

### Data Overview
We'll work with new users records from the **`users_dirty`** table, which has the following schema:

| field                      | type      | description                                                           |
| -------------------------- | --------- | --------------------------------------------------------------------- |
| user_id                    | string    | unique identifier                                                     |
| user_first_touch_timestamp | long      | time at which the user record was created in microseconds since epoch |
| email                      | string    | most recent email address provided by the user to complete an action  |
| updated                    | timestamp | time at which this record was last updated                            |

Let's start by counting values in each field of our data.   

Below is the CSV file for dataset:  
![user_dataset](resource/DE_2_4_User_dirty.csv)  


```sql
SELECT count(*), count(user_id), count(user_first_touch_timestamp), count(email), count(updated)
FROM users_dirty;
```

Output:  

| count(1) | count(user_id) | count(user_first_touch_timestamp) | count(email) | count(updated) |
| -------- | -------------- | --------------------------------- | ------------ | -------------- |
| 986      | 983            | 983                               | 138          | 983            |

- Based on above query looks like we have null values in our all columns
- **Note:** Null value works incorrectly in some of the math function like `count()`
	- `count(col)` => Skips null value when counting the specific column.
	- `count(*)` => Count all row including null values
- We can count the null value using below
	- `count_if(col is null)`
	- `count(*)` with filter for where `col is null`

```sql
SELECT count_if(email IS NULL) FROM users_dirty;
SELECT count(*) FROM users_dirty WHERE email IS NULL;

-- output
-- count(1)
-- 848
```

```python
from pyspark.sql.functions import col
usersDF = spark.read.table("users_dirty")

usersDF.selectExpr("count_if(email IS NULL)")
usersDF.where(col("email").isNull()).count()
```