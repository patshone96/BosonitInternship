package com.example.block6pathvariableheaders;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service //Must be annotated with Service in order to be injected
public class UserService {

        //Stores the users introduced by Post request
        List<User> users = new ArrayList<>();

        //Adds a User user to the list users
        public void addUser(User u){
                users.add(u);
        }

        //Returns an Optional<User>, which is empty if no user with the selected id exists on the list
        public Optional<User> getUser(int id){

                Optional<User> u = Optional.empty();

                for (User user:users) {
                        if(user.getId() == id){
                                 u = Optional.of(user);
                        }

                }

                return u;
        }

}
