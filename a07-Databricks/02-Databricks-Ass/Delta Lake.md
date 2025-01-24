# Content
- [01-What-is-Delta-Lake](#01-What-is-Delta-Lake)
	- [01a-Delta-Lake-Architecture](#01a-Delta-Lake-Architecture)
	- [01b-Data-Object-in-Databricks](#01b-Data-Object-in-Databricks)
	- [01c-Liquid-Clustering](#01c-Liquid-Clustering)
	- [01d-Deletion-Vectors](#01d-Deletion-Vectors)
	- [01e-Predictive-IO](#01e-Predictive-IO)

---

## 01-What-is-Delta-Lake

- Delta Lake is an open-source data management platform.
- It enhances data operations and analytics.
- It leverages standard data formats.
- Optimized for cloud object storage.
- Built for efficient metadata handling.

### 01a-Delta-Lake-Architecture

![](../resource/Pasted%20image%2020250120113902.png)  

- ACID {Atomicity, Consistency, Isolation and Durability}
#### Problems solved by ACID
- **Streamlined Data Append:** Delta Lake simplifies and improves data appending, making it efficient even with concurrent writes.
- **Simplified Data Modification:** Delta Lake simplifies data modification, ensuring data consistency.
- **Data Integrity Trough Job Failures**: Delta Lake prevents data inconsistencies due to job failures, maintaining data integrity.
- **Support for Real-Time Operations:** Delta lake serves as a robust data source and sink for real-time and streaming operations.
- **Efficient Historical Data version Management:** Delta Lake offers time travel for accessing historical data versions, and its cost-effectiveness depends on your specific use case and alternative solutions.

#### Key-Features-of-Delta-Lake
- **Update and Delete:** Delta Lake allows for the modification and removal of records, offering a crucial distinction from other data formats.
- **Data Skipping Index:** Delta Lake employs file statistics to optimize query performance by skipping unnecessary data scans.

#### For almost all use cases the Delta Lake framed as Medallion Architecture(Multi-Hop Architecture)
![](../resource/Pasted%20image%2020250120120356.png)   

**Note:** Delta is the default format for tables created in Databricks.

```sql
CREATE TABLE foo
--USING DELTA; -- default is delta so not required
```

```python
df.write
#	.format("delta") # default is delta so not required
```

### 01b-Data-Object-in-Databricks
![](../resource/Pasted%20image%2020250120121128.png)   

#### Table:
1. Managed table
2. External table
![](../resource/Pasted%20image%2020250120122147.png)  

#### View:
- It is a saved query that is typically run against one or more tables for data sources.
- Whenever you try to run the views it will re query underlying tables
- 2 types of View
	- Temporary View
	- Global Temporary View

#### Function
- saved logic that returns a scalar value or set of rows. See [User-defined functions (UDFs) in Unity Catalog](https://docs.databricks.com/en/udf/unity-catalog.html).

### 01c-Liquid-Clustering
No more partitions   
- Fast
	- Faster writes and similar read vs. well-tuned partitioned tables
- Self-tuning
	- Avoids over- and under-partitioning
- Incremental
	- Automatic partial clustering of new data
- Skew-resistant
	- Produces consistent file sizes and low write amplification
- Flexible
	- Want to change the clustering column ? No Problem!
- Better concurrency

### 01d-Deletion-Vectors
Before:
- Changing table data required full file rewrite
After:
- Deletes, updates and merges are written to a deletion vector file   

Photon leverages deletion vectors for predictive I/O updates, accelerating DLETE, MERGE, and UPDATE operations.   

### 01e-Predictive-IO
- Automates Optimize and Vacuum operations
- Based on Databricks' year of experience in building large AI/ML systems
- Makes the lakehouse a smarter data warehouse
- works to have the best cost/benefit possible
- Uses ML to determine the most efficient access pattern to read data
- Leverages deletion vectors to accelerate updates by reducing the frequency of full file rewrites.
