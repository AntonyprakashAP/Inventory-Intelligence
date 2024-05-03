package com.algoriant.inventory.service;

import com.algoriant.inventory.model.Inventory;
import com.algoriant.inventory.model.InventoryRequest;

import java.util.List;

public interface InventorySerivce {

     void createInventory(InventoryRequest request);

     void removeInventory(String itemId );

     void modifyInventory(InventoryRequest inventoryRequest );

     Inventory getInventory(String itemId );

     List<Inventory> getAllInventory();
}
