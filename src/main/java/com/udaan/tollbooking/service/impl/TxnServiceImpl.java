package com.udaan.tollbooking.service.impl;

import com.udaan.tollbooking.dao.api.DataManager;
import com.udaan.tollbooking.model.SalesReceipt;
import com.udaan.tollbooking.service.api.TxnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TxnServiceImpl implements TxnService {
    DataManager dataManager;

    @Autowired
    public TxnServiceImpl(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public SalesReceipt create(String regNum, Integer boothId, Double amount) {
        return dataManager.create(regNum, boothId, amount);
    }
}
