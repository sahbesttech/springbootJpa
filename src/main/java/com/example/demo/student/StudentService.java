package com.example.demo.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
//        Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.);
//        if (studentByEmail.isPresent()){
//            try {
//                throw new IllegalAccessException("Email Taken");
//            } catch (IllegalAccessException e) {
//                throw new RuntimeException(e);
//            }
//        }


        studentRepository.save(student);
    }

    public void deleteStudent(Long studentID) {
        boolean studentExists = studentRepository.existsById(studentID);
        if (!studentExists){
            throw new IllegalStateException("student with the id " + studentID + " does not exists, please check again");
        }
        studentRepository.deleteById(studentID);
    }

    @Transactional
    public void updateStudent(Long studentID, String name, String email) {
        Student student = studentRepository.findById(studentID)
                .orElseThrow(()->new IllegalStateException("student with the id " + studentID + " does not exist"));
        if (name != null && !name.isEmpty() && !Objects.equals(student.getName(),name)){
            student.setName(name);
        }

        if (email != null && email.length() > 0 && !Objects.equals(student.getEmail(),email)){
//            studentRepository.findOne()
            student.setEmail(email);
        }
    }
}
