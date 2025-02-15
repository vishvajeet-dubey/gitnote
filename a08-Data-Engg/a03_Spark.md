# Content
- [Spark-Overview](#Spark-Overview)

---

# Spark-Overview
### What is Apache Spark?
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

### Why Apace Spark? What Problem does it solve?
Previously we were using the Databases to load the data, like:   
Database --> Oracle, Teradata, Exadata, MySQL server etc.   
These data were stored in form of structured data(tabular form only).   

| col1     | col2     | col3     | col4     | col5     |
| -------- | -------- | -------- | -------- | -------- |
| sample01 | sample02 | sample03 | sample04 | sample05 |

As Data are growing now a days not only structured form.  
File --> Text, CSV, Image, Video   
Semi-Structure: JSON, YAML  

Since data growing we started facing the Big Data handling/processing issue:   

#### **Big Data:** 3 v's of Big data.   
1. **Velocity**: How fast data is growing like 1GB per Second.
2. **Variety**: Text, JSON, YAML, Audio, Video, Image, Structured, Semi structure, unstructured
3. **Volume**: 5GB, 10TB not big data but 10 TB per hours can be.

To Solve this problem we have to can use Spark.   

ETL --> Extract Transform Load (Early days when storing in database)   
ELT --> Extract Load Transform (Now a days)   

#### Issue: 
1. Storage --> since data growing fast how we can store.
2. Processing --> RAM and CPU   

To handle this we had 2 approach
1. Monolithic Approach: Scaling single hardware in vertical
2. Distributed Approach: Scaling multiple hardware in horizontal.


| Monilithic                               | Distributed                                                     |
| ---------------------------------------- | --------------------------------------------------------------- |
| Vertical Scaling                         | Horizontal Scaling                                              |
| Expensive                                | Economical                                                      |
| Low availability                         | High availability                                               |
| 🛢                                       | 🖥🖥🖥🖥🖥                                                      |
| If system fail then everything will down | If one system fail then data will process from another machine. |

