package org.deepanshi.service;

import org.deepanshi.dto.CreateStudentRequestDTO;
import org.deepanshi.dto.CreateStudentResponse;
import org.deepanshi.dto.UpdateRequestDTO;
import org.deepanshi.dto.UpdateResponseDTO;
import org.deepanshi.entity.Student;
import org.deepanshi.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public CreateStudentResponse createStudent(
            CreateStudentRequestDTO requestDTO) {

        Student student = new Student();
        student.setName(requestDTO.getName());
        student.setAge(requestDTO.getAge());
        student.setEmail(requestDTO.getEmail());

        studentRepository.create(student);

        CreateStudentResponse response = new CreateStudentResponse();
        response.setName(student.getName());
        response.setAge(student.getAge());
        response.setEmail(student.getEmail());
        response.setMessage("Student created successfully");
        response.setCreatedAt(LocalDateTime.now());

        return response;
    }

    public CreateStudentResponse getStudent(Long id) {

        Student student = studentRepository.getStudentById(
                Math.toIntExact(id));

        CreateStudentResponse response = new CreateStudentResponse();
        response.setId(student.getId());
        response.setName(student.getName());
        response.setAge(student.getAge());
        response.setEmail(student.getEmail());

        return response;
    }

    public List<Student> getStudents() {
        return studentRepository.getStudent();
    }

    public UpdateResponseDTO updateStudent(
            Long id, UpdateRequestDTO requestDTO) {

        Student student = new Student();
        student.setName(requestDTO.getName());
        student.setAge(requestDTO.getAge());
        student.setEmail(null);

        studentRepository.update(student, Math.toIntExact(id));

        UpdateResponseDTO response = new UpdateResponseDTO();
        response.setId(id);
        response.setName(student.getName());
        response.setAge(student.getAge());
        response.setRollNo(requestDTO.getRollNo());
        response.setSubject(requestDTO.getSubject());
        response.setMessage("Student updated successfully");
        response.setUpdatedAt(LocalDateTime.now());

        return response;
    }

    public void deleteStudent(Long id) {
        studentRepository.delete(Math.toIntExact(id));
    }

    public void deleteStudentSoftly(Long id) {
        // Soft delete requires an is_deleted column and an UPDATE query
        // in the repository. Your current repository performs hard deletes.
        throw new UnsupportedOperationException(
                "Soft delete is not implemented in StudentRepository yet");
    }
}
