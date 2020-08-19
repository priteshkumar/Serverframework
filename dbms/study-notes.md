## Study notes on DBMS

> Transaction : logical unit of work ( set of sql queries executed as atomic unit)

Properties of transaction:
> ATOMIC

> CONSISTENT : data in database adheres to constraints/set rules before/after transaction

> ISOLATED 

> DURABLE : committed work is not lost , fault tolerant


### JDBC 

> interacts with dbms via JDBC driver 

> JDBC driver provides commnection to db

> implements protocol to translate query/information between jdbc api /database.



### Maven dependency scope

> MAVEN dependency can have one of  6 scopes:

`compile, test, runtime,import,provided,system`


### jdbc url format

`jdbc:<kind of the database>://<where the database is hosted>/<database name>`
