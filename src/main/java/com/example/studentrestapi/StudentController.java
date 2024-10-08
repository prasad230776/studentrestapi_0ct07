package com.example.studentrestapi;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    StudentRepository studentRepository;

    StudentController(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @PostMapping("/api/students")    
    public Student createStudent(@RequestBody Student student){
        Student student2 = studentRepository.save(student);
        return student2;
    }

    @GetMapping("/api/students")
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    @PutMapping("/api/students")
    public Student updateStudent(@RequestBody Student student){
        return studentRepository.save(student);
    }

    @DeleteMapping("/api/students/{id}")
    public String deleteStudent(@PathVariable Integer id){
        studentRepository.deleteById(id);
        return "deletion successful";
    }


    
}
