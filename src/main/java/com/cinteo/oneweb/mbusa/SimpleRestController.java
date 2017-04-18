package com.cinteo.oneweb.mbusa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 
 * @author Gregor Zurowski
 *
 */
@RestController
public class SimpleRestController {

    private static final String OTHER_MICROSERVICE = "simple-rest-app-with-config-v1";

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable(value = "name") String name) {
        return String.format("Hello %s!", name);
    }

    @GetMapping("/proxy/hello/{name}")
    public ResponseEntity<String> proxy(@PathVariable String name) {
        // @formatter:off
        return restTemplate.getForEntity(
                String.format("//%s/simple-rest-app-with-config/v1/hello/%s", OTHER_MICROSERVICE, name),
                String.class);
        // @formatter:on
    }

}
