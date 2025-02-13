package com.priya.app.respository;

import com.priya.app.model.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.HashMap;
import java.util.Map;

public interface StudentRespository extends CrudRepository<Student, Integer> {
    Map<String, Student> students = new HashMap<String, Student>();

    public default void deleteName(String name) {
        students.remove(name);
    }
}
