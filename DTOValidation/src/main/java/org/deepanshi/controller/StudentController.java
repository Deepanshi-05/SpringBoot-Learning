package org.deepanshi.controller;

import jakarta.validation.Valid;
import org.deepanshi.dto.CreateStudentRequestDTO;
import org.deepanshi.dto.CreateStudentResponse;
import org.deepanshi.dto.UpdateRequestDTO;
import org.deepanshi.dto.UpdateResponseDTO;

import org.deepanshi.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<CreateStudentResponse> createStudent(
            @Valid @RequestBody CreateStudentRequestDTO studentRequestDTO) {

        CreateStudentResponse createdStudent =
                studentService.createStudent(studentRequestDTO);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdStudent);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CreateStudentResponse> getStudent(
            @PathVariable Long id) {

        CreateStudentResponse studentResponse =
                studentService.getStudent(id);

        return ResponseEntity.ok(studentResponse);
    }

    @PutMapping
    public ResponseEntity<UpdateResponseDTO> updateStudent(
            @RequestParam Long id,
            @Valid @RequestBody UpdateRequestDTO studentRequestDTO) {

        UpdateResponseDTO studentResponse =
                studentService.updateStudent(id, studentRequestDTO);

        return ResponseEntity.ok(studentResponse);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteStudent(
            @RequestParam Long id) {

        studentService.deleteStudent(id);

        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/delete-soft")
    public ResponseEntity<Void> deleteStudentSoft(
            @RequestParam Long id) {

        studentService.deleteStudentSoftly(id);

        return ResponseEntity.noContent().build();
    }
}
