## SpringCurrency

General Info
------------
> Spring Currency is a fullstack web application used to retrieve exchange rate info from TCMB. This is the Backend part of the project.<br>


#### Installation
- PostgreSQL, JDK and an IDE is required.
- Download the project and open it with an IDE (IntelliJ IDEA is used for this project)
- This backend REQUIRES PostgreSQL.
- In the src > main > resources > application.properties, there are configurations for the LOCAL database this project uses.
> spring.datasource.url = jdbc:postgresql://localhost:5432/springcurrency</br>
spring.datasource.username = postgres</br>
spring.datasource.password = admin</br></br>
spring.jpa.show-sql = true</br>
spring.jpa.generate-ddl = true</br>
spring.jpa.hibernate.ddl.auto = update</br>

- You should change these properties to: 
> - your postgres user username
> - your postgres user password
> - your database name (replace springcurrency with your db name)
> - !Important Create a table with this SQL Query:
> > CREATE TABLE users(
> > id SERIAL PRIMARY KEY,
> > username VARCHAR(32),
> > password VARCHAR(100)
> > );
- Build and run the main function.
- The backend will run on http://localhost:8080
