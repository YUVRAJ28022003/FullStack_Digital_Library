package com.gfg.JBDL7_DigitalLibary.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Book {
    private int bookId;
    private String bookName;
    private Author authorName;
    BookType bookType;
    private double price;

}
