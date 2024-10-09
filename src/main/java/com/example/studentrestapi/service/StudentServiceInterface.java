package com.example.studentrestapi.service;

import java.util.List;

import com.example.studentrestapi.entity.Student;

public interface StudentServiceInterface {

    Student createStudent(Student student);

    List<Student> getAllStudents();

    Student updateStudent(Student student);

    String deleteStudent(Integer id);

    Student findById(Integer id);

}