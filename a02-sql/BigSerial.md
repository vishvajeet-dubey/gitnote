# Content
- 

----

# Overview
In PostgreSQL, managing large integers efficiently is crucial for many applications, especially when dealing with unique identifiers and large datasets. Two important data types for handling large integers are BIGINT and BIGSERIAL. While they may seem similar, they serve different purposes and have distinct characteristics. This article will explore the differences between BIGINT and BIGSERIAL, the role of sequences, the costs of using BIGSERIAL, and the challenges associated with altering a column from BIGINT to BIGSERIAL.

# 1-What-is-BIGINT

`BIGINT` is an 8-byte integer type that can store a vast range of values. It is used when storing large numeric values, often larger than what `INTEGER` or `SMALLINT` can handle.

## Key-Characteristics-of-BIGINT

- **Value Range**: `BIGINT` can store values from -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807.
- **Usage**: Ideal for scenarios where large numbers are needed, but automatic incrementation is not required.

### Example
```sql
--Creating a table with a `BIGINT` column

CREATE TABLE orders (  
    id BIGINT PRIMARY KEY,  
    order_date DATE,  
    customer_id INT  
);

--Inserting values manually into the `BIGINT` column:

INSERT INTO orders (id, order_date, customer_id) VALUES (1, '2024-08-02', 123);  
INSERT INTO orders (id, order_date, customer_id) VALUES (2, '2024-08-03', 456);

```
# 2-What-is-BIGSERIAL

`BIGSERIAL` is a PostgreSQL shorthand that combines a `BIGINT` column with an automatic sequence generator. It simplifies the creation of auto-incrementing columns, typically used for primary keys.

## Key-Characteristics-of-BIGSERIAL
- **Value Range**: Uses the same range as `BIGINT`.
- **Automatic Features**: PostgreSQL automatically creates a sequence and sets the default value of the column to use this sequence.
- **Usage**: Ideal for columns that require unique, auto-incrementing values.

### Example
```sql
--Creating a table with a `BIGSERIAL` column:

CREATE TABLE orders (  
    id BIGSERIAL PRIMARY KEY,  
    order_date DATE,  
    customer_id INT  
);

--Inserting data into a `BIGSERIAL` column:
INSERT INTO orders (order_date, customer_id) VALUES ('2024-08-02', 123);  
INSERT INTO orders (order_date, customer_id) VALUES ('2024-08-03', 456);
```


# 3-What-is-aSequence in PostgreSQL?

To understand `BIGSERIAL`, it's essential to grasp what a sequence is. In PostgreSQL, a sequence is a special database object that generates a sequence of unique numeric values, typically used for auto-generating primary keys.

# Key Characteristics of Sequences

- **Automatic Value Generation**: Sequences produce values in a specified order, often incrementing by 1.
- **Uniqueness**: Ensures that each value is unique within its context.
- **Concurrency Safe**: Handles simultaneous access efficiently, guaranteeing unique values.
- **Configurable**: Options include start value, increment step, minimum and maximum values, and cycling behavior.

# Example

Creating a sequence:

CREATE SEQUENCE my_sequence  
    START WITH 1  
    INCREMENT BY 1  
    NO MINVALUE  
    NO MAXVALUE  
    CACHE 1;

Using the sequence to insert data:

INSERT INTO orders (id, order_date, customer_id)  
VALUES (NEXTVAL('my_sequence'), '2024-08-02', 123);

In this example, `NEXTVAL('my_sequence')` generates the next value for the `id` column.

# Sequence Functions

- **NEXTVAL(sequence_name)**: Retrieves and advances the sequence.
- **CURRVAL(sequence_name)**: Returns the current value for the sequence in the current session.
- **SETVAL(sequence_name, value)**: Sets the sequence’s current value to a specified number, useful for synchronization.