DepositProcessor
================

Sample Spring Batch 2.1 Application (July 2012)

I wanted to create a sample application to learn about using and configuring Spring Batch 2.1. I set a simple challenge of loading a daily transaction log for account deposits into a database. I assumed that this file would be large, and the records needed to be loaded in a timely manner. The application has been designed to run on a single server. If an error occurs during the batch load, the entry is logged and the batch job continues.

The application is built using Java SE 1.6, uses Spring 2.5.6 / Batch 2.1 and Hibernate 3.6.8 for database ORM. C3p0 is used as connection pool implementation. Log4j is used for logging failed imports and JUnit / Mokito are used for testing (very rough tests as this was more of an exploration exercise).

The database used was mySQL 5.1.

The application uses Spring Batch 2.1 to handle the orchestration of the batch job. There is one Job configured with two flows. These flows run in parallel, one flow to read from the file and place the entry onto a queue, and one flow to read from the queue and write to the database. The first flow (reading from the file) is single threaded and places a group of messages onto the queue each time. The second flow (writing to the database) is multi threaded, each thread reading one message from the queue, transforming it from JSON to object form and persisting this to the database.

<h2>Configuration</h2>

Details to follow...

<h2><License</h2>

Copyright (c) 2013 Alex Ley.

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
