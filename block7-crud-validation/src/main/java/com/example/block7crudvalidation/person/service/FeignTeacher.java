package com.example.block7crudvalidation.person.service;
//import javax.ws.rs.QueryParam;

import com.example.block7crudvalidation.exceptions.EntityNotFoundException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


//Sends a request to the 8080 port, to the endpoint teacher/id

@FeignClient(name="feignTeacher", url = "http://localhost:8081")
public interface FeignTeacher {
    @GetMapping("/teacher/get/{id}")
    public String getTeacherByID(@PathVariable Integer id, @RequestParam(defaultValue = "simple") String outputType) throws EntityNotFoundException;
}
