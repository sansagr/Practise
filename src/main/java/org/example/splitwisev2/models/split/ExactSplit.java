package org.example.splitwisev2.models.split;

import org.example.splitwisev2.models.User;

public class ExactSplit extends Split{
    public ExactSplit(User user, double amount){
        super(user);
        this.amount = amount;
    }
}
