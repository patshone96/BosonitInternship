package com.example.block7crudvalidation;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


//Sends a request to the 8081 port, to the endpoint teacher/id

@FeignClient(name="feignClient", url = "localhost:8081")
public interface FeignTeacher {
    @GetMapping("teacher/{id}")
    public String getTeacherFeign(@PathVariable Integer id);
}
