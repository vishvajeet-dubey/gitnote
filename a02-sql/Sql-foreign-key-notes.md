## Constraints
- condition on top of columns, *like password contains special character*
- **unique** ==> duplicate not allowed
- **Not Null** ==> attribute should not be empty
- **Primary key** ==> unique + not null
- **Check constraints** ==> it should match the logic applied on attributes, for example the age cannot be negative
- **Foreign key**
- **default** ==> it is a rule thats automatic provides the value for a column.


### Foreign Key:

- **Definition**: A foreign key is an attribute or set of attributes that references the primary key of the same table or another table. It is used to enforce referential integrity between tables. Referential integrity ensures that the values in the foreign key column(s) match values in the referenced primary key column(s) or are null.

**Referenced Table:**

- **Definition**: The table that contains the primary key being referenced by another table. It holds the original data that is linked by the foreign key in the referencing table.
- **Example**: `Student` table.

**Referencing Table:**

- **Definition**: The table that contains the foreign key. This table links to the referenced table through the foreign key, establishing a relationship between the two tables.
- **Example**: `Course` table.

**Example Tables:**

**Student Table:**

| RollNo | Name | Address |
|--------|------|---------|
| 1      | A    | Delhi   |
| 2      | B    | Mumbai  |
| 3      | C    | Chennai |

**Course Table:**

| CourseId | CourseName  | RollNo |
|----------|-------------|--------|
| C1       | DBMS        | 1      |
| C2       | Network     | 2      |
| C3       | Programming | 3      |

**Operations and Referential Integrity:**

- **Insert in Referenced Table (Student Table)**: 
  - **No Violation**: Inserting a new record into the `Student` table does not directly affect the `Course` table.

- **Insert in Referencing Table (Course Table)**:
  - **May Cause Violation**: Inserting a record into the `Course` table with a `RollNo` that does not exist in the `Student` table will cause a foreign key violation.

- **Delete in Referenced Table (Student Table)**:
  - **May Cause Violation**: Deleting a record from the `Student` table that is still referenced by records in the `Course` table can lead to a foreign key violation unless handled by a delete rule.

- **Delete in Referencing Table (Course Table)**:
  - **No Violation**: Deleting a record from the `Course` table does not affect the `Student` table.

- **Update in Referenced Table (Student Table)**:
  - **May Cause Violation**: Updating a primary key value in the `Student` table can cause a violation in the `Course` table if the updated value does not match existing foreign key values.

- **Update in Referencing Table (Course Table)**:
  - **May Cause Violation**: Updating a foreign key value in the `Course` table to a value that does not exist in the `Student` table can cause a violation.

**Referential Actions:**

- **ON DELETE CASCADE**: When a record in the referenced table is deleted, all related records in the referencing table are also deleted automatically.
  - **Example**: If a `Student` record is deleted, all related `Course` records with that `Student`’s `RollNo` are also deleted.

- **ON DELETE NO ACTION**: Prevents the deletion of a record in the referenced table if there are related records in the referencing table. It enforces that no changes can be made to the referenced table if the foreign key constraints are violated.
  - **Example**: If a `Student` record is referenced by a `Course`, you cannot delete that `Student` record unless the related `Course` records are removed or updated.

**Example Queries:**

To add a foreign key constraint with cascading delete:

```sql
ALTER TABLE Course
ADD CONSTRAINT fk_RollNo
FOREIGN KEY (RollNo) REFERENCES Student(RollNo)
ON DELETE CASCADE;
```

To add a foreign key constraint with no action:

```sql
ALTER TABLE Course
ADD CONSTRAINT fk_RollNo
FOREIGN KEY (RollNo) REFERENCES Student(RollNo)
ON DELETE NO ACTION;
```

In these queries, `fk_RollNo` is the name of the foreign key constraint being added.
