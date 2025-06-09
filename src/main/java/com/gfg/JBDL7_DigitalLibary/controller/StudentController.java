package com.gfg.JBDL7_DigitalLibary.controller;


import com.gfg.JBDL7_DigitalLibary.model.Student;
import com.gfg.JBDL7_DigitalLibary.request.CreateStudentRequest;
import com.gfg.JBDL7_DigitalLibary.response.StudentResponse;
import com.gfg.JBDL7_DigitalLibary.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping(value = "/create/student",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentResponse> createStudent(@RequestBody(required = true)CreateStudentRequest createStudentRequest){

        StudentResponse studentResponse = new StudentResponse();
        if(createStudentRequest == null){
            studentResponse.setErrCode("FAILED");
            studentResponse.setMessage("Request is Empty");
            return new ResponseEntity<>(studentResponse, HttpStatus.OK);
        }
        Student student = studentService.createStudent(createStudentRequest);
        if(student == null){
            studentResponse.setErrCode("FAILED");
            studentResponse.setMessage("DATA NOT CREATED");
            return new ResponseEntity<>(studentResponse, HttpStatus.BAD_REQUEST);
        }
        studentResponse.setErrCode("00");
        studentResponse.setMessage("STUDENT HAS BEEN CREATED");
        studentResponse.setStudentId(Integer.toString(student.getStudentId()));
        studentResponse.setName(student.getName());

        return new ResponseEntity<>(studentResponse, HttpStatus.CREATED);

    }
}
