package com.priya.app.resporitory;

import com.priya.app.model.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarResporitory extends CrudRepository<Car,Integer> {
}
