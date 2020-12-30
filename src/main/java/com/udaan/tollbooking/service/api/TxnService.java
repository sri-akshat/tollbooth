package com.udaan.tollbooking.service.api;

import com.udaan.tollbooking.model.SalesReceipt;
import org.springframework.stereotype.Service;

@Service
public interface TxnService {
    SalesReceipt create(String regNum, Integer boothId, Double amount);
}
