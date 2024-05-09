database

docker run --name postgres -d -p 5432:5432 -e POSTGRES_PASSWORD=@pass0rd@@@ -e POSTGRES_USER=dimitris -e POSTGRES_DB=eshop postgres:alpine

swagger

http://localhost:5001/swagger-ui/index.html

------
Maven Execution
```console
mvn exec:java
```
------

------
model, repository, service, controller

------ 
enum
ResponseEntity
--ResponseApi
model inheritance

----------------------------------
Exercise
0.  create the model, repository, service, controller for the customer
1. create 20 fake rows for product and customer classes
2. create an endpoint in the controller that increases all the products price by a specified percentage (eg. 3%)
3. create an endpoint in the controller that makes zero the balances of the customers.
4. change the price of the products to BigDecimal
5. create an endpoint in the controller that calculates the total cost of the products

-----------------------------------------------------------
JPQL
validation

------------------------

------
relationships between models
------------------------
dto data transfer objects
mapper
------
security -> authentication, authorization


what should I test in a Java Spring Boot application

