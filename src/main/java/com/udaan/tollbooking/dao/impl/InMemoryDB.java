package com.udaan.tollbooking.dao.impl;

import com.udaan.tollbooking.bl.PassType;
import com.udaan.tollbooking.dao.api.DataManager;
import com.udaan.tollbooking.model.Pass;
import com.udaan.tollbooking.model.SalesReceipt;
import com.udaan.tollbooking.model.TollBooth;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class InMemoryDB implements DataManager {

    private AtomicInteger maxTollBoothId;
    private AtomicInteger maxPassId;
    private AtomicInteger maxTxnId;
    private Map<Integer, TollBooth> tollBoothMap;
    private Map<String, Pass> passByRegNum;
    private Map<Integer, SalesReceipt> salesReceiptMap;

    public InMemoryDB() {
        maxTollBoothId = new AtomicInteger(0);
        maxPassId = new AtomicInteger(0);
        maxTxnId = new AtomicInteger(0);
        tollBoothMap = new ConcurrentHashMap<>();
        passByRegNum = new ConcurrentHashMap<>();
        salesReceiptMap = new ConcurrentHashMap<>();
    }

    @Override
    public TollBooth create(Integer num) {
        Integer id = maxTollBoothId.incrementAndGet();
        TollBooth tollBooth = new TollBooth(id, num);
        tollBoothMap.put(id, tollBooth);
        System.out.println("Created "+tollBooth);
        return tollBooth;
    }

    @Override
    public Pass generatePass(PassType type, String regNum, Integer boothId) {
        Integer id = maxPassId.incrementAndGet();
        Pass pass = Pass.builder()
                .id(id)
                .boothId(boothId)
                .generatedOn(new Timestamp(System.currentTimeMillis()))
                .regNum(regNum)
                .type(type)
                .build();
        passByRegNum.put(regNum, pass);
        System.out.println("Created "+pass);
        return pass;
    }

    @Override
    public SalesReceipt create(String regNum, Integer boothId, Double amount) {
        Integer id = maxTxnId.incrementAndGet();
        SalesReceipt salesReceipt = SalesReceipt.builder()
                .id(id)
                .amount(amount)
                .boothId(boothId)
                .regNum(regNum).build();
        salesReceiptMap.put(id, salesReceipt);

        List<SalesReceipt> salesReceipts = tollBoothMap.get(boothId).getSalesReceipts();
        if(salesReceipts == null || salesReceipts.isEmpty())
            salesReceipts = new ArrayList<>();
        salesReceipts.add(salesReceipt);
        tollBoothMap.get(boothId).setSalesReceipts(salesReceipts);
        System.out.println("Created "+salesReceipt);
        return salesReceipt;
    }

    @Override
    public Pass getPass(String regNum) {
        return passByRegNum.get(regNum);
    }

    @Override
    public Double getSalesAmount(Integer boothId) {
        System.out.println("getSalesAmount");
        return tollBoothMap.get(boothId).getSalesReceipts().stream().map(s -> s.getAmount()).reduce(0.0, Double::sum);
    }
}
