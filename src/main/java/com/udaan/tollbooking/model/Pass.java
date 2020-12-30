package com.udaan.tollbooking.model;

import com.udaan.tollbooking.bl.PassType;
import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Builder
public class Pass {
    Integer id;
    Integer boothId;
    String regNum;
    Timestamp generatedOn;
    PassType type;
    Double balance;
    Integer count;

    @Override
    public String toString() {
        return "Pass{" +
                "id=" + id +
                ", boothId=" + boothId +
                ", regNum='" + regNum + '\'' +
                ", generatedOn=" + generatedOn +
                ", type=" + type +
                ", balance=" + balance +
                '}';
    }
}
