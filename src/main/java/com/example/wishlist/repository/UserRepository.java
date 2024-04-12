package com.example.wishlist.repository;

import com.example.wishlist.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    private List<User> users = new ArrayList<>();

          public UserRepository () {
             users.add(new User("Joel", "hemmelighed"));
             users.add(new User("Berzan", "bibloteket"));
             users.add(new User("Ali", "mazza"));
          }

          public boolean addUSer (User user) {
              //tjek om brugernavnet allerede eksiterer
              for(User existingUser : users) {
                  if(existingUser.getUsername().equals(user.getUsername())){
                      return false; //brugeren findes allerede

                  }
              }
              //tilføj den nye bruger
              users.add(user);
              return true; //Brugeren bliver tilføjet
//
//          public boolean getUser(String username) {
//        for (User user:users) {
//            if(user.getUsername().equals(username))
//                return true;
//        }
//        return false;
    }

    public boolean login(String id, String password){
        // Implementer logik til at validere brugerens loginoplysninger
        // Returner true, hvis loginoplysningerne er korrekte, ellers returner false
        return true;
    }

}