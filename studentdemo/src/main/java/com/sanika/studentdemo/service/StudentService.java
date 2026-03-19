package com.sanika.studentdemo.service;

import com.sanika.studentdemo.dto.StudentRequestDto;
import com.sanika.studentdemo.exception.StudentNotFoundException;
import com.sanika.studentdemo.model.Student;
import com.sanika.studentdemo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@Service
public class StudentService {
    private static final Logger logger = LoggerFactory.getLogger(StudentService.class);

    @Autowired
    private StudentRepository studentRepository ;

   public Student addStudent(Student student) {
       logger.info("Adding student :{} " ,student.getName() );
       Student savedStudent=studentRepository.save(student);
       logger.info("Student saved with id: {}", savedStudent.getId());
       return savedStudent;
   }

    public Student updateStudent(int id, StudentRequestDto request){

        logger.info("Updating student with id: {}",id);
        Student student =studentRepository.findById(id)
                        .orElseThrow(() ->{
                                logger.error("Student not found with id: {}",id);
                                return new StudentNotFoundException("Student not found");
                        });
        student.setName(request.getName());
        student.setEmail(request.getEmail());
        logger.info("Student updated successfully !!");
        return studentRepository.save(student );

    }
    public void deleteStudent(int id){

        logger.info("Deleting student with id : {}",id);
        Student student =studentRepository.findById(id)
                        .orElseThrow(() -> {
                            logger.error("Student not found with id: {}" ,id);
                           return new StudentNotFoundException("Student not found");
                        });
        studentRepository.delete(student);
        logger.info("Student deleted successfully with id : {}",id);
    }
    public List<Student> getStudentsByName(String name){
       return studentRepository.findByName(name);
    }
    public Student getStudentByEmail(String email){
        return studentRepository.findByEmail(email)
                .orElseThrow(() -> {
                    logger.error("Student not found with email: {}", email);
                    return new StudentNotFoundException("Student with email " + email + " not found");
                });
    }
    public List<Student> getStudentsByNameContaining(String keyword){
       return studentRepository .findByNameContaining(keyword);
    }
    public Student getStudentById(int id){
       logger.info("Fetching student with id : {} " ,id);
        return studentRepository.findById(id)
                .orElseThrow(() -> {
                    logger.error("Student not found with id: {}", id);
                    return new StudentNotFoundException("Student with id " + id + " not found");
                });

    }
    public Page<Student> getAllStudentsPage(int page, int size, String sortBy, String sortOrder) {
        Sort sort = sortOrder.equalsIgnoreCase("asc")
                ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(page, size, sort);
        return studentRepository.findAll(pageable);
    }
    public List<Student> searchStudents(String name, String email) {

        logger.info("Searching students with name: {} and email: {}", name, email);

        if (name != null && !name.isEmpty() && email != null && !email.isEmpty())
            return studentRepository.findByNameAndEmail(name, email);

        else if (name != null && !name.isEmpty())
            return studentRepository.findByName(name);

        else if (email != null && !email.isEmpty()) {
            Student student = studentRepository.findByEmail(email)
                    .orElseThrow(() -> {
                        logger.error("Student not found with email: {}", email);
                        return new StudentNotFoundException("Student with email " + email + " not found");
                    });

            return List.of(student);
        }

        else
            return studentRepository.findAll();
    }
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

}

