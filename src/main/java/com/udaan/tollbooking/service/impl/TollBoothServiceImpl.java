package com.udaan.tollbooking.service.impl;

import com.udaan.tollbooking.bl.PassType;
import com.udaan.tollbooking.dao.api.DataManager;
import com.udaan.tollbooking.model.Pass;
import com.udaan.tollbooking.model.TollBooth;
import com.udaan.tollbooking.model.Vehicle;
import com.udaan.tollbooking.service.api.TollBoothService;
import com.udaan.tollbooking.service.api.TxnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TollBoothServiceImpl implements TollBoothService {
    DataManager dataManager;
    TxnService txnService;

    @Autowired
    public TollBoothServiceImpl(DataManager dataManager, TxnService txnService) {
        this.dataManager = dataManager;
        this.txnService = txnService;
    }

    @Override
    public TollBooth create(Integer num) {
        return dataManager.create(num);
    }

    @Override
    public Boolean validate(Vehicle vehicle) {
        System.out.println("validating "+vehicle);
        Pass pass = dataManager.getPass(vehicle.getRegNum());
        return pass!=null && pass.getType().validate(pass);
    }

    @Override
    public Pass generatePass(PassType type, String regNum, Integer boothId) {
        // begin Txn
        Pass pass = dataManager.generatePass(type, regNum, boothId);
        txnService.create(regNum, boothId, type.getCost());
        // end Txn
        return pass;
    }

    @Override
    public Double getSaleAmount(Integer boothId) {
        return dataManager.getSalesAmount(boothId);
    }
}
