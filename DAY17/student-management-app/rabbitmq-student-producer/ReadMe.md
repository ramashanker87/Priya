## RabbitMq application

### Build application

    mvn clean install

### Running Application

#### Start docker compose

    docker-comnpose up

#### Start producer to send message

    mvn spring-boot:run

#### Send message to producer using rest

Post:

curl --location 'http://localhost:8082/student/save' \
--header 'Content-Type: application/json' \
--data '{
"id":"1",
"name":"priya",
"schoolName":"abc",
"age": 25,
"gender":"M"
}'

Delete:

curl --location --request DELETE 'http://localhost:8082/student/delete?name=priya'
