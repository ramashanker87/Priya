package com.priya.app.controller;


import com.priya.app.model.Student;
import com.priya.app.repository.StudentRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")

public class StudentController {
    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {

        this.studentRepository = studentRepository;
    }

    @GetMapping("/read")
    public Iterable<Student> read() {
        return studentRepository.findAll();
    }

    @PostMapping("/save")
    public String save(@RequestBody final Student student) {
        System.out.println("Saving student: " + student);
        studentRepository.save(student);
        return "save";
    }


}
