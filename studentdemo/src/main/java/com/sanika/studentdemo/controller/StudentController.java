package com.sanika.studentdemo.controller;

import com.sanika.studentdemo.dto.StudentRequestDto;
import com.sanika.studentdemo.dto.StudentResponseDto;
import com.sanika.studentdemo.model.Student;
import com.sanika.studentdemo.response.ApiResponse;
import com.sanika.studentdemo.service.StudentMapper;
import com.sanika.studentdemo.service.StudentService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/name/{name}")
    public List<Student> getByName(@PathVariable String name) {
        return studentService.getStudentsByName(name);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<ApiResponse<StudentResponseDto>> getByEmail(@PathVariable String email){

        Student student = studentService.getStudentByEmail(email);
        StudentResponseDto dto = StudentMapper.toDto(student);

        ApiResponse<StudentResponseDto> response =
                new ApiResponse<>("success","Student fetched",dto);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/search/{keyword}")
    public List<Student> getByNameContaining(@PathVariable String keyword) {
        return studentService.getStudentsByNameContaining(keyword);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<StudentResponseDto>> addStudents(
            @Valid @RequestBody StudentRequestDto request) {

        Student student = StudentMapper.toEntity(request);
        Student savedStudent = studentService.addStudent(student);

        StudentResponseDto responseDto = StudentMapper.toDto(savedStudent);

        ApiResponse<StudentResponseDto> response =
                new ApiResponse<>("success", "Student added successfully", responseDto);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<StudentResponseDto>> updateStudent(
            @PathVariable int id,
            @Valid @RequestBody StudentRequestDto request) {

        Student updatedStudent = studentService.updateStudent(id, request);
        StudentResponseDto responseDto = StudentMapper.toDto(updatedStudent);

        ApiResponse<StudentResponseDto> response =
                new ApiResponse<>("success", "Student updated successfully", responseDto);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteStudent(@PathVariable int id) {

        studentService.deleteStudent(id);

        ApiResponse<String> response =
                new ApiResponse<>("success", "Student deleted successfully", null);

        return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<StudentResponseDto>> getStudentById(@PathVariable int id) {

        Student student = studentService.getStudentById(id);
        StudentResponseDto responseDto = StudentMapper.toDto(student);

        ApiResponse<StudentResponseDto> response =
                new ApiResponse<>("success", "Student found", responseDto);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/page")
    public ResponseEntity<ApiResponse<List<StudentResponseDto>>> getAllStudentsPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String sortOrder) {

        Page<Student> studentPage =
                studentService.getAllStudentsPage(page, size, sortBy, sortOrder);

        List<StudentResponseDto> responseList =
                studentPage.getContent().stream()
                        .map(StudentMapper::toDto)
                        .toList();

        ApiResponse<List<StudentResponseDto>> response =
                new ApiResponse<>("success", "Students fetched", responseList);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/filter")
    public ResponseEntity<ApiResponse<List<StudentResponseDto>>> searchStudents(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {

        List<Student> result = studentService.searchStudents(name, email);

        List<StudentResponseDto> responseList =
                result.stream().map(StudentMapper::toDto).toList();

        ApiResponse<List<StudentResponseDto>> response =
                new ApiResponse<>("success", "Filtered students fetched", responseList);

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<StudentResponseDto>>> getAllStudents() {

        List<Student> students = studentService.getAllStudents();

        List<StudentResponseDto> responseList =
                students.stream().map(StudentMapper::toDto).toList();

        ApiResponse<List<StudentResponseDto>> response =
                new ApiResponse<>("success", "All students fetched", responseList);

        return ResponseEntity.ok(response);
    }
}