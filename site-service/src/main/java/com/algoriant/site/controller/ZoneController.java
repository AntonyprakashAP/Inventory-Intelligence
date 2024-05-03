package com.algoriant.site.controller;

import com.algoriant.site.dto.ZoneRequest;
import com.algoriant.site.entity.Zone;
import com.algoriant.site.service.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/zone-service", produces = {MediaType.APPLICATION_JSON_VALUE})
@PreAuthorize("hasAnyAuthority('CUSTOMER_ADMIN')")
public class ZoneController {

    @Autowired
    private ZoneService service;

    @PostMapping("/createZone")
    public ResponseEntity<Zone> createZone(@RequestBody ZoneRequest request) {
        Zone zone = service.createZone(request);
        return new ResponseEntity<>(zone,HttpStatus.CREATED);
    }

    @GetMapping("/getAllZone")
    public ResponseEntity<List<Zone>> getAllZone() {
        return new ResponseEntity<>(service.getAllZone(),HttpStatus.OK);
    }

    @GetMapping("/getZoneById/{zoneId}")
    public ResponseEntity<Zone> getZoneById(@PathVariable UUID zoneId) {
        return new ResponseEntity<>(service.getZoneById(zoneId),HttpStatus.OK);
    }

    @DeleteMapping("/deleteZone/{zoneId}")
    public ResponseEntity<String> deleteZoneId(@PathVariable UUID zoneId) {
        service.deleteZoneById(zoneId);
        return new ResponseEntity<>("delete successfully",HttpStatus.OK);
    }

    @PostMapping("/updateZone/{zoneId}")
    public ResponseEntity<Zone> updateZone(@PathVariable UUID zoneId,@RequestBody ZoneRequest request) {
        return new ResponseEntity<>(service.updateZone(zoneId, request.getFloorId(),request.getZoneName(), request.getDescription()),HttpStatus.OK);
    }
}
