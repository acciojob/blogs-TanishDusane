package com.driver.services;

import com.driver.models.User;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void createUser(String username, String password){
        User user = new User(username,password);
        user.setUsername(username);
        user.setPassword(password);
        userRepository.save(user);
    }

    public void deleteUser(int userId){
        userRepository.deleteById(userId);
    }

    public void updateUser(Integer id, String password){
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()){
            User user = userOptional.get();
            user.setPassword(password);
            userRepository.save(user); // Removed return type
        }
    }
}
