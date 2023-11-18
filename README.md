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

__Model-View-Controller (MVC)__ design pattern has been employed, with the caveat that the View layer has not been implemented due to the absence of a required user interface for this practice.

### __Model__:
Represents the data and business logic of the application, managing data manipulation and persistence. It is independent of the user interface and handles business rules. In the Model package, you will find the business logic for Weather and Location, as well as data manipulation in persistence through the Interface WeatherRepository and the Class WeatherRepositorySQLite.

### __View__:
Although not implemented in this case as a graphical one, it would be responsible for presenting data to the user and receiving user input. It displays information to the user in an understandable manner, like graphical. In this case, the only user interface is through the Command Line.

### __Controller__:
Acts as an intermediary between the Model and the View. It receives user inputs and updates the Model accordingly. It manages the flow of control logic and interactions between the View and the Model.


## Implemented Design Principles
The SOLID principles have been diligently implemented to in this project.

### Single Responsibility:
Classes are designed with only one responsibility, and each class has only one reason to change.

### Open for Extension, Closed for Modification:
Existing code should not be modified if it is necessary to add new implementations in the future. Therefore, it is open for extension but not for modification.

### Interface Segregation:
Large interfaces have been divided into smaller ones.

### Dependency Inversion:
Instead of high-level modules depending on low-level modules, both depend on abstractions. This principle facilitates potential future modifications or project reusability as it relies on abstractions rather than concrete implementations. Consequently, the need to change the entire codebase is avoided and only the relevant abstractions need to be modified with the new business logic. In this project, you can see Interface WeatherRepository in the Model logic, but also you can identify an another in the Controller and it's WeatherProvider.

______________________________________________________________________________________________
In addition, the __principles of modularity, cohesion and abstraction__ have been implemented.

### __Modularization__:
Is a key principle that emphasizes the organization of code into independent, self-contained modules or components. 

_In this project_:
The code is divided into distinct packages, such as Model and Controller, promoting a modular structure.
Each package encapsulates related functionality, making it easier to understand, maintain, and extend.
Modularization enhances code reuse, as individual modules can be developed, tested, and updated independently.

### __Cohesion__:
Refers to the degree to which elements within a module or component work together to achieve a common goal.

_In this project_:
The Model package demonstrates high cohesion by encapsulating related classes and interfaces responsible for data manipulation, business logic (Weather and Location), and persistence (WeatherRepository).
The separation of concerns within each package enhances the clarity of responsibilities, contributing to higher cohesion.

### __Abstraction__:
Involves simplifying complex systems by modeling classes or components at the appropriate level of detail.

_In this project_:
Abstraction is evident in the use of interfaces (e.g., WeatherRepository) to define a contract without specifying implementation details. This allows for interchangeable implementations, adhering to the Dependency Inversion principle.
The Model package abstracts away the internal details of data manipulation and persistence, providing a higher-level interface for interaction.
