# weatherforecast

This application saves weather data from webservice at regular interval(30 minutes) and display latest forecast on web page from database

It is a multi module maven project. Modules are weatherforecast-api and weatherforecast-web.

Steps to run;

First please navigate to weatherforecast folder and build the project as;

    weatherforecast>mvn clean install

If everything works fine please navigate to weatherforecast-web folder and run spring boot project as;

    weatherforecast>cd weatherforecast-web

    webDemoProject/weatherforecast-web>mvn spring-boot:run

Then please go to; localhost:8080

This project has 2 spring boot projects; weatherforecast-api, weatherforecast-web. When weatherforecast-web project runs it creates itself and it also creates weatherforecast-api project. So, both modules run in single tomcat server. Additionally, weatherforecast-api module can run by itself since it's not dependent to weatherforecast-web module.