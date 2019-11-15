### Relevant :

git clone https://github.com/ericksonneres/spring-data-jpa-3.git

cd spring-data-jpa-3

mvn install

mvn clean spring-boot:run


GET: http://localhost:8080/places
GET: http://localhost:8080/places/{name}
PUT: http://localhost:8080/places/Amy
DELETE: http://localhost:8080/places/{placeId}
POST: http://localhost:8080/places/Amy

Payload Request:
{
    "placeId": 1,
    "name": "Amy",
    "slug": "",
    "city": "Osasco",
    "state": "SP",
    "createdAt": "2019-11-15T18:30:03.078+0000",
    "updatedAt": "2019-11-15T18:30:03.078+0000"
}
