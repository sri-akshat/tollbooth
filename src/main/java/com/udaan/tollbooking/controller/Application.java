package com.udaan.tollbooking.controller;

import com.udaan.tollbooking.bl.ReturnPass;
import com.udaan.tollbooking.model.TollBooth;
import com.udaan.tollbooking.model.Vehicle;
import com.udaan.tollbooking.model.VehicleType;
import com.udaan.tollbooking.service.api.TollBoothService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private TollBoothService tollBoothService;

    @Autowired
    public Application(TollBoothService tollBoothService) {
        this.tollBoothService = tollBoothService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        TollBooth t1 = tollBoothService.create(1);
        TollBooth t2 = tollBoothService.create(2);
        Vehicle v1 = Vehicle.builder()
                .regNum("KA-03-MW-2341").type(VehicleType.FOURWHEELER).build();
        System.out.println("Validity "+tollBoothService.validate(v1));
        tollBoothService.generatePass(new ReturnPass(), "KA-03-MW-2341", t1.getId());
        System.out.println("Validity "+tollBoothService.validate(v1));
        System.out.println("Sale for "+t1+" --> "+tollBoothService.getSaleAmount(t1.getId()));
    }
}
