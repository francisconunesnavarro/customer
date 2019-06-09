
## Customer
* List all customers;
* Filter customers by Country or Phone Number State (Valid or not);
* Categorize customers by Country

### Requirements
JDK 8
Maven

### Running

`mvn spring-boot:run`

Available APIs are:\
http://localhost:8080/customers -> Retrieve all customers\
http://localhost:8080/customers/search?country=258&state=true -> Search all valid phone numbers from Mozambique\
http://localhost:8080/countries -> Retrieve all countries\
http://localhost:8080/countries/search?countryCode=212 -> Search information from Morroco

## Running unit tests
`mvn test`

#### Author
[Francisco Nunes Navarro](https://www.linkedin.com/in/francisconunesnavarro)
