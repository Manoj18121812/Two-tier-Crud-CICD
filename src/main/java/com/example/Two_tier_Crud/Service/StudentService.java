package com.example.Two_tier_Crud.Service;

import com.example.Two_tier_Crud.Entity.Student;
import com.example.Two_tier_Crud.Repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private  StudentRepository studentRepo;

    public StudentService(StudentRepository studentRepo) {
        this.studentRepo = studentRepo;
    }

    public List<Student> getAllStudent(){
    return  studentRepo.findAll();
    }

    public void saveStudent(Student student){
         studentRepo.save(student);
    }

    public Student getStudentById(Long id){
        return studentRepo.findById(id).orElse(null);
    }

    public void deleteByid(Long id){
        studentRepo.deleteById(id);
    }

}
