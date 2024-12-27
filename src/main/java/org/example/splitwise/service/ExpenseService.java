package org.example.splitwise.service;

import org.example.splitwise.model.ExpenseType;
import org.example.splitwise.model.User;
import org.example.splitwise.repository.ExpenseRepository;

import java.util.List;
import java.util.Map;

public class ExpenseService {
    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public void addExpense(String payer, double amount, int noOfUsersInExpense, List<User> usersInvolved, ExpenseType expenseType, List<Integer> shareSplitInfo) {
        int i = 0;
        if (noOfUsersInExpense != usersInvolved.size()){
            throw new IllegalArgumentException("No of users mismatch");
        }
//        TODO: add check if in exact amount the sum equals the amount presented and number of elements matches with noOfUsersInExpense
//        TODO: add check if sum of percent equals 100 and number of elements matches with noOfUsersInExpense
        for (User user : usersInvolved) {
            double userShare = 0.0;
            if (user.getId().equals(payer)) {
                i += 1;
                continue;
            }
            if (expenseType.equals(ExpenseType.EQUAL)) {
                userShare = amount / noOfUsersInExpense;
            } else if (expenseType.equals(ExpenseType.PERCENT)) {

                userShare = ((double) shareSplitInfo.get(i) /100) * amount;
            } else {
                userShare = shareSplitInfo.get(i);
            }
            if (expenseRepository.findById(payer) == null) {
                expenseRepository.saveUser(payer);
            }
            Map<String, Double> payerLedger = expenseRepository.findById(payer);
            Double existingAmount = payerLedger.getOrDefault(user.getId(), 0.0);
            if (expenseRepository.findById(user.getId()) != null && expenseRepository.findById(user.getId()).containsKey(payer)) {
                Double payerInPayeeLedger = expenseRepository.findById(user.getId()).getOrDefault(payer, 0.0);
                if (userShare >= payerInPayeeLedger) {
                    double finalAmount = userShare - payerInPayeeLedger + existingAmount;
                    expenseRepository.findById(user.getId()).remove(payer);
                    if (finalAmount > 0.0) {
                        payerLedger.put(user.getId(), finalAmount);
                    }
                } else {
                    Double finalAmount = payerInPayeeLedger - userShare;
                    expenseRepository.findById(user.getId()).put(payer, finalAmount);
                }
            } else {
                payerLedger.put(user.getId(), existingAmount + userShare);
            }
            i += 1;
        }
    }


    public void showBalance(String userId) {
        expenseRepository.getAll().forEach((outerKey, innerKey) -> {
            if (outerKey.equals(userId)){
                innerKey.forEach((key, val) -> {
                    System.out.println(key + " owes " + outerKey +  ": " + val);
                });
            }
            else{
                if (innerKey.containsKey(userId)){
                    System.out.println(userId + " owes " + outerKey + ": " + innerKey.get(userId));
                }
            }
        });
    }

    public void showAllBalances() {
        expenseRepository.getAll().forEach((outerKey, innerKey) -> {
            innerKey.forEach((key, val) -> {
                System.out.println(key + " owes " + outerKey +  ": " + val);
            });
        });
    }
}
