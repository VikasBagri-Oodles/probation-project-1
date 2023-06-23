package com.api.controller;

import com.api.entity.User;
import com.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    // Creates a user in the database
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {

//        System.out.println("Jackson serialized JSON to JAVA object successfully :)");
//        System.out.println(user);

        User savedUser = userService.saveUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);

    }

    // Deactivates (Updates) a user in the database
    @PutMapping("/{id}/deactivate")
    public ResponseEntity<String> deactivateUser(@PathVariable(name = "id") int id) {

        User deactivatedUser = userService.deactivateUser(id);
        String response;

        if(deactivatedUser == null) {
            response = "User with id " + id + " does not exist";
        } else {
            response = "User with id " + id + " is deactivated successfully";
        }
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    // Gets data of all the users thar are currently active
    @GetMapping
    public ResponseEntity<List<User>> getAllActiveUsers() {

        List<User> activeUsers = userService.getAllActiveUsers();
        return new ResponseEntity<>(activeUsers, HttpStatus.OK);
    }

    // Activates a user with the specified id, if exists
    // Or Updating a user's 'active' field value to 1
    @PutMapping("/{id}/activate")
    public ResponseEntity<String> activateUser(@PathVariable(name = "id") int id) {

        String output;
        User activatedUser = userService.activateUser(id);
        if (activatedUser == null) {
            output = "User with id " + id + " does not exist";
        } else {
            output = "User with id " + id + " is activated successfully";
        }

        return new ResponseEntity<>(output, HttpStatus.OK);

    }


}
