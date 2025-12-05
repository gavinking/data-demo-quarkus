# Demo app for Hibernate Data Repositories on Quarkus

[Hibernate Data Repositories](https://hibernate.org/repositories) is an implementation of Jakarta Data backed by Hibernate ORM.
This project shows Hibernate Data Repositories used from Quarkus RESTEasy Classic.

Here we observe:

- Jakarta Persistence annotations used to declare and map entity types like `Book`, `Author`, and `Publisher`,
- Jakarta Data annotations used to declare a `Library` repository acting as a facade to Hibernate's `StatelessSession`, and
- JAX-RS annotations used to declare the frontend `LibraryResource`, with `Library` injected via CDI.

This is the Gradle version. There's also a [Maven version](https://github.com/gavinking/data-demo-quarkus-mvn). 

## Dependencies:

- Quarkus 3.30, with RESTEasy Classic and Jackson
- Jakarta Data 1.0.1
- Hibernate Processor 7.1

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
./gradlew quarkusDev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:

```shell script
./gradlew build
```

It produces the `quarkus-run.jar` file in the `build/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `build/quarkus-app/lib/` directory.

The application is now runnable using `java -jar build/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:

```shell script
./gradlew build -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar build/*-runner.jar`.

## Creating a native executable

You can create a native executable using:

```shell script
./gradlew build -Dquarkus.package.type=native
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using:

```shell script
./gradlew build -Dquarkus.package.type=native -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./build/data-demo-quarkus-1.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/gradle-tooling.

## Related Guides

- Hibernate ORM ([guide](https://quarkus.io/guides/hibernate-orm)): Define your persistent model with Hibernate ORM and
  Jakarta Persistence
- JDBC Driver - H2 ([guide](https://quarkus.io/guides/datasource)): Connect to the H2 database via JDBC
- RESTEasy Classic ([guide](https://quarkus.io/guides/resteasy)): REST endpoint framework implementing Jakarta REST and
  more

## Provided Code

### Hibernate ORM

Create your first JPA entity

[Related guide section...](https://quarkus.io/guides/hibernate-orm)

### RESTEasy JAX-RS

Easily start your RESTful Web Services

[Related guide section...](https://quarkus.io/guides/getting-started#the-jax-rs-resources)
