# Weather Data Capture and Persistence From REST API [OpenWeather](https://openweathermap.org/api)


### University
University of Las Palmas de Gran Canaria

### Faculty
[Faculty Of Computer Science](https://www.eii.ulpgc.es/es)

### University Degree
[Data Science and Engineering](https://www.eii.ulpgc.es/es/formacion/Grado-en-Ciencia-e-Ingenieria-de-Datos)

### Subject
Data Science Application Development

### Academic Year
2023

## Resources Used
- Development Environment: IntelliJ IDEA
- Version Control Tools: Git and GitHub
- Build Automation: Maven
- Weather API: [OpenWeather 5 Day / 3 Hour Forecast API](https://openweathermap.org/forecast5)
- [SQLite Documentation](https://www.sqlite.org/docs.html)
- Documentation Tools: Markdown for README.md
- [Documentation ActiveMQ Broker](https://activemq.apache.org/using-activemq)

# Funcionality

This Java application serves as a weather forecast system for the 8 Canary Islands, querying the service's API every 6 hours. It retrieves weather data for the next 5 days at 12:00:00 pm. 

**Publisher/Subscriber Implementation:**
![Publisher/Subscriber](/images/publish-subscribe.png)
This application incorporates the Publisher/Subscriber pattern. The project is structured into modules, with the **Prediction Provider** and **Event Store Builder** as separate components.
In this case, the broker is ActiveMQ, and it is installed as an application on the operating system.

### Provider Module
The Provider module retrieves meteorological data at the specified frequency, generating a JSON-formatted event with information from the weather service.

The event structure includes timestamp, source (prediction-provider), prediction timestamp, and location (latitude and longitude).
Additionally, it incorporates the weather metrics as temperature, wind speed, humidity, precipitation and clouds in the OpenWeatherMap API request.

The event is sent to the "prediction.Weather" topic.

### Broker - ActiveMQ
ActiveMQ serves as the broker, facilitating communication between the Prediction Provider and Event Store Builder modules.

### Event Store Builder Module

The Event Store Builder module subscribes to the "prediction.Weather" topic, storing events in a temporally ordered directory structure.

Events are serialized and organized into files based on the timestamp, with the following directory structure: *eventstore/prediction.Weather/{ss}/{YYYYMMDD}.events*


## Important Libraries
### - com.google.gson.JsonObject
This project crucially relies on the __com.google.gson.JsonObject__ library to efficiently handle JSON data. Gson, developed by Google, is a powerful and widely-used Java library for serialization and deserialization of Java objects to and from JSON.

#### Why Gson?
- Robust JSON Handling: Gson provides a robust and flexible mechanism for working with JSON data, allowing seamless conversion between Java objects and JSON representations.

- Simplified Data Processing: The JsonObject class from Gson simplifies the manipulation and extraction of data from complex JSON structures, making it an essential tool for interacting with external APIs and handling weather forecast data.

- Compatibility: Gson is well-maintained and enjoys broad community support, ensuring compatibility with various JSON structures and keeping the project aligned with industry best practices.

The use of __com.google.gson.JsonObject__ in this project streamlines the processing of weather data retrieved from the OpenWeather 5 Day / 3 Hour Forecast API. The library enhances the project's capability to parse and manage JSON responses effectively, contributing to the overall reliability and efficiency of the application.


## Important Plugin
### Apache Copy-Dependencies

The Maven Copy-Dependencies Plugin is a valuable tool for managing project dependencies by copying them from the local repository to a specified directory.

```xml
<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-dependency-plugin</artifactId>
            <version>3.1.2</version>
            <executions>
                <execution>
                    <id>copy-dependencies</id>
                    <phase>package</phase>
                    <goals>
                        <goal>copy-dependencies</goal>
                    </goals>
                    <configuration>
                        <outputDirectory>${project.build.directory}/dependencies</outputDirectory>
                    </configuration>
                </execution>
            </executions>
        </plugin>
    </plugins>
</build>
```
This is particularly useful for packaging and distributing the applications along with its dependencies.

## Important Dependencies

The following Maven dependencies are included in this project's `pom.xml` file:

### - org.apache.httpcomponents.client5
This project relies on the Apache HttpClient library (Version 5.2.1) to facilitate robust and efficient HTTP communication.
Apache HttpClient is a mature and widely-used Java library that provides powerful features for making HTTP requests and handling responses.

#### Key Features:
- HTTP Protocol Support: Apache HttpClient supports various versions of the HTTP protocol, allowing seamless communication with web services and APIs.

- Connection Management: The library offers sophisticated connection management, ensuring optimal usage of network resources and minimizing latency.

- Request and Response Handling: Apache HttpClient simplifies the process of crafting HTTP requests and processing responses, making it an integral part of this project's functionality.

#### Integration in this Project:

```xml
<dependency>
    <groupId>org.apache.httpcomponents.client5</groupId>
    <artifactId>httpclient5</artifactId>
    <version>5.2.1</version>
</dependency>
```

The inclusion of __org.apache.httpcomponents.client5__ is essential for the proper functioning of HTTP-related tasks, such as querying external API for weather data.


### - org.slf4j
SLF4J (Simple Logging Facade for Java) provides a flexible logging interface for better logging within the application. It allows you to choose and configure the underlying logging implementation.

#### Key Benefits:
- Logging Abstraction: SLF4J serves as a logging facade, allowing for a consistent logging API while providing the flexibility to choose and configure the underlying logging implementation.

- Ease of Integration: By using SLF4J, this project ensures smooth integration with various logging frameworks, enabling developers to use their preferred logging implementation.

- Efficient Logging: SLF4J optimizes logging statements, avoiding unnecessary computation if the logging level is not enabled. This ensures efficient logging in both development and production environments.

#### Integration in this Project:

```xml
<dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>slf4j-api</artifactId>
    <version>2.0.9</version>
</dependency>
```


# Design

## Class Diagram eventStoreBuilder:
![class_diagram_EventStoreBuilder](/images/eventStoreBuilder.png)

## Class Diagram predictionProvider:
![class_diagram_PredictionProvider](/images/predictionProvider.png)

## Desing Pattern
In this project, **Clean Architecture** has been implemented.

![Clean_Architecture](/images/CleanArchitecture.png)

### ¿Why?

Clean architecture puts the business logic (Application) and application model (Domain) at the centre of the application together called as Core.

The Core has to be completely independent of data access and other infrastructure concerns, so we invert the dependencies. This is achieved by adding interfaces or abstractions in Core that are implemented by layers outside of Core. For example, we need to implement the Repository Pattern we would add an interface within Core and add the implementation within Infrastructure.Data.

All dependencies flow inwards and Core has no dependency on any other layer.

Infrastructure and Presentation depend on Core, but not on one another.

Also, if in the future we need to change the broker, with this architecture will be much easier.

In essence, Clean Architecture promotes a flexible and scalable code structure.


### GitHub repositories that have been used as a reference:

[CleanArchitecture by jasontaylordev](https://github.com/jasontaylordev/CleanArchitecture): This repository is an implementation of Clean Architecture in .NET, and it serves as a reference for applying Clean Architecture principles in real-world projects. While the programming language and platform are different (Java in this case), the architectural concepts remain applicable.

[buckpal by thombergs](https://github.com/thombergs/buckpal): This repository is an example application for implementing Clean Architecture in Java. It demonstrates how to structure a Java application following Clean Architecture principles.


## Implemented Design Principles
The SOLID principles have been diligently implemented to in this project.

### Single Responsibility:
Classes are designed with only one responsibility, and each class has only one reason to change.

### Open for Extension, Closed for Modification:
Existing code should not be modified if it is necessary to add new implementations in the future. Therefore, it is open for extension but not for modification.

### Interface Segregation:
Large interfaces have been divided into smaller ones.

### Dependency Inversion:
Instead of high-level modules depending on low-level modules, both depend on abstractions. This principle facilitates potential future modifications or project reusability as it relies on abstractions rather than concrete implementations. Consequently, the need to change the entire codebase is avoided and only the relevant abstractions need to be modified with the new business logic.

______________________________________________________________________________________________
In addition, the __principles of modularity, cohesion and abstraction__ have been implemented.

### __Modularization__:
Is a key principle that emphasizes the organization of code into independent, self-contained modules or components. 


### __Cohesion__:
Refers to the degree to which elements within a module or component work together to achieve a common goal.

### __Abstraction__:
Involves simplifying complex systems by modeling classes or components at the appropriate level of detail.
