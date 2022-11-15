# Faircorp Smart Building

Faircorp is a backend project built with a spring framework to handle a smart building and all of its entities, including rooms with heaters and windows within them. It also enables the administrator to manage users and assign roles and access to them in the system.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Installing

Clone this github responsitory 
```
https://github.com/danutibeabasi/Faircorp-Web-Main
```

Open the project with your favorite IDE
```
Login Credential:
* username: admin
* password: password
```

## Running the tests

```
bash
./gradlew bootRun
```



## Project API

Test Apis on either [Localhost:8080] (http://localhost:8080/swagger-ui/) or on the Clevercloud server [Clevercloud](https://utibeabasidan.cleverapps.io/swagger-ui/

### Building 

#### Get all buildings
```
GET /api/buildings
```

#### Get a building by id   
```
GET /api/buildings/{id}
```

#### Create a new building
    
```
POST /api/buildings
```
- Request body:
```
{
  "id": 0,
  "name": "string"
}
```

 
#### Get all rooms of a building
```
GET /api/buildings/{id}/rooms
```

 
#### Update status of a heater in a building
```
PUT /api/buildings/{id}/switchHeaters
```

 
#### Switch the status of  windows in a building
```
PUT /api/buildings/{id}/switchHeaters
```

 
#### Delete a building by id
```
DELETE /api/buildings/{id}
```

---


### Room 

  
#### Get all rooms
```
GET /api/rooms
```

#### Get a room by id
```
GET /api/rooms/{id}
```

#### Create a new room
```
POST /api/rooms
```
- Request body:
```
{
  "buildingId": 0,
  "buildingName": "string",
  "currentTemperature": 0,
  "floor": 0,
  "heaters": [
    {
      "heaterStatus": "OFF",
      "id": 0,
      "name": "string",
      "power": 0,
      "room_Id": 0
    }
  ],
  "id": 0,
  "name": "string",
  "targetTemperature": 0,
  "windows": [
    {
      "id": 0,
      "name": "string",
      "room_Id": 0,
      "room_Name": "string",
      "status": "CLOSED"
    }
  ]
}
```

 
#### Update status of a heater in a room
```
PUT /api/rooms/{id}/switchHeaters
```

 
#### Switch the status of  windows in a room
```
PUT /api/rooms/{id}/switchWindows
```

#### Delete a room by id
```
DELETE /api/rooms/{id}
```
---
### Window Endpoints

 
#### Get all windows
```
GET /api/windows
```

 
#### Get a window by id
```
GET /api/windows/{id}
```


 
#### Create a new window
```
POST /api/windows
```
- Request body:
```
{
  "id": 0,
  "name": "string",
  "room_Id": 0,
  "room_Name": "string",
  "status": "CLOSED"
}
```

 
#### Switch the status of a window
```
PUT /api/windows/{id}/switch
```

 
#### Delete a window by id
```
DELETE /api/windows/{id}
```
----


### Heater 

 
#### Get all heaters
```
GET /api/heaters
```

#### GET /api/heaters/{id}
- Get a heater by id

#### POST /api/heaters
- Create a new heater
- Request body:
```
{
  "heaterStatus": "OFF",
  "id": 0,
  "name": "string",
  "power": 0,
  "room_Id": 0
}
```

#### Switch the status of a heater
```
PUT /api/heaters/{id}/switch
```

#### Delete a heater by id
```
DELETE /api/heaters/{id}
```
---

### User Endpoints

 
#### Get all users
```
GET /api/users
```

#### Get a user by username
```
GET /api/users/{username}
```

 
#### Create a new user
```
POST /api/users
```
- Request body:
```
{
  "id": 0,
  "name": "string",
  "password": "string",
  "role": {
    "id": 0,
    "name": "string"
  },
  "username": "string"
}
```
 
#### Create a new role
```
POST /api/roles
```

- Request body:
```
{
  "id": 0,
  "name": "string"
}
```

 
#### Add a role to a user
```
POST /api/users/addrole
```
- Request body:
```
{
  "roleName": "string",
  "username": "string"
}
```
---

## Built With

* [Spring](https://spring.io/) - The web framework used
* [Gradle](https://gradle.org/) - Dependency Management
* [IntelliJ](https://www.jetbrains.com/idea/) - IDE Used

## Author

* **Utibeabasi Dan** - [Github](https://github.com/danutibeabasi) - [Email](utibeabasi.dan@etu.emse.fr)

-  Tailored based on -  [Guillaume Ehret's course](https://dev-mind.fr/formations.html)


## Acknowledgments

* [Dev Mind - Guillaume Ehret's](https://dev-mind.fr/)

