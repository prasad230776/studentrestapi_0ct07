package com.example.studentrestapi.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.studentrestapi.entity.Student;
import com.example.studentrestapi.repository.StudentRepository;

@Service
public class StudentService implements StudentServiceInterface {
    StudentRepository studentRepository;
    StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }
        
    @Override
    public Student createStudent(Student student){
        Student student2 = studentRepository.save(student);
        return student2;
    }

    @Override
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }


    @Override
    public Student updateStudent( Student student){
        return studentRepository.save(student);
    }

    
    @Override
    public boolean deleteStudent(Integer id){
        Student st = studentRepository.findById(id).orElse(null);
        studentRepository.deleteById(id);
        if(st== null){
            return false;
        }
        return true;
        
    }

    @Override
    public Student findById(Integer id) {
       return studentRepository.findById(id).orElse(null);
    //    Student s=null;
    //    try{
    //    s = studentRepository.findById(id).get();
    //    }catch(Exception e){
    //     System.out.println(e);
    //    }
    //    return s;
    }

    
}
