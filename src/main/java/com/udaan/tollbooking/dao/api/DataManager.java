package com.udaan.tollbooking.dao.api;

import com.udaan.tollbooking.bl.PassType;
import com.udaan.tollbooking.model.Pass;
import com.udaan.tollbooking.model.SalesReceipt;
import com.udaan.tollbooking.model.TollBooth;
import org.springframework.stereotype.Service;

@Service
public interface DataManager {
    TollBooth create(Integer num);
    Pass generatePass(PassType type, String regNum, Integer boothId);
    SalesReceipt create(String regNum, Integer boothId, Double amount);
    Pass getPass(String regNum);
    Double getSalesAmount(Integer boothId);

}
