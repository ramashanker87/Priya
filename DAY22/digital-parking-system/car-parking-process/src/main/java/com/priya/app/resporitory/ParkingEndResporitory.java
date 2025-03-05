package com.priya.app.resporitory;

import com.priya.app.model.ParkingEnd;
import com.priya.app.model.ParkingStart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ParkingEndResporitory extends JpaRepository<ParkingEnd,Integer> {

   ParkingEnd findByRegNo(String regNo);
}
