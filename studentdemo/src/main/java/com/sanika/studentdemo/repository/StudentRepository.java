package com.sanika.studentdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sanika.studentdemo.model.Student;
import java.util.List;
import java.util.Optional;
public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findByName(String name);

    Optional<Student> findByEmail(String email);

    List<Student> findByNameContaining(String keyword);

    List<Student> findByNameAndEmail(String name, String email);

}