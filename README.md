# Weather Data Capture and Persistence From REST API [OpenWeather](https://openweathermap.org/api)


### University
University of Las Palmas de Gran Canaria

### Faculty
Faculty Of Computer Science

### University Degree
Data Science and Engineering

### Subject
Data Science Application Development

### Academic Year
2023


# Funcionality

Java application that every 6 hours queries the service's API to obtain the weather forecast for the 8 Canary Islands for the next 5 days at 12 a.m.

The acquired data is persisted in an SQLite database, with a separate table for each island and an entry for each day. This entry include temperature, precipitation, humidity, cloud cover, and wind speed for each day.

## Resources Used
- Development Environment: IntelliJ IDEA
- Version Control Tools: Git and GitHub
- Weather API: [OpenWeather 5 Day / 3 Hour Forecast API](https://openweathermap.org/forecast5)
- [SQLite Documentation](https://www.sqlite.org/docs.html)


# Design

In this project, various design patterns and principles were applied to achieve efficient and maintainable code.

### Class Diagram:

### Implemented Design Principles
In this project, the Model-View-Controller (MVC) design pattern has been employed, with the caveat that the View layer has not been implemented. This is due to user interface is no required for this practice.

Furthermore, the SOLID principles have been diligently implemented to in our software design.
#### Single Responsibility:

_________________________________
#### Open/Closed:
 
________________________________
#### Interface Segregation:
It is observable within the Controller.
________________________________
#### Dependency Inversion:
This principle allows for potential future modifications or project reusability since it relies on abstractions rather than concrete implementations. Consequently, the need to change the entire codebase is avoided and only the relevant abstractions need to be modified with the new business logic.
________________________________





