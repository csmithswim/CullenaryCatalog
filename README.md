## Cullenary Catalog ##
A Spring Boot Culinary Recipe Catalog Application.

-------------

#### Features ####

* A multi layered Spring Boot web server that manages different web services and API's.
* Creates a MYSQL server, a database and a table to store recipe information on run time.
* Recipes can be posted, viewed, updated and deleted.
* Recipes are stored and persist in a MYSQL database.
* Recipes can be searched and then sorted based upon their name or category.

-------------

### How The Application Works ###

* Spring Boot and dependencies such as Spring Data, Spring Web and Validation work in tandem to run a web server to process incoming API requests and respond accordingly.
* JDBC and Spring's MYSQL driver facilitate a MYSQL server to be run and managed by JDBC and unique implementations of JDBC's Crud Repository.
* Lombok eliminates much of the boilerplate code in the Recipe model class.
* The Recipe model class consists of a unique ID, name, category, date, description, ingredients and directions. The name, message, category and description must not be blank 
  while the ingredients must not be null when making HTTP requests.
* The RecipeService class contains methods that will save a recipe, find a recipe by ID, delete a recipe by ID, update a recipe and search for a recipe. Error handling and HTTP 
  status codes are present in methods to ensure proper functionality.
* The RecipeRepository interface has two methods to find a recipe by name or find a category and also extends the JPA's CrudRepository.
* The RecipeController class handles the specific presentation layer of the application and contains the endpoints for the RecipeService methods.

-------------

### Running The Application



-------------

### Final Thoughts

All HTTP requests must be done with cURL request or postman.