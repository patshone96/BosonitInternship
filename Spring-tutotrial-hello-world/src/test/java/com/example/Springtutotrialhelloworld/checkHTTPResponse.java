package com.example.Springtutotrialhelloworld;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;



@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class checkHTTPResponse {
    @LocalServerPort
    private int port;

    @Autowired
    public TestRestTemplate TestRestTeamplete;

    //This test checks for the response of the controller
    @Test
    public void ShouldPassTestIfStringMatches(){

        assertEquals("Hello World from Spring Boot", TestRestTeamplete
                .getForObject("http://localhost:"+port + "/", String.class));

    }

    //This test checks for the response on the /goodbye on the controller
    @Test
    public void ShouldPassTestIfStringMatchesGoodbye(){

        assertEquals("Goodbye", TestRestTeamplete
                .getForObject("http://localhost:"+port + "/goodbye", String.class));

    }
}
