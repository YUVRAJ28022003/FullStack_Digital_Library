package com.gfg.JBDL7_DigitalLibary.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

    int id;
    Student student;
    Book book;
    double paidAmount;
    Timestamp createdOn;
    Timestamp updatedOn;
    TransactionType type;
}