package com.algoriant.site.controller;

import com.algoriant.site.dto.FloorRequest;
import com.algoriant.site.entity.Floor;
import com.algoriant.site.service.FloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/floor-service", produces = {MediaType.APPLICATION_JSON_VALUE})
@PreAuthorize("hasAnyAuthority('CUSTOMER_ADMIN')")
public class FloorController {

    @Autowired
    private FloorService service;

    @PostMapping("/createFloor")
    public ResponseEntity<Floor> createFloor(@RequestBody FloorRequest request) {
        Floor floor = service.createFloor(request);
        return new ResponseEntity<>(floor, HttpStatus.CREATED);
    }
    @GetMapping("/getAllFloor")
    public  ResponseEntity<List<Floor>> getAllFloor() {
        return new ResponseEntity<>(service.getAllFloor(),HttpStatus.OK);
    }

    @GetMapping("/getFloorById/{floorId}")
    public ResponseEntity<Floor> getFloorById(@PathVariable UUID floorId) {
        return new ResponseEntity<>(service.getFloorById(floorId),HttpStatus.OK);
    }

    @DeleteMapping("/deleteFloor/{floorId}")
    public ResponseEntity<String> deleteFloor(@PathVariable UUID floorId) {
        service.deleteFloorById(floorId);
        return new ResponseEntity<>("delete successfully",HttpStatus.OK);
    }

    @PutMapping("/updateFloor/{floorId}")
    public ResponseEntity<Floor> updateFloor(@PathVariable UUID floorId, @RequestBody FloorRequest request) {
        return new ResponseEntity<>(service.updateFloor(floorId, request),HttpStatus.OK);
    }
}
