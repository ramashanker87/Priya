package com.priya.app.respository;

import com.priya.app.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRespository extends CrudRespository<Student, Integer> {
}
