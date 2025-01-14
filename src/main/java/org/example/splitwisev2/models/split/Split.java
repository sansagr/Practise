package org.example.splitwisev2.models.split;

import lombok.Data;
import org.example.splitwisev2.models.User;

@Data
public abstract class Split {
    private User user;
    double amount;

    public Split(User user){
        this.user = user;
    }

}
