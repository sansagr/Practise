package org.example.splitwisev2.services;

import org.example.splitwisev2.models.User;
import org.example.splitwisev2.models.expense.Expense;
import org.example.splitwisev2.models.expense.ExpenseMetaData;
import org.example.splitwisev2.models.expense.ExpenseType;
import org.example.splitwisev2.models.split.Split;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpenseManager {
    List<Expense> expenses;
    public Map<String, User> userMap;
    Map<String, Map<String, Double>> balanceSheet;

    public ExpenseManager(){
        expenses = new ArrayList<>();
        userMap = new HashMap<String, User>();
        balanceSheet = new HashMap<String, Map<String, Double>>();
    }

    public void addUser(User user){
        userMap.put(user.getId(), user);
        balanceSheet.put(user.getId(), new HashMap<String, Double>());
    }

    public void addExpense(ExpenseType expenseType, double amount, String paidBy, List<Split> splits, ExpenseMetaData expenseMetaData){
        Expense expense = ExpenseService.createExpense(expenseType, amount, userMap.get(paidBy),splits, expenseMetaData);
        expenses.add(expense);

        for(Split split: expense.getSplits()){
            String paidTo = split.getUser().getId();
            Map<String, Double> balances = balanceSheet.get(paidBy);
            if(!balances.containsKey(paidTo)){
                balances.put(paidTo, 0.0);
            }

            balances.put(paidTo, balances.get(paidTo)+split.getAmount());
            balances = balanceSheet.get(paidTo);
            if(!balances.containsKey(paidBy)){
                balances.put(paidBy, 0.0);
            }
            balances.put(paidBy, balances.get(paidBy) - split.getAmount());
        }
    }

    public void showBalance(String userId){
        boolean isEmpty = true;
        for(Map.Entry<String, Double > userBalance: balanceSheet.get(userId).entrySet()){
            if (userBalance.getValue() != 0){
                isEmpty = false;
                printBalances(userId, userBalance.getKey(), userBalance.getValue());
            }
        }
        if (isEmpty){
            System.out.println("No balances");
        }
    }

    public void showBalances(){
        boolean isEmpty = true;
        for(Map.Entry<String, Map<String, Double>> allBalances: balanceSheet.entrySet()){
            for(Map.Entry<String, Double> userBalance: allBalances.getValue().entrySet()){
                if(userBalance.getValue() > 0){
                    isEmpty = false;
                    printBalances(allBalances.getKey(), userBalance.getKey(), userBalance.getValue());
                }
            }
        }

        if(isEmpty){
            System.out.println("No balances");
        }
    }

    private void printBalances(String user1, String user2, double amount){
        String user1Name = userMap.get(user1).getName();
        String user2Name = userMap.get(user2).getName();
        if(amount < 0){
            System.out.println(user1Name+ " owes " + user2Name + ": " + Math.abs(amount));
        }
        else if (amount > 0){
            System.out.println(user2Name+ " owes " + user1Name + ": " + Math.abs(amount));
        }
    }
}
