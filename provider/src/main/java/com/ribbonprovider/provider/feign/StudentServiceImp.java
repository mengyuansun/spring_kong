package com.ribbonprovider.provider.feign;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/*
 * @ClassName  StudentServiceImp
 * @Description StudentService 实现类
 * @Author sun
 * */
@Service("iStudentServiceImp")
public class StudentServiceImp implements StudentService {
    private static List<Student> studentList = new ArrayList<>();

    @Override
    public String getAllStudent() {
        return studentList.toString();
    }

    @Override
    public String saveStudent(Student student) {
        studentList.add(student);
        return "ok";
    }
}
