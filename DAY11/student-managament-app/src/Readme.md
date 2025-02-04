### Build Application
    mvn clean install
### Start Data Base using docker

    docker-compose up

### Verify the running container

    docker ps

### Verify database

#### Windows
    docker exec -it container_name_or_id bash

#### Linux
    docker exec -it container_name_or_id /bin/bash

### Connect to mysql database

    mysql -u user -p
### Show database

    show databases;

### Select the database

    use test;

### Display the table

    show tables;

### Execute mysql query

    select * from users;

### Exit from docker container
    exit

### Start the spring application

    mvn spring-boot:run

### Test With curl command

    curl -X POST 'http://localhost:8080/user/save' \
    --header 'Content-Type: application/json' \
    --data-raw '{
    "name": "Rama",
    "email": "rama@example.com"
    }
    '

    curl -X GET 'http://localhost:8080/user/read'

### Access Data Base user interface

    http://localhost:8081/


### Down the docker container

    docker-compose down
