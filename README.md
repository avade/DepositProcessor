DepositProcessor
================

Sample Spring Batch 2.1 Application (July 2012)

I wanted to create a sample application to learn about using and configuring Spring Batch 2.1. I set a simple challenge of loading a daily transaction log for account deposits into a database. I assumed that this file would be large, and the records needed to be loaded in a timely manner. The application has been designed to run on a single server. If an error occurs during the batch load, the entry is logged and the batch job continues.
The application is built using Java SE 1.6, uses Spring 2.5.6 and Hibernate 3.6.8 for dataThe application will run on a single server. access. C3p0 is used as connection pool implementation. Log4j is used for logging failed imports and JUnit / Mokito are used for testing (very rough tests as this was more of an exploration exercise).

The database used was mySQL 5.1.

The application uses Spring Batch 2.1 to handle the orchestration of the batch job. There is one Job configured with two flows. These flows run in parallel, one flow to read from the file and place the entry onto a queue, and one flow to read from the queue and write to the database. The first flow (reading from the file) is single threaded and places a group of messages onto the queue each time. The second flow (writing to the database) is multi threaded, each thread reading one message from the queue, transforming it from JSON to object form and persisting this to the database.
