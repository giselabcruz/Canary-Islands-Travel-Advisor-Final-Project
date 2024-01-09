# Canary Islands Travel Advisor Final Project


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
- [Postman](https://www.postman.com/) for API testing

# Funcionality

The project is centered on developing a travel advisor for the Canary Islands, focusing primarily on weather conditions and hotel accommodations. 

Modularity is present in this final project. It ensures flexibility, scalability, and ease of maintenance, allowing each component to function independently while contributing to the system's overall functionality. 

## Architecture

![Organized project modules](/images/Archetype-removebg-preview.png)

**DataLake**: Stores all relevant data, creating separate files for weather predictions and hotel data. 

**DataMart**: Processes and refines data for user queries. 

**BusinessUnit**: Accesses historical data from the DataLake. In this project, when no specific parameters or locations are provided, it displays stored DataLake information. So the businessUnit is connected to datalake. 


## API Implementation: 
A REST API is implemented for user interaction, utilizing Postman for testing API responses.

### OpenAPI Schema

```openapi: 3.0.0
info:
  title: Vacation Recommendation API
  version: 1.0.0
  description: An API for vacation recommendations based on hotels and weather predictions
paths:
  # Define your API paths here
components:
  schemas:
    Hotel:
      type: object
      properties:
        name:
          type: string
        location:
          type: string
        platformName:
          type: string
        price:
          type: number
        checkIn:
          type: string
        checkOut:
          type: string
    Weather:
      type: object
      properties:
        location:
          type: string
        date:
          type: string
        precipitation:
          type: number
        clouds:
          type: number
        temperature:
          type: number
        windSpeed:
          type: number
```

### Filter by Location
_________________________________________
Get all generalized information about hotels in the input location.

GET ```/api/vacation-recommendations?location=Gran_Canaria```
 
![Location](/images/Location.png)


### Filter by Temperature
_________________________________________
Get all hotels where the temperature of the Weather predictions of any location fulfill the criteria

GET ``` /api//vacation-recommendations?temperature=23```

![byTemperature](/images/byTemperature.jpg)

 

**Publisher/Subscriber Implementation:**
![Publisher/Subscriber](/images/publish-subscribe.png)
This application incorporates the Publisher/Subscriber pattern for working with events.
In this case, the broker is ActiveMQ, and it is installed as an application on the operating system.

This image shows all the Topics in activeMQ created in this project:
![Topics](/images/activeMQ.png)


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

# Design

## Class Diagram eventStoreBuilder:
![class_diagram_DatalakeBuilder](/images/datalakeBuilder.png)

## Class Diagram predictionProvider:
![class_diagram_PredictionProvider](/images/predictionProvider.png)

## Class Diagram hotelProvider:
![class_diagram_HotelProvider](/images/HOTELPROVIDER.png)

## Desing Patterns
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

Also, in this project, **Repository Pattern** has been implemented in the Business Unit for efficient data handling and CRUD operations. Used as reference this [blog](https://www.linkedin.com/pulse/what-repository-pattern-alper-sara%C3%A7). 

## Implemented Design Principles

### Single Responsibility:
Classes are designed with only one responsibility, and each class has only one reason to change.

### Interface Segregation:
Large interfaces have been divided into smaller ones.

### Dependency Inversion:
Instead of high-level modules depending on low-level modules, both depend on abstractions. This principle facilitates potential future modifications or project reusability as it relies on abstractions rather than concrete implementations. Consequently, the need to change the entire codebase is avoided and only the relevant abstractions need to be modified with the new business logic.

