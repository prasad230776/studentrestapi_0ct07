package com.example.studentrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.studentrestapi.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{
    
}
