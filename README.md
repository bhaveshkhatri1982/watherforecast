# weatherforecast

This application saves weather data from webservice at regular interval(30 minutes) and display latest forecast on web page from database

It is a multi module maven project. Modules are weatherforecast-api and weatherforecast-web.

Steps to run;

First please navigate to weatherforecast folder and build the project as;

    weatherforecast>mvn clean install

If everything works fine please navigate to weatherforecast-api folder and run api project as; 

    weatherforecast>cd weatherforecast-api

    weatherforecast/weatherforecast-api>mvn spring-boot:run
    
After than please navigate to weatherforecast-web folder on different command prompt and run web project as;
    
    weatherforecast>cd weatherforecast-web

    weatherforecast/weatherforecast-web>mvn spring-boot:run

Then please go to; localhost:8080

This project has 2 spring boot projects; weatherforecast-api, weatherforecast-web. weatherforecast-api is configured to run on port 8081.