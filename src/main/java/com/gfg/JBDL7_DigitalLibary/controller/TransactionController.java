package com.gfg.JBDL7_DigitalLibary.controller;


import com.gfg.JBDL7_DigitalLibary.model.Transaction;
import com.gfg.JBDL7_DigitalLibary.request.BookTransactionRequest;
import com.gfg.JBDL7_DigitalLibary.response.TransactionResponse;
import com.gfg.JBDL7_DigitalLibary.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/book/initiate")
    public ResponseEntity<TransactionResponse> initiateTransaction(@RequestBody BookTransactionRequest bookTransactionRequest){

        TransactionResponse transactionResponse = new TransactionResponse();

        if(bookTransactionRequest == null){
            transactionResponse.setErrCode("FAILED");
            transactionResponse.setMessage("Request is Empty. ");
            return new ResponseEntity<>(transactionResponse, HttpStatus.OK);
        }

        Transaction transaction = transactionService.createTransaction(bookTransactionRequest);
        if(transaction == null){
            transactionResponse.setErrCode("FAILED");
            transactionResponse.setMessage("Not Completed, Please retry.");
            return new ResponseEntity<>(transactionResponse, HttpStatus.OK);
        }
        transactionResponse.setTransactionType();

    }
}
