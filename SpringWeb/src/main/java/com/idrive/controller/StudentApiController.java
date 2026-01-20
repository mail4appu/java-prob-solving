package com.idrive.controller;

import com.idrive.bean.Student;
import com.idrive.dao.StudentDao;
import com.idrive.dao.StudentDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentApiController {

    @Autowired
    StudentDao studentDao;

    @ModelAttribute
    public void setup(){
        System.out.println("inside setting up rest controller");
    }

    @RequestMapping(value = "/{email}", method = RequestMethod.GET,  produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> fetchStudentDetails(@PathVariable("email") String emailId){
        Student student = studentDao.getStudent(emailId);
        return new ResponseEntity(student,HttpStatus.OK);
    }

}
