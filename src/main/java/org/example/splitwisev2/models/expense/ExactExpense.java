package org.example.splitwisev2.models.expense;

import org.example.splitwisev2.models.User;
import org.example.splitwisev2.models.split.ExactSplit;
import org.example.splitwisev2.models.split.Split;

import java.util.List;

public class ExactExpense extends Expense {

    public ExactExpense(double amount, User paidBy, List<Split> splits, ExpenseMetaData metaData) {
        super(amount, paidBy, splits, metaData);
    }

    @Override
    public boolean validate() {
        for (Split split : getSplits()) {
            if (!(split instanceof ExactSplit)) {
                return false;
            }
        }

        double totalAmount = getAmount();
        double sumSplitAmount = 0;
        for (Split split : getSplits()) {
            ExactSplit exactSplit = (ExactSplit) split;
            sumSplitAmount += exactSplit.getAmount();
        }
        return totalAmount == sumSplitAmount;
    }


}
