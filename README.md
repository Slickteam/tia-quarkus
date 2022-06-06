# tia-quarkus

Demo project for tool-in-action on Quarkus

## Project configuration

This project was initialised with these extensions :
* RESTEasy Classic
* RESTEasy Classic Jackson
* JDBC Driver - PostgreSQL
* Hibernate ORM with Panache
* Flyway
* OpenID Connect

## Using Quarkus CLI

You can generate the same base project with this command:

```
quarkus create app -x io.quarkus:quarkus-resteasy,io.quarkus:quarkus-resteasy-jackson,io.quarkus:quarkus-jdbc-postgresql,io.quarkus:quarkus-hibernate-orm-panache,io.quarkus:quarkus-flyway,io.quarkus:quarkus-oidc --gradle-kotlin-dsl fr.slickteam.tiaquarkus:tia-quarkus
```

## RBA endpoints tests

To have role based endpoints tested (with Keycloack dev server), you must add this dependency:
```
testImplementation("io.quarkus:quarkus-test-keycloak-server")
```