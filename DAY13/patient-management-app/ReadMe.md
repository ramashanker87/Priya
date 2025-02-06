# Application for Patient  Information

## Build application with maven

```Bash
mvn clean install
```

## Run Application with maven

```Bash
mvn spring-boot:run
```

## Verify End Point Controller

### Verify application Health

```Bash
curl --location 'http://localhost:8080/actuator/health'
```

### Create Patient

```Bash
curl --location 'http://localhost:8080/patient/create/patient' \
--header 'Content-Type: application/json' \
--header 'Authorization: Basic ZG9jdG9yOnBhc3N3b3JkMQ==' \
--header 'Cookie: JSESSIONID=9B63D7393680E2E41CB13C2CAD4B8702' \
--data '{
     "name":"patient1",
     "id": "p1",
     "hospitalName":"hospital1",
     "age":55,
     "gender":"M"
}'
```

```Bash
Post http://localhost:8080/patient/create/patient
```

### Read All Patient Data

```Bash
curl --location 'http://localhost:8080/patient/get/all/patient' \
--header 'Authorization: Basic ZG9jdG9yOnBhc3N3b3JkMQ==' \
--header 'Cookie: JSESSIONID=9B63D7393680E2E41CB13C2CAD4B8702'
```
```Bash
Get http://localhost:8080/patient/get/all/patient

```
### Update Patient Data

```Bash
curl --location --request PUT 'http://localhost:8080/patient/update/patient?id=p1&hospitalName=hospital4' \
--header 'Authorization: Basic ZG9jdG9yOnBhc3N3b3JkMQ==' \
--header 'Cookie: JSESSIONID=9B63D7393680E2E41CB13C2CAD4B8702' \
--data ''
```
```Bash
Update http://localhost:8080/patient/update/patient?id=p1&hospitalName=hospital4
```
### Delete Patient Data

```Bash
curl --location --request DELETE 'http://localhost:8080/patient/delete/patient?id=p1' \
--header 'Authorization: Basic ZG9jdG9yOnBhc3N3b3JkMQ==' \
--header 'Cookie: JSESSIONID=D66587758DB06AD05D86CB5FF54B950A'
```

```Bash
Delete http://localhost:8080/patient/delete/patient?id=p1
```
## Import project
Import the project on either eclipse or inellij as a maven import project

## Dockerization

```
$ mvn install dockerfile:build
```
## List docker images
```
$ docker images
```

### Running the application in docker container

```
$ docker run -p 8080:8082 patient-management-app:0.0.1
```

## List docker running container

```
$ docker ps
```



