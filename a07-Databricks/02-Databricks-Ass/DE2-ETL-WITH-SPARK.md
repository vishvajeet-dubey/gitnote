# CONTENT


---

# 2-1-Querying-Files-Directly
To query the data contained in a single file, execute the query with the following pattern:  

```sql
SELECT * FROM file_format.`/path/to/file`
```

Make special note of the use of back-ticks (not single quotes) around the path.   

### Create reference to file

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

### Apply CTEs for Reference within a Query
Common table expressions (CTEs) are perfect when you want a short-lived, human-readable reference to the results of a query.
```sql
WITH cte_table
AS (SELECT * FROM json.`path`)
SELECT * FROM cte_table
```


### Load Text file
When working with text-based files (which include JSON, CSV, TSV, and TXT formats), you can use the **`text`** format to load each line of the file as a row with one string column named **`value`**.  
```sql
SELECT * FROM text.`path` -- loading text file

SELECT * FROM binaryFile.`${DA.paths.kafka_events}` -- loading binary file
```

---

# 2-2-External-Sources
### CSV format

```sql
select * from csv.`file_path`;
```


> [!NOTE]
> When above query not return the desire result then we can use the below option using delimiter option

#### Creating table from CSV file
```sql
CREATE TABLE table_identifier (col_name1 col_type1, ...)
USING data_source
OPTIONS (key1 = val1, key2 = val2, ...)
LOCATION = path
```

#### Creating temp view from CSV file
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

