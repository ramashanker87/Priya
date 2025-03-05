Build application

    mvn clean install

### Running Application

#### Start docker compose

    docker-comnpose up


### SQL

docker exec -it container_name_or_id /bin/bash

### Connect to mysql database

    mysql -u user -p
### Show database

    show databases;

### Select the database

    use test;

### Display the table

    show tables;
| car            |
| parking_end    |
| parking_start |

### Execute mysql query

    select * from car;

    select * from parking_end;
    select * from parking_start;

### Exit from docker container
    exit



#### Start producer to send message

    mvn spring-boot:run

### Rabbit MQ link:
http://localhost:15672/#/queues

#### Send message to producer in parking Start and getting response

curl --location 'http://localhost:8081/parking/start?parkingNo=123' \
--header 'Content-Type: application/json' \
--data '


{
"ownerName": "John Doe",
"regNo": "ABC1234",
"module": "Sedan",
"type": "Petrol"
}
'

#### Send message to producer in parking End and getting response
curl --location --request POST 'http://localhost:8081/parking/end?regNo=ABC1234'




### Down the docker container

    docker-compose down

    '