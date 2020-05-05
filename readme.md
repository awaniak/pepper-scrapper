**Pepper scrapper**

Scrapper for pepper website https://www.pepper.pl/

App extracts title, price and temperature from occasions and save them in elasticsearch 
Kibana provides visualization for elasticsearch data

**Set up**

`docker-compose` to start elasticsearch and kibana
* elasticsearch works on `localhost:9200`
* kibana works on `localhost:5601`

`mvn package && java -jar target/*.jar` - startup application, works on `localhost:10000`

**Scrapping**

`GET [host]/ppscr/scrap (e.g. http://localhost:10000/ppscr/scrap)`
To scrap data from pepper service and populate elastic

![Kibana example](https://imgur.com/OG6gd7R)
