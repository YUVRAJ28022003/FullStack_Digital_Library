package com.gfg.JBDL7_DigitalLibary.response;


import com.gfg.JBDL7_DigitalLibary.model.Book;
import com.gfg.JBDL7_DigitalLibary.model.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponse  extends Response{
    TransactionType transactionType;
    private Book book;

}
