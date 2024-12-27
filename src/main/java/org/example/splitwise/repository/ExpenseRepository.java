package org.example.splitwise.repository;

import org.example.splitwise.model.Expense;
import org.example.splitwise.model.User;

import java.util.HashMap;
import java.util.Map;

public class ExpenseRepository {
    private final Map<String, Map<String, Double>> expenseDb;

    public  ExpenseRepository(){
        this.expenseDb = new HashMap<>();
    }

    public void saveUser(String userId){
        expenseDb.putIfAbsent(userId, new HashMap<>());
    }

    public Map<String , Double> findById(String userId){
        return expenseDb.getOrDefault(userId, null);
    }

    public Map<String, Map<String , Double>> getAll(){
        return expenseDb;
    }

    public void deleteUser(String userId){
        expenseDb.remove(userId);
    }
}
