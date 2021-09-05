# Backend API for manage expense

![Master Branch](https://github.com/codeur47/e-expense-api/workflows/Master%20Branch/badge.svg) [![Coverage](https://sonarcloud.io/api/project_badges/measure?project=codeur47_e-expense-api&metric=coverage)](https://sonarcloud.io/dashboard?id=codeur47_e-expense-api) [![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=codeur47_e-expense-api&metric=alert_status)](https://sonarcloud.io/dashboard?id=codeur47_e-expense-api)

This is a simple RESTful CRUD API (Create Read Update Delete) application for managing user expense saved in PostgreSQL database. It provides basic REST endpoints like fetching all objects of given type, finding them by their id, creating them and so on.


## Usage

An application expose 5 REST endpoints for each entity. For example *Category* (and any other) they are:

* **GET** `{baseURL}/category/` - lists all *Categories* (as Json array),
* **GET** `{baseURL}/category/{id}` - gets single *Category* (as Json) by its `{id}`,
* **POST** `{baseURL}/category/` - creates a new *Category* which is passed in the BODY of the request,
* **PUT** `{baseURL}/category/{id}` - updates an existing *Category* (with an `{id}`) with `Notice` passed in the body of the request,
* **DELETE** `{baseURL}/category/{id}`- deletes an existing *Category* by its `{id}`.


If you run this application locally the `{baseUrl}` would be `http://localhost:8080`. 

All available endpoints are listed on *Swagger UI* page which can be entered, when application is running, under *http://localhost:8080/swagger-ui.html* URL.



## Installation

#### Run

Before running the application make sure that you are running PostgreSQL database on your local machine.

In order to run it use following command:

```shell script
mvn clean spring-boot:run
```

#### Integration tests

In this project there are located several integration tests for REST endpoints during which H2 database is used. To run those tests activate Mavan `-P integration-test` profile:

```shell script
mvn clean verify -P integration-test
```

## License 

The MIT License - 2021 - Ange Carmel YORO
