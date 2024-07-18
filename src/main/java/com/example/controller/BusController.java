package com.example.controller;

import com.example.entity.Bus;
import com.example.entity.Post;
import com.example.repository.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/bus")
@Validated
public class BusController {

    private BusRepository busRepository;

    @Autowired
    public BusController(BusRepository busRepository) {
        this.busRepository = busRepository;
    }

    @PostMapping
    public ResponseEntity<Bus> createBus(@RequestBody Bus bus){
        Bus savedBus = busRepository.save(bus);
        return new  ResponseEntity<>(savedBus, HttpStatus.CREATED);
    }
}
