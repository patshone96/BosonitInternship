package com.example.RestControllerFilter;

import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.util.Map;

@RestController
public class restController{


    @GetMapping(value="**") //Any value on the path
    public ResponseEntity<Object> response (
            @RequestParam(required = false) Map<String,String> valor, //Values of the parameters which can be empty
            @RequestHeader MultiValueMap<String, String> map,         //Values of the header
            HttpServletRequest request)                               // We get the request in order to obtain the path
            throws URISyntaxException, UnknownHostException {


            // We retrieve the path an turn it into a string
           String path = request.getRequestURI().toString();

            //Get ip address
            InetAddress ipAddress = InetAddress.getLocalHost();
            String ip = ipAddress.toString();


            // We instantiate the controller object
            ControllerObject co = new ControllerObject(path, valor, map, ip);

            //We use the bodyBuilder to send the data required on the response
           return ResponseEntity.accepted().body(co.toString());

    }

    @GetMapping(value= {"/", "one"}) //path = "/" or "/one"
    public String entryOne(){
        return "One";
    }

}
