# TinyUrl

This is an url shortening REST Web API using Spring Boot. I have used Hibernate for persisting data in MySql.

To build this app follow the below steps:

1. Git clone this repository.

2. Open the cloned folder in an IDE.

3. Create a schema named Schireson in MySql

4. Run TinyUrlApplication. java

5. Open postman

6. Use Post method in postman and type http://localhost:8080/getTinyUrl. In the Headers option below the url type Content-Type in key and application/json in value. In the Body option below the url select raw and in the space given below type the url you want to shorten in the following format
          {
            "url":"The url you want to shorten"
          }

7. In the response below you will get the shortened URL. Now copy this URL and paste it in the browser.
8. This will redirect you to the Original URL.
