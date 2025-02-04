package com.priya.app.repository;

import com.priya.app.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository  extends CrudRepository<Student, Integer> {
}
