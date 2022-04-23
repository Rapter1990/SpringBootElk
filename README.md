# Spring Boot ELK(ElasticSearch, Logstash, Kibana)

<img src="" alt="Main Information" width="800" height="300">

### 📖 Information

<ul style="list-style-type:disc">
  <li>The aim of app manages collect logs from app through Logstash and then analyze them in ElasticSearch before visualizing them in Kibana</li>  
  <li>Here is the explanation of the project
      <ul>
        <li>docker-compose reads variables from .env file.</li>
        <li>Implement the process of all CRUD operations to add logs through Postman</li>
        <li>Collect logs and transfrom them through Logstash</li>
        <li>Search and analyze them through ElasticSearch</li>
        <li>Visualize and manage them through Kibana</li>
      </ul>
  </li>
</ul>

### 🔨 Run the App

#### Maven

<b>1 )</b> Download your project from this link `https://github.com/Rapter1990/SpringBootElk`

<b>2 )</b> Go to the project's home directory :  `cd SpringBootElk`

<b>3 )</b> Create a jar file though this command `mvn clean install`

<b>4 )</b> Run the project though this command `mvn spring-boot:run`


#### Docker

<b>1 )</b> Install <b>Docker Desktop</b>. Here is the installation <b>link</b> : https://docs.docker.com/docker-for-windows/install/

<b>2 )</b> Look at the <b>.env</b> file in project's root directory if database schema, username or password are needed to be changed 

<b>3 )</b> Use the command to read variables from <b>.env</b> file.
```
    docker-compose config
```
<b>4 )</b> Open <b>Terminal</b> under <b>resources</b> folder to run <b>all containers</b> on <b>Docker</b> Container
```
    docker-compose up -d
```
<b>5 )</b> Open <b>ElasticSearch</b> in the Browser 
```
    http://localhost:9200
```
<b>6 )</b> Show <b>Indexs</b> in the <b>ElasticSearch</b> 
```
    http://localhost:9200/_cat/indices?v
```
<b>7 )</b> Open <b>Kibana</b> in the <b>Browser</b>
```
    http://localhost:5601/
```





