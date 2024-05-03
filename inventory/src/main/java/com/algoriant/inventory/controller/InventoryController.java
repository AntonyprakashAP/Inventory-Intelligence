package com.algoriant.inventory.controller;


import com.algoriant.inventory.model.Inventory;
import com.algoriant.inventory.model.InventoryRequest;
import com.algoriant.inventory.service.InventorySerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;


@RestController
@RequestMapping(value = "/inventoryController")
public class InventoryController {

    @Autowired
    private InventorySerivce service;

    @PreAuthorize("hasAuthority('CUSTOMER_ADMIN')")
    @PostMapping("/createInventory")
    public ResponseEntity<String> createInventory(@RequestBody InventoryRequest inventoryRequest) {
        try {
            service.createInventory(inventoryRequest);
            return new ResponseEntity<>("CREATE SUCCESSFULLY", HttpStatus.CREATED);
        } catch (Throwable th) {
            return new ResponseEntity<>("CREATION FAILED, ENTER VALID DATA", HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PreAuthorize("hasAnyAuthority('CUSTOMER_ADMIN','STOCK_MANAGER')")
    @DeleteMapping("/deleteInventory/{id}")
    public ResponseEntity<String> removeInventory(@PathVariable("id") String id) {
        try {
            service.removeInventory(id);
            return new ResponseEntity<>("DELETED SUCCESSFULLY", HttpStatus.OK);
        } catch (Throwable th) {
            return new ResponseEntity<>("DELETION FAILED", HttpStatus.NOT_MODIFIED);
        }
    }

    @PreAuthorize("hasAnyAuthority('CUSTOMER_ADMIN','STOCK_MANAGER')")
    @PutMapping("/modifyInventory")
    public ResponseEntity<String> modifyInventory(@RequestBody InventoryRequest inventoryRequest) {
        try {
            service.modifyInventory(inventoryRequest);
            return new ResponseEntity<>("UPDATE SUCCESSFULLY", HttpStatus.OK);
        } catch (Throwable th) {
            return new ResponseEntity<>("UPDATING FAILED", HttpStatus.NOT_MODIFIED);
        }
    }

    @PreAuthorize("hasAuthority('CUSTOMER_ADMIN')")
    @GetMapping("/getAllInventory")
    public ResponseEntity<List<Inventory>> getAllInventory() {
        try {
            List<Inventory> inventoryDTOList = service.getAllInventory();
            return new ResponseEntity<>(inventoryDTOList, HttpStatus.OK);
        } catch (Throwable th) {
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.NOT_FOUND);
        }
    }

    @PreAuthorize("hasAnyAuthority('CUSTOMER_ADMIN','STOCK_MANAGER')")
    @GetMapping("/getInventoryById/{id}")
    public ResponseEntity<Inventory> getInventoryById(@PathVariable("id") String id) {
        try {
            return new ResponseEntity<>(service.getInventory(id), HttpStatus.OK);
        } catch (Throwable th) {
            return new ResponseEntity<>(new Inventory(), HttpStatus.NOT_FOUND);
        }
    }

}
