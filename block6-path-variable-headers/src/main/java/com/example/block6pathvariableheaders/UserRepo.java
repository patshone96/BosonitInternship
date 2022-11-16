package com.example.block6pathvariableheaders;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserRepo {
        List<User> users = new ArrayList<>();


        public void addUser(User u){
                users.add(u);
        }

        public Optional<User> getUser(int id){

                Optional<User> u = Optional.of(users.get(id));

                return u;


        }

}
