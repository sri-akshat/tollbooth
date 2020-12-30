package com.udaan.tollbooking.bl;

import com.udaan.tollbooking.model.Pass;
import com.udaan.tollbooking.model.Vehicle;

import java.sql.Timestamp;

public class SinglePass implements PassType{
    public Boolean validate(Pass pass) {
        return new Timestamp(System.currentTimeMillis()).after(pass.getGeneratedOn());
    }

    public Double getCost() {
        return 30.0;
    }
}
