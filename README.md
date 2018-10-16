# TinyUrl

This is an url shortening REST Web API

To build this app follow the below steps:

1. Git clone this repository.

2. Open the cloned folder in an IDE.

3. Run TinyUrlApplication. java

4. Open postman

5. Use Post method in postman and type http://localhost:8080/getTinyUrl. In the Headers option below the url type Content-Type in key and application/json in value. In the Body option below the url select raw and in the space given below type the url you want to shorten in the following format
          {
            "url":"The url you want to shorten"
          }

6. In the response below you will get the shortened URL. Now copy this URL and paste it in the browser.
7. This will redirect you to the Original URL.
