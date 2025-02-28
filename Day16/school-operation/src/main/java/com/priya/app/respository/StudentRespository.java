package com.priya.app.respository;

import com.priya.app.model.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRespository extends CrudRepository<Student, String> {
    void deleteByName(String name);

    Student student(String id, String name);
}
