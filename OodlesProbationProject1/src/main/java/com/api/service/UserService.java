package com.api.service;
import java.util.List;

import com.api.entity.User;
import org.springframework.stereotype.Service;

public interface UserService {

    User saveUser(User user);

    User deactivateUser(int id);

    User activateUser(int id);

    List<User> getAllActiveUsers();

}
