package org.example.first_springboot_webapp.controller;

import org.example.first_springboot_webapp.entity.Student;
import org.example.first_springboot_webapp.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }
    //create student
    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        System.out.println("Inside StudentController");
        Student createdStudent=studentService.createStudent(student);
        System.out.println("Outside StudentController");
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);


    }
    //read 1 student
    @GetMapping("/get/{id}")
    public ResponseEntity<Student>getStudent(@PathVariable Long id){
        Student StudFromService=studentService.getStudent(id);
        if(StudFromService==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(StudFromService);

    }
    //getAll
    @GetMapping("/getAll")
    public ResponseEntity<List<Student>>getAllStudent(){
        List<Student> StudFromServiceList=studentService.getAllStudent();
        if(StudFromServiceList==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(StudFromServiceList);

    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Student>updateStudent(@PathVariable Long id,
                                                @RequestBody Student studentBody
    ){
        Student StudFromService=studentService.updateStudent(id,studentBody);
        if(StudFromService==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(StudFromService);

    }
    //delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id){
        Boolean isDeleted=studentService.deleteStudent(id);
        if(!isDeleted){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Student Successfully deleted!");
    }

}
