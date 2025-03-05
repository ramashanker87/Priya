package com.priya.app.resporitory;

import com.priya.app.model.Car;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarResporitory extends JpaRepository<Car, Integer> {

    Car findByRegNo(String regNo);
}
