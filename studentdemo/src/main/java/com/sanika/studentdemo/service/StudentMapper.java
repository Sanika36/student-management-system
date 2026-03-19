package com.sanika.studentdemo.service;

import com.sanika.studentdemo.dto.StudentRequestDto;
import com.sanika.studentdemo.dto.StudentResponseDto;
import com.sanika.studentdemo.model.Student;

public class StudentMapper {

    public static Student toEntity(StudentRequestDto dto) {
        Student student = new Student();
        student.setName(dto.getName());
        student.setEmail(dto.getEmail());
        return student;
    }

    public static StudentResponseDto toDto(Student student) {
        StudentResponseDto dto = new StudentResponseDto();
        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setEmail(student.getEmail());
        return dto;
    }
}