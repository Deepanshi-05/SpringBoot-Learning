package org.deepanshi.controller;

import org.deepanshi.dto.Student;
import org.deepanshi.service.StudentService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    public StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<String> createStudent(@RequestBody Student student){
          String s = studentService.createStudent();
          return ResponseEntity.ok(s);
    }

    @GetMapping
    public ResponseEntity<String> dummyMethod() {
        String s = "Deepanshi Singh";
        return ResponseEntity.ok(studentService.dummyMethod(s));
    }
}
