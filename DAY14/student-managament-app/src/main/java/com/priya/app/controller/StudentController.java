package com.priya.app.controller;
import com.priya.app.model.Student;
import com.priya.app.respository.StudentRespository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentRespository studentRespository;

    public StudentController(StudentRespository studentRespository) {
        this.studentRespository = studentRespository;
    }

    @GetMapping("/read")
    public Iterable<Student> read() {
        return studentRespository.findAll();
    }


@PostMapping("/save")
public String save(@RequestBody final Student student) {
    System.out.println("Saving student: " + student);
    studentRespository.save(student);
    return "save";

}
}