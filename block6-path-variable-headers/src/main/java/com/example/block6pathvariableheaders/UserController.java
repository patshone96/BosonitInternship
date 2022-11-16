package com.example.block6pathvariableheaders;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class UserController {

    @Autowired
    User user;

    @Autowired
    UserRepo userRepo;

    @GetMapping("Greeting")
    public Optional<User> getUser(@RequestParam(value = "id", defaultValue = "0") int id){

       return userRepo.getUser(id);


    }

    @PostMapping("addUser")
    public User addUser(@RequestBody User user){
        userRepo.addUser(user);
        return user;
    }
}
