package org.deepanshi.service;

import org.springframework.stereotype.Service;

@Service
public class StudentService {

    public String createStudent(){
        System.out.println("Student Created");
        return "Student saved";
    }

    public String dummyMethod(String s) {
        System.out.println("dummyMethod called");
        return s;
    }
}
