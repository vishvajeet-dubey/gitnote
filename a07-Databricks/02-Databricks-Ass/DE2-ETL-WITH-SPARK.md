# CONTENT


---

## 2-1-Querying-Files-Directly
To query the data contained in a single file, execute the query with the following pattern:  

```sql
SELECT * FROM file_format.`/path/to/file`
```

Make special note of the use of back-ticks (not single quotes) around the path.   

### Create reference to file

**1. USING VIEW**  
```sql
CREATE OR REPLACE VIEW event_view
AS SELECT * FROM json.`${DA.paths.kafka_events}`
```


**2. USING TEMP VIEW**: Temporary views similarly alias queries to a name that's easier to reference in later queries. It exists only for the current SparkSession. On Databricks, this means they are isolated to the current notebook, job, or DBSQL query.  
```sql
CREATE OR REPLACE TEMP VIEW events_temp_view
AS SELECT * FROM json.`${DA.paths.kafka_events}`
```
