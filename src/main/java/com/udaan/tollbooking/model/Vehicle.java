package com.udaan.tollbooking.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Vehicle {
    Integer id;
    String regNum;
    VehicleType type;

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", regNum='" + regNum + '\'' +
                ", type=" + type +
                '}';
    }
}
