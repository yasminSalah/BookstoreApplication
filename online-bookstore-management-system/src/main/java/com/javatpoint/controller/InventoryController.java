package com.javatpoint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.javatpoint.model.Inventory;
import com.javatpoint.service.InventoryService;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @PutMapping("/{bookId}/stock-level")
    public Inventory updateStockLevel(@PathVariable Long bookId, @RequestParam int stockLevel) {
        return inventoryService.updateStockLevel(bookId, stockLevel);
    }

    @PutMapping("/{bookId}/availability")
    public Inventory setBookAvailability(@PathVariable Long bookId, @RequestParam boolean available) {
        return inventoryService.setBookAvailability(bookId, available);
    }
}
