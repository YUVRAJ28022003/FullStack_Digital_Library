package com.gfg.JBDL7_DigitalLibary.service;


import com.gfg.JBDL7_DigitalLibary.model.Student;
import com.gfg.JBDL7_DigitalLibary.model.StudentType;
import com.gfg.JBDL7_DigitalLibary.repository.StudentDao;
import com.gfg.JBDL7_DigitalLibary.request.CreateStudentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {


    @Autowired
    StudentDao studentDao;

    public Student createStudent(CreateStudentRequest request){

        String id = request.getStudentId();
        String type = request.getStudentType().toString();
        String name = request.getName();
        String email = request.getEmail();
        String phone = request.getPhoneNo();

        Student student = Student.builder().studentId(Integer.parseInt(id)).studentType(StudentType.valueOf(type)).email(email).name(name).phoneNo(phone).build();

        int result = studentDao.createStudentInDatabase(student);
        if(result >0){
            System.out.println("Data has been inserted successfully");
            return student;
        }
        return null;
    }
}



//builder is a type of design pattern
