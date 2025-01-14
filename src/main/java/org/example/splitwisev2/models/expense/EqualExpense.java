package org.example.splitwisev2.models.expense;


import org.example.splitwisev2.models.User;
import org.example.splitwisev2.models.split.EqualSplit;
import org.example.splitwisev2.models.split.Split;

import java.util.List;

public class EqualExpense extends Expense {
    public EqualExpense(double amount, User paidBy, List<Split> splits, ExpenseMetaData metaData){
        super(amount, paidBy, splits, metaData);
    }

    @Override
    public boolean validate(){
        for(Split split: getSplits()){
            if (!(split instanceof EqualSplit)){
                return false;
            }
        }
        return true;
    }
}