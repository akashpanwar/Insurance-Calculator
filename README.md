# Insurance-Calculator

# 1.	MicroServices Architecture:

**Insurance Service:**

This is used to calculate the given insurance based on vehicleType, mileage, and regionalClass. This is also used to fetch all the insurance records present in the DB.

Method	URI	Operation

GET :	**/getAllInsuranceTransactions**	- To retrieve the insurance information present in database

POST :	**/calculateInsurance/{insuranceBody}**	- To calculate the insurance based on the insurance request.

**Payment Service:**

This is used to fetch and insert transactions done against an insurance. A scheduler runs at every 2 minutes to process the pending transactions.
Method	URI	Operation

GET :	**/transactions/{quotationId}** -	To retrieve list of transactions for a given Quotation Id

POST :	**/addTransaction** -	To insert a transaction for insurance.

**Utility Service:**

This is used to upload csv and send email to particular user. It is all used to fetch the state, county, postalcode from database.

Method	URI	Operation

POST :	**/upload/{csvPath}** -	To upload a file from a given location.

POST :	**/email/{id}** -	To send email based on quotation id.

POST :	**/emailRecipient**	- To send email based on quotation id and recipient.

GET :	**/state**	- To retrieve all the state from the database.

GET :	**/county** - 	To retrieve all the county from the database.

GET :	**/countyName/{state}** - 	To retrieve all the county associated with particular state from the database.

GET :	**/postalCode** - 	To retrieve all the postal code from the database.

GET :	**/postalCodeCounty/{county}** -	To retrieve all the postal code associated with particular county from the database.

GET :	**/postalCodeState/{state}** -	To retrieve all the postal code associated with particular state from the database.

# 2.	Rest Template:

Rest Template is being used to communicate between the services.
Insurance Service API calls payment service API. Payment service API calls utility service API.

# 3.	Database:

MySQL database is used by the microservices to do the DB transactions.

MicroService	Table Name

Insurance Service	**INSURANCE_QUOTATION**

Payment Service	**INSURANCE_PAYMENT**

Utility Service	**GEOGRAPHICAL**

# 4.	Repository Pattern:

All the microservices have their own POJO classes defined as entities to do the ORM and all the CRUD actions are performed using an interface extending the JPARepository.

# 5.	Eureka Server:

The Eureka server is provided to enable the microservices for registering themselves and discovering the other registered microservices. It also manages the instances for a microservice dynamically and provides them for API Gateway to identify the port and call the service with their application name. 

**URL:** http://localhost:8761/

# 6.	API Gateway Server:

This server acts as a gateway for all the microservices. It routes the url for the corresponding microservice by discovering the application name from the Eureka server.

# 7.	Swagger Documentation:

Swagger 2 is used to document the REST API provided by our microservices. The Swagger UI provides a beautiful and understandable interface for our API by exposing all the URI’s, Request methods, the attributes and its functionality along with an option to execute the service without going to the POSTMAN app. 

**Insurance Service**			http://localhost:8100/swagger-ui.html#/

**Payment Service**			http://localhost:8200/swagger-ui.html#/

**Utility Service**			http://localhost:8300/swagger-ui.html#/

# 8.	Angular Frontend:

Angular is been used as frontend to communicate with API gateway, which will later communicate with particular microservices based on request and provide user a better look and view.


