package com.gfg.JBDL7_DigitalLibary.service;

import com.gfg.JBDL7_DigitalLibary.exception.BookAlreadyPresent;
import com.gfg.JBDL7_DigitalLibary.model.Author;
import com.gfg.JBDL7_DigitalLibary.model.Book;
import com.gfg.JBDL7_DigitalLibary.repository.AuthorDao;
import com.gfg.JBDL7_DigitalLibary.repository.BookDao;
import com.gfg.JBDL7_DigitalLibary.request.CreateBookRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
     BookDao bookDao;

    @Autowired
    AuthorDao authorDao;

    public Book createBookInDatabase(CreateBookRequest createBookRequest){

        String bookId = createBookRequest.getBookId();
        String bookName = createBookRequest.getBookName();
        String bookType = createBookRequest.getBookType().toString();
        String authorEmail = createBookRequest.getAuthorEmail();

        Book bookResult = null;

        try{
            int status =bookDao.findBookById(bookId);
            if(status > 0) throw new BookAlreadyPresent("BOOK IS ALREADY PRESENT IN THE DATABASE. ");

            int result = bookDao.createBookInDatabase(bookId,bookName,bookType, authorEmail);
            if(result<=0) return null;
            boolean isAuthorExist;
            try{
                Author authorExist = authorDao.findAuthorById(authorEmail);
                isAuthorExist = true;
            }catch ( Exception exception){
                isAuthorExist = false;
            }
            if(isAuthorExist == true) return bookResult;
            authorDao.createAuthor(createBookRequest.toAuthor(createBookRequest));
        }catch (Exception exception){
            throw new RuntimeException();
        }
        return bookResult;
    }
}
