# Content
- [Spark-Overview](#Spark-Overview)

---

# Spark-Overview
#### What is Apache Spark?
- Apache Spark is `unified` `computing engine` and set of libraries for p`arallel data processing` on `computer cluster`.
- **Unified**: 
	- Spark is designed to support wide range of task over the same computing engine.
	- For Ex - Data Scientist, Data Analyst and Data Engineer all can use the same platform for their analysis, transformation and modelling.
- **Computing Engine:**
	- Spark is limited to a computing engine. It doesn't store the data.
	- Spark can connect with different data sources like HDFS, IDBC/ODBC, Azure storage, S3 etc.
	- Spark works with almost all data storage system.
- **Parallel data processing:**
	1. **Distributed Data Splitting**: Spark splits data into smaller chunks (partitions) and distributes them across a cluster, enabling simultaneous processing using RDDs, DataFrames, or Datasets.
	2. **Parallel Task Execution**: Each partition is processed independently by tasks running in parallel on multiple nodes/cores, leveraging in-memory computing for faster results.
	3. **Scalability & Fault Tolerance** - Handles massive datasets efficiently by scaling across machines and recovers from failures using lineage (recomputing lost data from original sources).
- **Computer Cluster:**
	- Master Slave Architecture
	- Master
		- Slave1 (1TB, 4 cores CPU, 8GB RAM)
		- Slave2 (1TB, 4 cores CPU, 8GB RAM)
		- Slave3 (1TB, 4 cores CPU, 8GB RAM)
		- Slave4 (1TB, 4 cores CPU, 8GB RAM)

#### Why Apace Spark? What Problem does it solve?
Previously we were using the Databases to load the data, like:   
Database --> Oracle, Teradata, Exadata, MySQL server etc.   
These data were stored in form of structured data(tabular form only).   

| col1     | col2     | col3     | col4     | col5     |
| -------- | -------- | -------- | -------- | -------- |
| sample01 | sample02 | sample03 | sample04 | sample05 |

As Data 