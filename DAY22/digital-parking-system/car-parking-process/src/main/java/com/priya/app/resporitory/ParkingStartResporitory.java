package com.priya.app.resporitory;

import com.priya.app.model.ParkingStart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ParkingStartResporitory extends JpaRepository<ParkingStart,Integer> {
    ParkingStart findByRegNo(String regNo);
}
