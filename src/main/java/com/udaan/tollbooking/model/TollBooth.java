package com.udaan.tollbooking.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
public class TollBooth {
    Integer id;
    Integer tollId;
    Integer number;
    List<SalesReceipt> salesReceipts;

    public TollBooth(Integer id, Integer number) {
        this.id = id;
        this.number = number;
    }

    @Override
    public String toString() {
        return "TollBooth{" +
                "id=" + id +
                ", number=" + number +
                '}';
    }
}
