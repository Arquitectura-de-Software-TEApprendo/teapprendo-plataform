# TEApprendo Platform

## Axon Server
- https://download.axoniq.io/axonserver/AxonServer.zip

### Run Axon Server
```
$ cd /
$ cd c/efra/tools/AxonServer-2024.1.4
$ java -jar axonserver.jar
```

### Axon Server URL
- http://localhost:8024/

### API URL
- http://localhost:8080/swagger-ui/index.html

### ENVIORNMENT VARIABLES
```
SPRING_PROFILES_ACTIVE=local|prod
DATASOURCE_URL=jdbc:postgresql://{host}:5432/teapprendo
DATASOURCE_USERNAME=developer
DATASOURCE_PASSWORD=P@ssword24
AXONSERVER_SERVERS={host}:8124
```