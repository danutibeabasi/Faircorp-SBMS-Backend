# Faircorp Smart Building Management System

A backend project built with a spring framework to handle a smart building and all of its entities, including rooms with heaters and windows within them. It also enables the administrator to manage users and assign roles and access to them in the system.

## Table of Contents

* [Getting Started](#getting-started)
* [API Reference](#api-reference)
* [Project Architecture](#project-architecture)
* [Documentation](#documentation)
* [Known Issues](#known-issues)
* [Contact](#contact)
* [Built With](#built-with)
* [Dependencies](#dependencies)
* [Contributing](#contributing)
* [License](#license)

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

1. Clone this github repository: https://github.com/danutibeabasi/Faircorp-Web-Main
2. Open the project with your favorite IDE
3. Run the tests using the command `./gradlew bootRun`

Login Credentials:
* username: admin
* password: password

## API Reference

Test the APIs on either [Localhost:8080](http://localhost:8080/swagger-ui/) or on the Clevercloud server [Clevercloud](https://utibeabasidan.cleverapps.io/swagger-ui/).

Building:
* Get all buildings: GET /api/buildings
* Get a building by id: GET /api/buildings/{id}
* Create a new building: POST /api/buildings
* Get all rooms of a building: GET /api/buildings/{id}/rooms
* Update status of a heater in a building: PUT /api/buildings/{id}/switchHeaters
* Switch the status of windows in a building: PUT /api/buildings/{id}/switchHeaters
* Delete a building by id: DELETE /api/buildings/{id}

Room:
* Get all rooms: GET /api/rooms
* Get a room by id: GET /api/rooms/{id}
* Create a new room: POST /api/rooms
* Update status of a heater in a room: PUT /api/rooms/{id}/switchHeaters
* Switch the status of windows in a room: PUT /api/rooms/{id}/switchWindows
* Delete a room by id: DELETE /api/rooms/{id}

Window Endpoints:
* Get all windows: GET /api/windows
* Get a window by id: GET /api/windows/{id}
* Create a new window: POST /api/windows
* Switch the status of a window: PUT /api/windows/{id}/switch
* Delete a window by id: DELETE /api/windows/{id}

Heater:
* Get all heaters: GET /api/heaters
* GET /api/heaters/{id}
* Get a heater by id: POST /api/heaters
* Create a new heater: PUT /api/heaters/{id}/switch
* Switch the status of a heater: DELETE /api/heaters/{id}

User Endpoints:
* Get all users: GET /api/users
* Get a user by username: GET /api/users/{username}
* Create a new user: POST /api/users
* Delete a user by username: DELETE /api/users/{username}
* Update a user: PUT /api/users

## Project Architecture

This project is built using the Spring Boot framework and is designed to manage the entities of a smart building, including rooms, heaters, and windows. It also
allows the administrator to manage users and assign roles and access to them in the system.

## Documentation

For more detailed documentation on the project, see the [API Reference](#api-reference) section above or visit the [Clevercloud](https://utibeabasidan.cleverapps.io/swagger-ui/) server to test the APIs.

## Known Issues

There are currently no known issues with the project.

## Contact

For any questions or assistance with the project, you can contact the maintainers at [EMAIL ADDRESS](mailto:dautibeabasi@gmail.com).

## Built With

* [Spring Boot](https://spring.io/projects/spring-boot) - The web framework used
* [Gradle](https://gradle.org/) - Dependency Management

## Dependencies

This project relies on the following third-party dependencies:
* [Spring Boot](https://spring.io/projects/spring-boot)
* [Swagger](https://swagger.io/)

## Contributing

To contribute to the project, please follow the guidelines outlined in the [CONTRIBUTING](CONTRIBUTING.md) file.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for more details.

