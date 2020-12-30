package com.udaan.tollbooking.bl;

import com.udaan.tollbooking.model.Pass;

public interface PassType {
    Boolean validate(Pass pass);
    Double getCost();
}
