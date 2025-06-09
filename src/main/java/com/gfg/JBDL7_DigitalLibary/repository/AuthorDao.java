package com.gfg.JBDL7_DigitalLibary.repository;

import com.gfg.JBDL7_DigitalLibary.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class AuthorDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Author findAuthorById(String authorEmail) {
        String query = "SELECT * FROM AUTHOR WHERE AUTHOR_EMAIL = "+authorEmail;
        Author res = jdbcTemplate.queryForObject(query, new RowMapper<Author>() {

            @Override
            public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
                Author author = new Author();
                author.setName(rs.getString("AUTHOR_EMAIL"));

                return author;
            }
        });

        return res;

    }

    public void createAuthor(Object toAuthor) {
    }
}
