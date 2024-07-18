package com.example.controller;

import com.example.entity.Bus;
import com.example.entity.Stop;
import com.example.repository.StopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/stop")
@Validated
public class StopController {

    private StopRepository stopRepository;

    @Autowired
    public StopController(StopRepository stopRepository) {
        this.stopRepository = stopRepository;
    }
    @PostMapping
    public ResponseEntity<Stop> createStop(@RequestBody Stop stop){
        Stop savedStop = stopRepository.save(stop);
        return new  ResponseEntity<>(savedStop, HttpStatus.CREATED);
    }

}
