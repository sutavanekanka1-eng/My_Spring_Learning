package org.example.first_springboot_webapp.service;

import org.example.first_springboot_webapp.entity.Student;
import org.example.first_springboot_webapp.repository.StudentRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }
    public Student createStudent(Student student){
        System.out.println("Inside StudentService");
         Student student_same=studentRepository.save(student);
        System.out.println("Outside StudentService");
        return student_same;

    }
    public Student getStudent(Long id){
        Optional<Student>StudentFromRepo=studentRepository.findById(id);
        if(StudentFromRepo.isPresent()){
            return StudentFromRepo.get();

        }
        return null;
    }
    public List<Student> getAllStudent(){
        List<Student>StudentListFromRepo=studentRepository.findAll();
        return StudentListFromRepo;

    }
    public Student updateStudent(Long id,Student studBody){
        Optional<Student>StudentFromRepo=studentRepository.findById(id);
        if(StudentFromRepo.isEmpty()){
            return null;
        }
        Student studentFromOptional=StudentFromRepo.get();
        studentFromOptional.setName(studBody.getName());
        studentFromOptional.setAge(studBody.getAge());
        studentFromOptional.setEmail(studBody.getEmail());
        studentFromOptional.setRollNo(studBody.getRollNo());
        Student student_new=studentRepository.save(studentFromOptional);
        return student_new;


    }
    public Boolean deleteStudent(Long id){
        Boolean isPresent=studentRepository.existsById(id);
        if(!isPresent){
            return false;
        }
        studentRepository.deleteById(id);
        return true;


    }

    //postman-->StudentController-->StudentService-->Student Repository-->Interact with DB <-|
    //    {json}   http request  business logic    DB Interaction      student pojo class_|

    //End point listen

    //Business logic

    //interact with db to store

    //response back to client(postman)

}
