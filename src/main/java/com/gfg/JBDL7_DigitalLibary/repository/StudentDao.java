package com.gfg.JBDL7_DigitalLibary.repository;


import com.gfg.JBDL7_DigitalLibary.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public int createStudentInDatabase(Student student) {
        String query = "INSERT INTO STUDENT(STUDENT_ID,NAME,PHONE_NO,STUDENT_TYPE) VALUES(?,?,?,?,?)";
        int row = jdbcTemplate.update(query,student.getStudentId(),student.getName(),student.getEmail(),student.getPhoneNo(),student.getStudentType().toString());
        return row;
    }
}
