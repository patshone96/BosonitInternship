package com.example.block6pathvariableheaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    User user;

    @Autowired
    UserRepo userRepo;

    //Returns a User if its id matches with the path variable, else it returns null
    @GetMapping("getUser/{id}")
    public Optional<User> getUser(@PathVariable("id") int id){
        return userRepo.getUser(id);

    }


    // Accepts a User object:
    // {
    //      "id": number
    //      "name": "name"
    // }
    // This object is added to the list on userRepo and returned as a response
    @PostMapping("addUser")
    public User addUser(@RequestBody User user){
        userRepo.addUser(user);
        return user;
    }

    //Changes the name associated to a given id if there is any user with that id and returns the user with changes
    @PutMapping("change")
    public User changeUser(@RequestParam int id,
                           @RequestParam String name){

        Optional<User> u = userRepo.getUser(id); //optional user

        User us;
        if(u.isPresent()){ //If the user exists, its name is changed
            us = u.get();
            us.setName(name);
        }else{
            us = null; // If there is no match with the id, the user is null
        }

        return us;







    }
}
