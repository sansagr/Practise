package org.example.splitwise;

import org.example.splitwise.model.ExpenseType;
import org.example.splitwise.model.User;
import org.example.splitwise.repository.ExpenseRepository;
import org.example.splitwise.service.ExpenseService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Splitwise {

    public static void main(String[] args) {
        User user1 = new User("User1", "Sanskar");
        User user2 = new User("User2", "mohit");
        User user3 = new User("User3", "nipun");
        User user4 = new User("User4", "gg");

        List<User> users = new ArrayList<>(Arrays.asList(user1, user2, user3, user4));
        List<User> users2 = new ArrayList<>(Arrays.asList(user1, user2, user3, user4));
        List<User> users3 = new ArrayList<>(Arrays.asList(user2, user4));
        List<User> users4 = new ArrayList<>(Arrays.asList(user1, user2));

        ExpenseRepository expenseRepository = new ExpenseRepository();

        ExpenseService expenseService = new ExpenseService(expenseRepository);
//
        expenseService.addExpense("User1", 1000, 4, users, ExpenseType.EQUAL, List.of(1));


        expenseService.addExpense("User4", 1400, 4, users2, ExpenseType.EQUAL, List.of(1));


        expenseService.addExpense("User2", 300, 2, users3, ExpenseType.EXACT, List.of(100,200));
//        expenseService.showBalance("User2");


        expenseService.addExpense("User3", 400, 2, users4, ExpenseType.PERCENT, List.of(40,60));
        expenseService.addExpense("User2", 10000, 4, users, ExpenseType.EQUAL, List.of(1));
        expenseService.showAllBalances();

    }
}
