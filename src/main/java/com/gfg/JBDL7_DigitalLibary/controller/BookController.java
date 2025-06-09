package com.gfg.JBDL7_DigitalLibary.controller;

import com.gfg.JBDL7_DigitalLibary.model.Book;
import com.gfg.JBDL7_DigitalLibary.request.CreateBookRequest;
import com.gfg.JBDL7_DigitalLibary.response.BookResponse;
import com.gfg.JBDL7_DigitalLibary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService bookService;


    @PostMapping(value = "/create/book",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookResponse> createBook(@RequestBody CreateBookRequest createBookRequest){

        BookResponse bookResponse = new BookResponse();

        if(createBookRequest== null){
            bookResponse.setErrCode("FAILED");
            bookResponse.setMessage("Request is Empty");
            return new ResponseEntity<>(bookResponse, HttpStatus.OK);
        }

        Book book = bookService.createBookInDatabase(createBookRequest);


        if(book == null){
            bookResponse.setErrCode("FAILED");
            bookResponse.setMessage("DATA NOT INSERTED. ");
            return new ResponseEntity<>(bookResponse, HttpStatus.OK);
        }
        bookResponse.setErrCode("SUCCESS");
        bookResponse.setMessage("Book inserted into the database. ");
        bookResponse.setBookId(book.getBookId()+" ");
        bookResponse.setBookName(book.getBookName());

        return new ResponseEntity<>(bookResponse, HttpStatus.CREATED);
    }
}
