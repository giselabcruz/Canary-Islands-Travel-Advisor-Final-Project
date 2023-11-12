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


# Funcionality

Java application that every 6 hours queries the service's API to obtain the weather forecast for the 8 Canary Islands for the next 5 days at 12:00:00 pm.

The weather data is persisted in an SQLite database, with a separate table for each island and an entry for each day. This entry include id, datetime, temperature, precipitation, humidity, clouds, and wind speed for each day.

## Resources Used
- Development Environment: IntelliJ IDEA
- Version Control Tools: Git and GitHub
- Build Automation: Maven
- Weather API: [OpenWeather 5 Day / 3 Hour Forecast API](https://openweathermap.org/forecast5)
- [SQLite Documentation](https://www.sqlite.org/docs.html)
- Documentation Tools: Markdown for README.md

## Important Libraries
### - com.google.gson.JsonObject
This project crucially relies on the __com.google.gson.JsonObject__ library to efficiently handle JSON data. Gson, developed by Google, is a powerful and widely-used Java library for serialization and deserialization of Java objects to and from JSON.

#### Why Gson?
- Robust JSON Handling: Gson provides a robust and flexible mechanism for working with JSON data, allowing seamless conversion between Java objects and JSON representations.

- Simplified Data Processing: The JsonObject class from Gson simplifies the manipulation and extraction of data from complex JSON structures, making it an essential tool for interacting with external APIs and handling weather forecast data.

- Compatibility: Gson is well-maintained and enjoys broad community support, ensuring compatibility with various JSON structures and keeping the project aligned with industry best practices.

The use of __com.google.gson.JsonObject__ in this project streamlines the processing of weather data retrieved from the OpenWeather 5 Day / 3 Hour Forecast API. The library enhances the project's capability to parse and manage JSON responses effectively, contributing to the overall reliability and efficiency of the application.


## Important Dependencies
#### *Note: Ensure that this libraries are included in your project dependencies for seamless integration and optimal functionality.*
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

## Class Diagram:
![class_diagram](/images/WeatherForecastCapturePersistence_API-Openweathermap.png)

## Desing Pattern
Various design patterns and principles were applied to achieve efficient and maintainable code.

Model-View-Controller (MVC) design pattern has been employed, with the caveat that the View layer has not been implemented due to user interface is no required for this practice.

## Implemented Design Principles
The SOLID principles have been diligently implemented to in this project.

### -Single Responsibility:
Classes are designed with only one responsibility, and each class has only one reason to change.

### -Open for Extension, Closed for Modification:
Existing code should not be modified if it is necessary to add new implementations in the future. That's why is open for extension but not for modification.

### -Interface Segregation:
Large interfaces have been divided into smaller ones.

### -Dependency Inversion:
There is a decoupling of software modules. Instead of high-level modules depending on low-level modules, both depend on abstractions. This principle facilitates potential future modifications or project reusability as it relies on abstractions rather than concrete implementations. Consequently, the need to change the entire codebase is avoided, and only the relevant abstractions need to be modified with the new business logic.

