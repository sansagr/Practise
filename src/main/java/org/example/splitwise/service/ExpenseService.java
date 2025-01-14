package org.example.splitwise.service;

import org.example.splitwise.model.Expense;
import org.example.splitwise.model.ExpenseType;
import org.example.splitwise.model.User;
import org.example.splitwise.repository.ExpenseRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpenseService {
    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public void addExpense(String payer, double amount, int noOfUsersInExpense, List<User> usersInvolved, ExpenseType expenseType, List<Integer> shareSplitInfo) {

        validateUserInput(amount, noOfUsersInExpense, usersInvolved,  expenseType, shareSplitInfo);

        Map<String, Double> payerLedger = expenseRepository.findById(payer);
        if (payerLedger == null) {
            expenseRepository.saveUser(payer);
            payerLedger = expenseRepository.findById(payer);
        }

        int i = 0;
        for (User user : usersInvolved) {
            if (user.getId().equals(payer)) {
                i += 1;
                continue;
            }

            double userShare = userShareCalculator(i, amount, noOfUsersInExpense, expenseType, shareSplitInfo);
            updateLedger(payer, user, userShare, payerLedger);
            i += 1;

        }
    }

    private void validateUserInput(double amount, int noOfUsersInExpense, List<User> usersInvolved, ExpenseType expenseType, List<Integer> shareSplitInfo){
        if (noOfUsersInExpense != usersInvolved.size()){
            throw new IllegalArgumentException("Mismatch between noOfUsersInExpense and size of usersInvolved");
        }
        if (expenseType.equals(ExpenseType.PERCENT) && shareSplitInfo.stream().mapToInt(Integer::intValue).sum() != 100){
            throw new IllegalArgumentException("Percent-based share must sum to 100");
        }
        if (expenseType.equals(ExpenseType.EXACT) && shareSplitInfo.stream().mapToInt(Integer::intValue).sum() != amount){
            throw new IllegalArgumentException(("Exact-based share must sum to total amount"));
        }
    }

    private void updateLedger (String payer, User user, double userShare, Map<String, Double> payerLedger){
        String userId = user.getId();
        Map<String, Double> payeeLedger = expenseRepository.findById(userId);

        if (payeeLedger!= null && payeeLedger.containsKey(payer)) {
            Double payerInPayeeLedger = payeeLedger.getOrDefault(payer, 0.0);
            if (userShare >= payerInPayeeLedger) {
                double finalAmount = userShare - payerInPayeeLedger + payerLedger.getOrDefault(userId, 0.0);;
                payeeLedger.remove(payer);
                if (finalAmount > 0.0) {
                    payerLedger.put(userId, finalAmount);
                }
            } else {
                payeeLedger.put(payer, payerInPayeeLedger - userShare);
            }
        } else {
            payerLedger.put(userId, payerLedger.getOrDefault(userId, 0.0) + userShare);
        }
    }

    private double userShareCalculator(int i, double amount, int noOfUsersInExpense, ExpenseType expenseType, List<Integer> shareSplitInfo) {
        double userShare = 0.0;
        if (expenseType.equals(ExpenseType.EQUAL)) {
            userShare = amount / noOfUsersInExpense;
        } else if (expenseType.equals(ExpenseType.PERCENT)) {
            userShare = ((double) shareSplitInfo.get(i) / 100) * amount;
        } else {
            userShare = shareSplitInfo.get(i);
        }

        return userShare;
    }

    public void showBalance(String userId) {
        expenseRepository.getAll().forEach((outerKey, innerKey) -> {
            if (outerKey.equals(userId)) {
                innerKey.forEach((key, val) -> {
                    System.out.println(key + " owes " + outerKey + ": " + val);
                });
            } else {
                if (innerKey.containsKey(userId)) {
                    System.out.println(userId + " owes " + outerKey + ": " + innerKey.get(userId));
                }
            }
        });
    }

    public void showAllBalances() {
        expenseRepository.getAll().forEach((outerKey, innerKey) -> {
            innerKey.forEach((key, val) -> {
                System.out.println(key + " owes " + outerKey + ": " + val);
            });
        });
    }
}
