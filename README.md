# simpleRestService
A simple REST service using Spring Boot 

## Usage

The relevant endpoint for this application is ``/employees`` and ``/employees/data``. 
All endpoints have the basic CRUD actions.

To test the service in localhost using CURL, please follow these endpoints with the CURL commands:

GET for getting all data for the entity (/path)
```sh
curl -v http://localhost:8080/employees
```

GET for getting id (/path/{key})
```sh
curl -v http://localhost:8080/employees/key1
```

GET for getting key-value data (/path/data/{key})
```sh
curl -v http://localhost:8080/employees/data/key1
```

POST(/path)
```sh
curl -d "{\"id\":04,\"name\":\"Employee 04\",\"description\":\"some random description\"}" -H "Content-Type: application/json"   http://localhost:8080/employees
```

PUT (path/{key})
```sh
curl -X PUT -H "Content-Type: application/json" -d "{\"id\":\"01\",\"name\":\"foobar\",\"description\":\"babla\"}" "http://localhost:8080/employees/key1"
```

DELETE (path/{key})
```sh
curl -X DELETE http://localhost:8080/employees/key1
```
