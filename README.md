## Cullenary Catalog ##
A Spring Boot Culinary Recipe Catalog Application.

-------------

#### Features ####

* A multi layered Spring Boot web server that manages different web services and API's.
* Creates a MYSQL server,  with a 'recipe' table.
* Recipes can be posted, viewed, updated and deleted.
* Recipes are stored and persist in a MYSQL database.
* Recipes can be searched based upon their name or category.

-------------

### How The Application Works ###

* Spring Boot and dependencies such as Spring Data, Spring Web and Validation work in tandem to run a web server to process incoming API requests and respond accordingly.
* JDBC and Spring's MYSQL driver facilitate a MYSQL server to be run and managed by JDBC and unique implementations of JDBC's Crud Repository.
* Lombok eliminates much of the boilerplate code present in the Recipe class
* Spring Boot and other dependencies such as spring data, spring web, JDBC, MYSQL driver, validation and lombok 