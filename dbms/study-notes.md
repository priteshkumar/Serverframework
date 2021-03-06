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


### Disadvantage of using jdbc

> Supports only native SQL , portability issues with different dbms

> Tight coupling between java code and SQL

> Hardcoding of column name/datatype in queries

> addition/modification of database tables is cumbersome


### Advantages Of ORM

> ORM automatically maps the object model of the application with the corresponding relational data model of the database.

> The abstraction of mapping between the object model and the database using ORMs helps to migrate from one database to another database.  

> It avoids the requirement of writing native SQL.



### JPA Info

**Entity**

> Entity :  java pojo annotated with @Entity to be persisted in database

> entity class cannot be declared final

> entity class must have a no arg constructor and a primary key

> @Table annotation is used to specify database table name mappped to corresponding entity

> @Transient annotation is used make a class field non persisted 


**Entity state changes**

> merge: Merge the state of the given entity into the current persistence context (detached -> persisted)

> persist : transient -> persisted/managed

> remove : remove from persistence context/as well as db

> find/getRef/queries : brings into managed/persisted state



### Persistence Context

(persistence context) https://www.baeldung.com/jpa-hibernate-persistence-context


### hibernate properties

 > hibernate.hbm2ddl.auto : exports ddl schema into database when entitymanager factory is created
 
 > it has 4 values:
 
 1)create
 
 2)update
 
 3)validate
 
 4)create-drop
 
 
 ### Entity Relationships
 
 **OneToMany/@ManyToOne**
 
 > Use below on One side or parent side:
 
`OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)`

`private List<Post> posts = new ArrayList<>();`
 

> Use below on many side
 
 `@ManyToOne(fetch = FetchType.EAGER)`
 
 `@JoinColumn(name = "user_id")`
 
 `private User user`
 
 
 > mappedBy value informs hibernate that there is user attribute on Many side which establishes OneToMany association
 
 > it also means User is parent class.
 
 > The ‘user’ attribute in the Post class behaves as a foreign key and references the ‘id’ column in the User class
 
 > Above is example of bidirectional relationship
 
 
 
 **ManyToMany** 
 
 > Use below on owning/parent side of relationship
 
 `@ManyToMany(mappedBy = "categories", fetch = FetchType.LAZY)`
 
  `private List<Post> posts = new ArrayList<>();`


> Use below on other side 

`@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)`

`private List<Category> categories = new ArrayList<>();`


**OneToOne**

> Use below in parent User class to define onetoone relationship

> In OneToOne association , any side can hold the foreign key

> In below code User class has attribute profile which acts as foreign key to user_profile table

> Here User class is parent entity and UserProfile is child entity

`@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)`

`@JoinColumn(name = "profile_id")`

`private UserProfile profile;`

