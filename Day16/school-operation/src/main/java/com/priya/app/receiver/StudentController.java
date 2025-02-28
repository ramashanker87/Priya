package com.priya.app.receiver;

import com.priya.app.model.Student;
import com.priya.app.respository.StudentRespository;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping("/school")
public class StudentController {
    private final StudentRespository studentRespository;
    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(StudentController.class);

    public StudentController(StudentRespository studentRespository) {
        this.studentRespository = studentRespository;
    }

    @GetMapping("/read")
    public  Iterable<Student> readAll() throws InterruptedException {
        LOGGER.info("Receiver get request:");
        { return studentRespository.findAll();}
    }
        @PostMapping("/save")
        public Student save(@RequestBody Student student) throws InterruptedException {
            LOGGER.info("Receiver save request:");
            return studentRespository.save(student);
        }

    @PutMapping ("/update")
    public Student update(@RequestParam("id") String id, @RequestParam("name") String name) throws InterruptedException {
        LOGGER.info("Receiver update request:");
        return studentRespository.student(id,name);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam String name) throws InterruptedException {
        LOGGER.info("Receiver delete request:");
        studentRespository.deleteByName(name);
        }



}
