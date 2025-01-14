package org.example.splitwisev2.models.expense;

import lombok.Data;

@Data
public class ExpenseMetaData {
    private String name;
    private String imgUrl;
    private String notes;

    public ExpenseMetaData(String name, String imgUrl, String notes){
        this.name = name;
        this.imgUrl = imgUrl;
        this.notes = notes;
    }

}
