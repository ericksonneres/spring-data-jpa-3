### Relevant :

git clone https://github.com/ericksonneres/spring-data-jpa-3.git

cd spring-data-jpa-3

mvn install

mvn clean spring-boot:run


GET: http://localhost:8080/places

GET: http://localhost:8080/places/{name}

PUT: http://localhost:8080/places

DELETE: http://localhost:8080/places/{placeId}

POST: http://localhost:8080/places

Payload Request (POST/PUT):

{
    "placeId": 1,
    "name": "Amy",
    "slug": "",
    "city": "Osasco",
    "state": "SP",
    
}
