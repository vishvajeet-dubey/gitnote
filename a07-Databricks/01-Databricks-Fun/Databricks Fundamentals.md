
# Content
- [01-Data-Warehouse](#01-Data-Warehouse)
- [02-Data-Lake](#02-Data-Lake)
- [03-Data-Lakehouse](#03-Data-Lakehouse)
- [04-Databricks-Architecture](#04-Databricks-Architecture)
- [05-Unity-Catalog](#05-Unity-Catalog)
- [06-Databricks-Data-Intelligence-Platform](#06-Databricks-Data-Intelligence-Platform)


-----------------------

## 01-Data-Warehouse
A data warehouse is a **centralized system** that **consolidates** data from **multiple sources**, stores **large amounts of historical** data, and supports **analytics** and **decision-making** as an organization’s single source of truth.  

![](../resource/Pasted%20image%2020250118060435.png)  

### Strengths
- Purpose-built for BI and reporting
- Meant  to unify disparate systems
- Houses structured, clean data with a standardized schema
### Downsides
- No support for semi or unstructured data
- Poor support for data science, AI and streaming use cases
- Uses closed and proprietary formats
- Expensive to scale

## 02-Data-Lake
A data lake is a **centralized repository** designed to store, process, and secure large amounts of **structured, semistructured, and unstructured data**. It can store data in its **native format** and process any variety of it, **ignoring size limits**.  

![](../resource/Pasted%20image%2020250118062250.png)  

### Strengths
- Store any kind of data
- Inexpensive storage
- Good starting point
- Support for GenAI and streaming use cases
### Downsides
- Complex to set up
- Poor BI performance
- Can become unreliable data swamps
- Governance concerns
- Warehouse still needed

### Data Warehouses vs. Data Lakes
![](../resource/Pasted%20image%2020250118063324.png)  

**Note:** To overcome the above issue, a Data Lakehouse comes into play.  

## 03-Data-Lakehouse
One Platform to unify all your data, analytics and AI workloads

![](../resource/Pasted%20image%2020250118064011.png)  

### Key Benefits of the Lakehouse Architecture
- Unified Architecture
- Open Environment
- Cost Efficient and Scalable
- Supportive of Diverse workloads

## 04-Databricks-Architecture
- Databricks provides a **Lakehouse architecture**, combining the best of data lakes and data warehouses to handle diverse data workloads.
- Its built on top of cloud platform(AWS, Azure, GCP)
- Databricks operates out of a **control plane** and a **compute plane**.

![](../resource/Pasted%20image%2020250118070407.png)  

### Databricks Computes
- Runtimes - Standard
	- Apache Spark and many other components and updates to provide an optimized big data analytics experiences.
- Machine Learning
	- adds popular machine learning libraries like TensorFlow, Keras, PyTorch, and XGBoost.
- Specialized Compute - SQL Warehouses
	- Specifically designed for the optimization of SQL BI workloads with built in optimization for best price/performance.
- Enhanced with Databricks Photon
	- Optional to boost your speed

### Infrastructure and Platform - Serverless
![](../resource/Pasted%20image%2020250118071810.png)  
- It is simple and fast
	- No knobs
	- Fast startup
	- For any practitioner
- Efficient
	- Fully managed and version less
	- Paying only what you use
	- Strong cost governance
- Reliable
	- Secure by default
	- Stable with smart fail-overs

![](../resource/Pasted%20image%2020250118072248.png)  

### Databricks Data Intelligence Platform
![](../resource/Pasted%20image%2020250118072810.png)  

## 05-Unity-Catalog
Source Link: [What is Unity Catalog](https://docs.databricks.com/en/data-governance/unity-catalog/index.html)   

### Overview
- Unity Catalog provides centralized access control
- Its provide auditing, lineage, and data discovery capabilities across Databricks Workspaces.
![](../resource/Pasted%20image%2020250118111907.png)  
- **Unify Governance access clouds**
	- Fine-grained governance for data lakes across clouds - based on open standard ANSI SQL.
- **Unify Data and AI Assets**
	- Centrally share, audit, secure and manage all data types with one simple interface.
- **Unify Existing Catalogs**
	- Works in concert with existing data storage and catalogs - no hard migration required.

## 06-Databricks-Data-Intelligence-Platform

![](../resource/Pasted%20image%2020250118113415.png)  
Starting from bottom.  
### Data Lake
- Databricks built one open source Data Lake
- Open source Data Lake which supports all raw data(Logs, Text, Audio, Video, Image)

---
### Delta Lake 🔼
- Unified data storage for reliability and sharing
- Data layout is automatically optimized based on usage patterns
#### Key Features of Delta Lake 🔼
- ACID Transactions
- DML Operations
- Time Travel
- Shema Evolution and Enforcement

---

1. **ACID Transactions**
    - **Atomicity**: Ensures that operations either complete fully or have no effect at all.
    - **Consistency**: Guarantees data integrity even during concurrent reads and writes.
    - **Isolation**: Prevents conflicts between concurrent operations.
    - **Durability**: Data is permanently saved after a transaction is committed.

---

2. **DML Operations**
    - Supports **SQL-like operations** (INSERT, UPDATE, DELETE, MERGE) for modifying and managing data.
    - Simplifies workflows by allowing users to perform in-place updates without complex ETL pipelines.

---

3. **Time Travel**
    - Enables access to historical data by maintaining **versioned snapshots** of datasets.
    - Use cases:
        - **Debugging**: Analyze data states before an error occurred.
        - **Auditing**: View past states for compliance requirements.
        - **Rollback**: Revert to a previous dataset version in case of errors.

---

4. **Schema Evolution and Enforcement**
    - **Schema Enforcement**: Validates incoming data against predefined schemas to maintain consistency.
    - **Schema Evolution**: Allows automatic updates to schemas as data structures change (e.g., adding new columns).
    - Prevents data corruption by ensuring that all data conforms to the expected format.

---

### Unity Catalog

- **Purpose**: A unified governance and cataloging layer for security and data management.
- **Key Features**:
    - **Security**: Centralized access control and data permissioning.
    - **Governance**: Ensures compliance with standards like GDPR or HIPAA.
    - **Cataloging**: Maintains metadata and allows users to search and understand datasets.
- **Role**: Enables secure and scalable data sharing across teams and tools.

---

### Databricks IQ

- **Purpose**: Uses generative AI to understand the semantics of your data.
- **Key Features**:
    - **Semantic Layer**: Helps users interpret and query data using natural language.
    - **AI Assistance**: Simplifies complex analytics tasks by providing AI-driven insights and suggestions.
- **Role**: Acts as an intelligence layer across the architecture for enhanced accessibility.

---

### Data Warehousing

- **Component**: **Databricks SQL**
- **Purpose**: Provides a SQL-based interface for querying and analyzing data.
- **Key Features**:
    - **Text-to-SQL**: Enables natural language query generation.
    - **Text-to-Viz**: Creates visualizations directly from query results.
- **Role**: Powers dashboards, reporting, and BI tool integrations.

---

### Orchestration

- **Component**: **Workflows**
- **Purpose**: Manages and schedules data workflows.
- **Key Features**:
    - **Job Automation**: Automates data pipeline execution.
    - **Cost Optimization**: Optimizes resources based on historical job performance.
- **Role**: Ensures seamless execution of ETL and analytics pipelines.

---

### ETL & Real-Time Analytics

- **Component**: **Delta Live Tables**
- **Purpose**: Simplifies and automates ETL processes while ensuring data quality.
- **Key Features**:
    - **Real-Time Analytics**: Processes streaming data alongside batch data.
    - **Data Quality**: Monitors and ensures consistent, clean datasets.
- **Role**: Prepares data for consumption by higher-level layers.

---

### Data Science & AI (Top Layer)

- **Component**: **Mosaic AI**
- **Purpose**: Enables advanced AI and ML workflows, including creating and fine-tuning custom large language models (LLMs).
- **Key Features**:
    - Supports predictive analytics and natural language processing (NLP).
    - Provides tools for serving AI/ML models at scale.
- **Role**: Empowers data scientists to derive insights and build AI-driven applications.

---
### **Summary**

The architecture is designed to flow **bottom-to-top**:

- Raw data in the **Open Data Lake** is stored and optimized using **Delta Lake**.
- Governance and metadata are handled by **Unity Catalog**.
- Intelligent querying and semantics are powered by **Databricks IQ**.
- Higher-level layers like **Workflows**, **Delta Live Tables**, and **Mosaic AI** enable advanced analytics, ETL, and AI capabilities.
---
