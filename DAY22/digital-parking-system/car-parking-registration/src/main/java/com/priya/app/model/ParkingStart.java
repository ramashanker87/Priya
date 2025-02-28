package com.priya.app.model;


import org.springframework.stereotype.Service;


import java.util.Date;
@Service

public class ParkingStart {

     String parkingNo;
     Date startTime ;
    String Status;
    String regNo ;

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

    public ParkingStart() {}
    public ParkingStart(  String parkingNo,
    Date startTime,
    String Status,
    String regNo ) {
        super();
        this.parkingNo = parkingNo;
        this.startTime = startTime;
        this.Status = Status;
        this.regNo = regNo;


    }
}
