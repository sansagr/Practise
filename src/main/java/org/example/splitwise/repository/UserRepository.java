package org.example.splitwise.repository;

import org.example.splitwise.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    private final Map<String, User> userDb;

    public UserRepository(){
        this.userDb = new HashMap<>();
    }

    public void saveUser(User user){
        userDb.putIfAbsent(user.getId(), user);
    }

    public void updateUser(User user){
        userDb.putIfAbsent(user.getId(), user);
    }

    public User findById(String userId){
        User user = null;

        if (userDb.containsKey(userId)) {
            user = userDb.get(userId);
        }
        return user;
    }

    public void deleteUser(String userId){
        userDb.remove(userId);
    }
}
