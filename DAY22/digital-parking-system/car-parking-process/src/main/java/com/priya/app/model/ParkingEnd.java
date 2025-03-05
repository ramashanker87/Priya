package com.priya.app.model;


import jakarta.persistence.*;
import org.springframework.stereotype.Service;

import java.util.Date;
@Entity
@Service
public class ParkingEnd {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    String parkingNo;
    Date startTime;
    Date endTime;
    int price;
    String Status;
    String regNo;

    public String getParkingNo() {
        return parkingNo;
    }

    public void setParkingNo(String parkingNo) {
        this.parkingNo = parkingNo;
    }


    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    @ManyToOne
    @JoinColumn(name = "car_id")
    Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
