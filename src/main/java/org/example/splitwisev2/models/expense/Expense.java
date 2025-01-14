package org.example.splitwisev2.models.expense;

import lombok.Data;
import org.example.splitwisev2.models.User;
import org.example.splitwisev2.models.split.Split;

import java.util.List;

@Data
public abstract class Expense {
    private String id;
    private double amount;
    private User paidBy;
    private List<Split> splits;
    private ExpenseMetaData metaData;

    public Expense(double amount, User paidBy,List<Split> splits, ExpenseMetaData metaData){
        this.amount = amount;
        this.paidBy = paidBy;
        this.splits = splits;
        this.metaData = metaData;
    }

    public abstract boolean validate();

}
