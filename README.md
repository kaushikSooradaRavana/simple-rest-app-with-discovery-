# Simple REST Sample Application using Eureka Service Registry 

A simple Spring Boot based sample application that uses the Eureka Service Registry. The application demonstrates how applications register themselves with the service registry. Additionally, the application uses a Ribbon-enabled `RestTemplate` to demonstrate how other microservices are discovered with the help of the service registry. 

The application uses the following:

- A user-provided service instance in the target space that references the global service registry in the GLOBAL-SERVICE-* PCF org. The user-provided service must be named `ow-service-registry`. The corresponding service binding can be found in the `services` section of the `manifest.yml` file.
- The service uses service discovery to retrieve details about the service `simple-rest-app-with-config-v1` in order to query that service.  

## Build the application

Build the project with Maven:

```
mvn clean package
```

## Run the application

Deploy the application to Cloud Foundry:

```
cf push
```

Access the application remotely at: https://simple-rest-app-with-discovery-v1.apps.dev.api.mbusa.oneweb.mercedes-benz.cinteo.de/simple-rest-app-with-discovery/v1/hello/MBUSA

Use the following URL to access the endpoint that uses service discovery and proxies another microservice: https://simple-rest-app-with-discovery-v1.apps.dev.api.mbusa.oneweb.mercedes-benz.cinteo.de/simple-rest-app-with-discovery/v1/proxy/hello/MBUSA
