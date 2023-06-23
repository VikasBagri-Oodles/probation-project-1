package com.api.service.impl;

import com.api.entity.User;
import com.api.repository.UserRepository;
import com.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        User savedUser = userRepository.save(user);
        return savedUser;
    }

    public User deactivateUser(int id) {

        User user = userRepository.findById(id);

        if(user == null) {
            // user does not exist
            return null;
        }

        // user exists
        // deactivated the user
        // or update the user's active value to 0
        user.setActive(0);
        User deactivatedUser = userRepository.save(user);

        return deactivatedUser;

    }

    public User activateUser(int id) {

        User user = userRepository.findById(id);
        if(user == null) {
            // user does not exist
            return null;
        }

        // user exists
        // set 'active' for the user to 1
        user.setActive(1);
        User activatedUser = userRepository.save(user);
        return activatedUser;

    }

    public List<User> getAllActiveUsers() {
        List<User> allActiveUsers = userRepository.findByActive(1);
        return allActiveUsers;
    }

}
