package org.example.onlinebookstore.repositories;

import org.example.onlinebookstore.models.User;

import java.util.Map;

public class UserRepository {
    private final Map<String, User> userDatabase;

    public UserRepository(Map<String, User> idUserMap){
        this.userDatabase = idUserMap;
    }

    public void addUser(User user){
        userDatabase.put(user.getId(), user);
    }

    public void removeUser(User user){
        userDatabase.remove(user.getId(), user);
    }

    public void updateUser(User user){
        userDatabase.put(user.getId(), user);
    }

    public User getUser(String userId){
        User user = null;
        if (userDatabase.containsKey(userId)){
            user =  userDatabase.get(userId);
        }
        return user;
    }
}
