package edu.ntnu.backend.repository;

import edu.ntnu.backend.model.User;

import java.util.List;

public interface UserRepository {
    List<User> getAllUsers();
    int save(User User);
    User findUserByUsername(String username);
}
