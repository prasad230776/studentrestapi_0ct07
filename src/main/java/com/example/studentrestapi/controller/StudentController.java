package com.example.studentrestapi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student student2 = studentService.createStudent(student);
        if(student2 != null){
            return ResponseEntity.ok(student2);
        }
        return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body(null);
    }

    @GetMapping("/api/students")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/api/students/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Integer id){
        ResponseEntity<Student> rs;
        Student s = studentService.findById(id);
        if( s!= null){
            // rs = ResponseEntity.status(HttpStatus.OK).body(s);
            rs = ResponseEntity.ok(s);
        }
        else{
            rs = ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return rs;
    }

    @PutMapping("/api/students")
    public Student updateStudent(@RequestBody Student student){
        return studentService.updateStudent(student);
    }

    @DeleteMapping("/api/students/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Integer id){
        boolean success = studentService.deleteStudent(id);
        if(success){
            return ResponseEntity.ok("deletion is successful");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("student not found with id : "+ id);
    }   
}
