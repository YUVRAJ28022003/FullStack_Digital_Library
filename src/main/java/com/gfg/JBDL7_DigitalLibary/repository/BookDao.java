package com.gfg.JBDL7_DigitalLibary.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookDao {

    @Autowired
    JdbcTemplate jdbcTemplate;


    public int findBookById(String bookId) {
        int id = Integer.parseInt(bookId);
        String query = "SELECT BOOK_ID FROM BOOK WHERE BOOK_ID =?";
        int row = jdbcTemplate.queryForObject(query,Integer.class,id);
        return row;
    }

    public int createBookInDatabase(String bookId, String bookName, String bookType, String authorEmail) {
        int id = Integer.parseInt(bookId);
        String query = "SELECT INTO BOOK (BOOK_ID,BOOK_NAME, BOOKTYPE, AUTHOREMAIL) VALUES(?,?,?,?)";
        int row = jdbcTemplate.update(query,id,bookName,bookType,authorEmail);
        return row;

    }
}
