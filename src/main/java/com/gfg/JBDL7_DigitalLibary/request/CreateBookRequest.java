package com.gfg.JBDL7_DigitalLibary.request;

import com.gfg.JBDL7_DigitalLibary.model.Author;
import com.gfg.JBDL7_DigitalLibary.model.BookType;
import com.gfg.JBDL7_DigitalLibary.model.StudentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateBookRequest {

    String bookId;
    String bookName;
    String authorName;
    String authorEmail;
    String authorNumber;
    BookType bookType;

    public Object toAuthor(CreateBookRequest request) {
        Author author = Author.builder().email(request.getAuthorEmail()).name(request.getAuthorName()).phoneNo(request.getAuthorNumber()).build();
        return author;
    }
}
