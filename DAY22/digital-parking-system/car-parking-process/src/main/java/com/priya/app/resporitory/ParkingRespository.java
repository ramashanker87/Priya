package com.priya.app.resporitory;
import com.priya.app.model.ParkingStart;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;


public interface ParkingRespository extends CrudRepository<ParkingStart,Integer> {
}
