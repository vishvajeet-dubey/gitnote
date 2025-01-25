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
CREATE TEMP VIEW view_name
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
```
