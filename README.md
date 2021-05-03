# README #

### Setting up ###

* Requires a local install of a MariaDB
* Create a database called nace and add user access:

```
create database nace;
grant all privileges on nace.* to 'nace'@'localhost';
```

* Start the application:

```
cd dbexercise
./mvnw clean package
java -jar target/dbexercise-0.0.1-SNAPSHOT.jar
```

* Open the swagger API and upload the NACE_REV2_20210501_154027.csv file to the putNaceDetails endpoint:

```
http://localhost:8080/swagger-ui.html
``` 

* Confirm the data has been added to the database:

```
select count(*) from nace_items;
+----------+
| count(*) |
+----------+
|      996 |
+----------+
```

* Retrieve a NACE item in JSON format by calling the API:

```
http://localhost:8080/api/getNaceDetails/398481
```