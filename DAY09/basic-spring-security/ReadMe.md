## Spring Basic Security

### Build Maven Project

    mvn clean install

### Start Project

    mvn spring-boot;run

### Test endpoint with curl

    curl -X GET http://localhost:8080/greet -u user1:password1
    curl -X POST http://localhost:8080/hello -u admin1:password1
    curl -X PUT http://localhost:8080/hi -u admin1:password1
    curl -X DELETE http://localhost:8080/thanks -u admin1:password1

