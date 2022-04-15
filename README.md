## Cullenary Catalog ##
Recipe Catalog Application. Built with Spring Boot, Maven and Intellij IDEA.

### About
I cooked professionally for most of my life and wanted to learn more about Spring Boot, JPA and REST with a culinary context.


My first name is Cullen and you can't spell Cullenary without Cullen. :wink:

-------------

### Features ###

* A multi-layered Spring Boot application that manages different web services and API's.
* Creates a MYSQL server, database and table to store recipe information on run time.
* Recipes can be posted, viewed, updated and deleted.
* Recipes are stored and persist in a MYSQL database.
* Recipes can be searched for based upon their name or category. The HTTP response sorts the recipes by the date that they were modified by.

-------------

### How The Application Works ###

* Spring Boot and dependencies such as Spring Data, Spring Web and Validation work in tandem to run a web server to process incoming API requests and respond accordingly.
* JDBC and Spring's MYSQL driver facilitate a MYSQL server to be managed by JDBC and unique implementations of JDBC's Crud Repository.
* Lombok eliminates much of the boilerplate code in the Recipe model class.
* The Recipe model class consists of a unique ID, name, category, date, description, ingredients and directions. The name, message, category and description must not be blank 
  while the ingredients must not be null when making HTTP requests.
* The RecipeService class contains methods related to database management that will save a recipe, get all recipes, find a recipe by ID, delete a recipe by ID, update a recipe and 
  search for a 
  recipe by 
  category or name. 
* The RecipeRepository interface has two methods to find a recipe by name or find a category and also extends the JPA's CrudRepository.
* The RecipeController class handles the specific presentation layer of the application and contains the endpoints for the RecipeService methods.

-------------
### Running The Application

Note: This application does not have a front end for route handling. Any testing and use must be done using cURL, Postman or a similar application. 

I will be using Postman for illustrative purposes. 

My web server is run on the default localhost:8080 that Spring Boot supplies. All requests follow the pattern of {default_server_address_port}/api/recipe 

This application presumes that one has MSQL installed and a running instance of a MSQL server, table, mysql-connector-java dependency and properly setting up application.
properties in the resources' folder. 
More information related to this can be found here: https://spring.io/guides/gs/accessing-data-mysql/

See examples below for specific routes and their features.

#### Posting A Recipe




**@PostMapping Route**: ```{default_server_address_port}/api/recipe/new```


![post_request](https://github.com/csmithswim/cullenarycatalog/blob/main/images/post.png)

#### Getting All Recipes

This application can get a recipe by its ID or can get all recipes. Let's presume we added some more recipes to show both requests.

**Get All Recipes**


@GetMappingRoute: ```{default_server_address_port}/api/recipe```

![get_all_recipes](https://github.com/csmithswim/cullenarycatalog/blob/main/images/get.png)


**Get Recipe By Id**


@GetMapping Route: ```_{default_server_address_port}/api/recipe/{id}_```

![get_recipe_by_id](https://github.com/csmithswim/cullenarycatalog/blob/main/images/find%20by%20ID.png)

#### Updating A Recipe

**Update A Recipe By Id**

@PutMapping Route: ```{default_server_address_port}/api/recipe/{id}```

![update_recipe_by_id](https://github.com/csmithswim/cullenarycatalog/blob/main/images/put%201.png)

#### Searching By Name Or Category

Note: These two methods are GET requests that use query parameters to fetch and sort recipes by date.

**Search By Category**

@GetMapping Route: ```{default_server_address_port}/api/recipe/search/?category={category}```

![search_by_category](https://github.com/csmithswim/cullenarycatalog/blob/main/images/search%20by%20category.png)

**Search By Name**

@GetMapping Route: ```{default_server_address_port}/api/recipe/search/?name={name}```

![search_by_name](https://github.com/csmithswim/cullenarycatalog/blob/main/images/search%20by%20name.png)

#### Deleting A Recipe
Note: The DELETE request uses the recipe's primary key as the path variable and if successful will respond with an HTTP status code of 204 (No Content).

@DeleteMapping Route: ```{default_server_address_port}/api/recipe/{id}```

![delete_by_id](https://github.com/csmithswim/cullenarycatalog/blob/main/images/delete%20by%20ID.png)

A GET request to test that the recipe was deleted from our database: 

![delete_by_id_2](https://github.com/csmithswim/cullenarycatalog/blob/main/images/delete%20by%20ID%202.png)

-------------

### Final Thoughts

This project was very rewarding and educational. I wanted to learn more about JPA and how Spring can manage a relational database such as MYSQL and also how Spring manages RESTful 
API's. I learned a great deal about service oriented software architecture, dependency management, JSON, and LocalDateTime. Ultimately the most important thing I learned was 
how quickly Spring Boot could build, configure and manage a backend Java database and web server. 

One thing I would like to incorporate in the future would be a fully 
functional front end layer to allow user's to type and enter their queries to the server. 

