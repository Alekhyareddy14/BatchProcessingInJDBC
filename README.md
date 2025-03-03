Batch Processing in JDBC:
Batch processing is a technique in JDBC that allows executing multiple SQL queries in a batch instead of executing them one by one. This improves performance by reducing the number of database calls and increasing efficiency.
Why Use Batch Processing?
1.	Performance Boost → Reduces communication between Java application and the database.
2.	Efficient Resource Usage → Avoids repeated compilation of SQL statements.
3.	Reduces Execution Time → Processes multiple queries in one go instead of sending them individually.
How Batch Processing Works in JDBC?
•	Instead of executing SQL statements one by one, you add them to a batch using addBatch().
•	Once all statements are added, you call executeBatch() to execute them at once.

