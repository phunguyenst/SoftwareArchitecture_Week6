package org.example.services;

import org.example.authen.UserPrincipal;
import org.example.model.User;

public interface UserService {
    User createUser(User user);
    UserPrincipal findByUsername(String username);
}
