package com.gfg.JBDL7_DigitalLibary.request;

import com.gfg.JBDL7_DigitalLibary.model.StudentType;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class CreateStudentRequest {

    String studentId;
    String name;
    String email;
    String phoneNo;
    StudentType studentType;

}
