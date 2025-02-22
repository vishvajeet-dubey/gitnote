# Content
- [Overview](#Overview)
- [1-What-is-BIGINT](#1-What-is-BIGINT)
	- [Key-Characteristics-of-BIGINT](#Key-Characteristics-of-BIGINT)
- [2-What-is-BIGSERIAL](#2-What-is-BIGSERIAL)
	- [Key-Characteristics-of-BIGSERIAL](#Key-Characteristics-of-BIGSERIAL)
- [3-What-is-a-Sequence-in-PostgreSQL](#3-What-is-a-Sequence-in-PostgreSQL)
	- [Key-Characteristics-of-Sequences](#Key-Characteristics-of-Sequences)
	- [SYNTAX](#SYNTAX)


----

# Overview
In PostgreSQL, managing large integers efficiently is crucial for many applications, especially when dealing with unique identifiers and large datasets. Two important data types for handling large integers are BIGINT and BIGSERIAL. While they may seem similar, they serve different purposes and have distinct characteristics. This article will explore the differences between BIGINT and BIGSERIAL, the role of sequences, the costs of using BIGSERIAL, and the challenges associated with altering a column from BIGINT to BIGSERIAL.

# 1-What-is-BIGINT

`BIGINT` is an 8-byte integer type that can store a vast range of values. It is used when storing large numeric values, often larger than what `INTEGER` or `SMALLINT` can handle.

## Key-Characteristics-of-BIGINT

- Value Range: `BIGINT` can store values from -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807.
- Usage: Ideal for scenarios where large numbers are needed, but automatic incrementation is not required.

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
- Value Range: Uses the same range as `BIGINT`.
- Automatic Features: PostgreSQL automatically creates a sequence and sets the default value of the column to use this sequence.
- Usage: Ideal for columns that require unique, auto-incrementing values.

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


# 3-What-is-a-Sequence-in-PostgreSQL

To understand `BIGSERIAL`, it's essential to grasp what a sequence is. In PostgreSQL, a sequence is a special database object that generates a sequence of unique numeric values, typically used for auto-generating primary keys.

## Key-Characteristics-of-Sequences

- Automatic Value Generation: Sequences produce values in a specified order, often incrementing by 1.
- Uniqueness: Ensures that each value is unique within its context.
- Concurrency Safe: Handles simultaneous access efficiently, guaranteeing unique values.
- Configurable: Options include start value, increment step, minimum and maximum values, and cycling behavior.

### Example
```sql
-- creating student table under test schema
CREATE SCHEMA IF NOT EXISTS test;

CREATE TABLE test.students (
    id BIGSERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    class VARCHAR(100) NOT NULL
);

-- inserting sample record, as id is bigserial no need to pass the value while inserting it will auto increment.
INSERT INTO test.students (name, class) VALUES 
('Alice Johnson', 'Mathematics'),
('Bob Smith', 'Physics'),
('Charlie Brown', 'Chemistry'),
('David Wilson', 'Biology'),
('Emma Davis', 'Computer Science'),
('Frank Thomas', 'History'),
('Grace White', 'Literature'),
('Henry Martin', 'Economics'),
('Isabella Moore', 'Philosophy'),
('Jack Taylor', 'Engineering');


select * from test.students;

select max(id) from test.students; -- checking max value

select pg_get_serial_sequence('test.students', 'id') --get the sequence_name using this query

select last_value from test.students_id_seq; --last value

select setval('test.students_id_seq', (select max(id)+1 from test.students)); --updating the sequence_number

select nextval('test.students_id_seq'); -- next increment value
```


### SYNTAX
```sql
 -- get the sequence_name using this query
 -- it will return sequence name
select pg_get_serial_sequence('schema_name.table_name', 'bigserial_col_name');


-- last value
-- give the sequence name without any quote
select last_value from sequence_name; -- sequence name can get via above query


-- updating the sequence_number
-- default --> true --> sequence will start from number + 1; not needed to give
-- false --> sequence will start from number
select setval('sequence_name', number, true/false);


-- next increment value
select nextval('sequence_name');
```