package com.example.wishlist.service;
import com.example.wishlist.model.User;
import com.example.wishlist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

    @Service
    public class UserService {

        private UserRepository userRepository;

        @Autowired
        public UserService(UserRepository userRepository) {
            this.userRepository = userRepository;
        }


        //Koden implementere en ny brugere (CREATE)
        public boolean addUser(User user) {
            return userRepository.addUser(user);
        }
         /* koden bruges hvis man vil have alle brugere
       public List<User> getAllUsers() {
            return userRepository.getAllUsers();
        }*/

/*koden bruges kun hvis vi skal updater en bruger
        public User updateUser(int id, User updatedUser) {
            return userRepository.updateUser(id, updatedUser);
        }
*/

/* koden bruges kun hvis vi skal slette en bruger
        public void deleteUser(int id) {
            userRepository.deleteUser(id);
        }
*/
    }


