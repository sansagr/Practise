package org.example.splitwise.model;

import lombok.Data;

import java.util.List;

@Data
public class Expense {
    private String id;
    private String name;
    private List<User> payees;
    private User payer;

}
