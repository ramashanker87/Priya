package com.priya.app.controller;


import com.priya.app.repository.StudentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")

public class StudentController {
    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {

        this.studentRepository = studentRepository;}
    @GetMapping


}
