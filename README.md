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

