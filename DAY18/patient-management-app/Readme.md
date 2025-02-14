## RabbitMq application

### Build application

    mvn clean install

### Running Application

#### Start docker compose

    docker-comnpose up

#### Start producer to send message

    mvn spring-boot:run

#### Send message to producer using rest

Patient:
Post:
curl --location 'http://localhost:8081/patie
nt/send' \
--header 'disease: fiver' \
--header 'Content-Type: application/json' \
--header 'Authorization: Basic UEFUSUVOVDpwYXNzd29yZDI=' \
--header 'Cookie: JSESSIONID=498B275E6D9F28EADB58900B42281F67' \
--data '{
"name":"Daksha"
"id":"1",
"hospitalName": "abc",
"age": 24,
"gender": "M"

}'

Doctor:
Get:
curl --location 'http://localhost:8082/doctor/receive' \
--header 'Authorization: Basic RE9DVE9SOnBhc3N3b3JkMQ==' \
--header 'Cookie: JSESSIONID=6A79478B55A7F25551DD51253E883ED1' \
--data ''