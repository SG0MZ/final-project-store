FRONTEND Explanation

Home-Page: http://localhost:8081/index.html

I managed to include in the front end a Sign Up form, Login, User Management, Course Management, Order Management. Unfortunately it wasnt possible to 
unite both front end and back end with Thymeleaf.

H2-Console: http://localhost:8081/h2-console

Swagger: http://localhost:8081/swagger-ui

DATA SQL Explanation

I initialized the H2 database with 3 records for the tables User, Course and Domain.

BACKEND Explanation

Unfortunately I didnt manage to apply Authentication to the spring boot, it kept failing everytime I tried to apply it. So I made sure to focus on the other
components of the project.

For the backend I created the following packages:

-Configuration
-Controllers
-Exception
-Model
-Wrappers
-Repository
-Service

Model Package

I created the following entities with the H2 database:

-User
-Course
-Domain
-Order

The CheckoutRequest is only a class not an entity.