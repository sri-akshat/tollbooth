package com.udaan.tollbooking.model;

import lombok.Data;

import java.util.List;

@Data
public class Toll {
    Integer id;
    List<TollBooth> tollBooths;
}
