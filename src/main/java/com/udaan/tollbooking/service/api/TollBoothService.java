package com.udaan.tollbooking.service.api;

import com.udaan.tollbooking.bl.PassType;
import com.udaan.tollbooking.model.Pass;
import com.udaan.tollbooking.model.TollBooth;
import com.udaan.tollbooking.model.Vehicle;
import org.springframework.stereotype.Service;

@Service
public interface TollBoothService {
    TollBooth create(Integer num);
    Boolean validate(Vehicle vehicle);
    Pass generatePass(PassType type, String regNum, Integer boothId);
    Double getSaleAmount(Integer boothId);
}
