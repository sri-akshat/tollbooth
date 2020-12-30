package com.udaan.tollbooking.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SalesReceipt {
    Integer id;
    String regNum;
    Integer boothId;
    Double amount;

    @Override
    public String toString() {
        return "SalesReceipt{" +
                "id=" + id +
                ", regNum='" + regNum + '\'' +
                ", boothId=" + boothId +
                ", amount=" + amount +
                '}';
    }
}
