package com.example.studentrestapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.studentrestapi.entity.Student;
import com.example.studentrestapi.service.StudentServiceInterface;

@RestController
public class StudentController {

    StudentServiceInterface studentService;

    StudentController(StudentServiceInterface studentService){
        this.studentService = studentService;
    }

    @PostMapping("/api/students")    
    public Student createStudent(@RequestBody Student student){
        Student student2 = studentService.createStudent(student);
        return student2;
    }

    @GetMapping("/api/students")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/api/students/{id}")
    public Student getStudent(@PathVariable Integer id){
        return studentService.findById(id);
    }

    @PutMapping("/api/students")
    public Student updateStudent(@RequestBody Student student){
        return studentService.updateStudent(student);
    }

    @DeleteMapping("/api/students/{id}")
    public String deleteStudent(@PathVariable Integer id){
        studentService.deleteStudent(id);
        return "deletion successful";
    }


    
}
