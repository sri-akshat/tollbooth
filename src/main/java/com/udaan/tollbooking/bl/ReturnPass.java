package com.udaan.tollbooking.bl;

import com.udaan.tollbooking.model.Pass;

public class ReturnPass implements PassType{
    public Boolean validate(Pass pass) {
        return (pass.getGeneratedOn().getTime()+ 24*60*60*60) > System.currentTimeMillis();
    }

    public Double getCost() {
        return 60.0;
    }
}
