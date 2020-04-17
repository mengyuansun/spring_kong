package com.consumer.myribbon.feign.impl;

import com.consumer.myribbon.feign.StudentService;
import com.consumer.myribbon.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController implements StudentService {

    @Autowired
    private StudentService studentService;

    @Override
    public String getAllStudent() {
        return studentService.getAllStudent();
    }

    @Override
    public String saveStudent(Student student) {
        return studentService.saveStudent(student);
    }
}
