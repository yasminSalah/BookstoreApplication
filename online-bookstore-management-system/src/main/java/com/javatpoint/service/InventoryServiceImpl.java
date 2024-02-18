package com.javatpoint.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javapoint.repository.InventoryRepository;
import com.javatpoint.exception.ResourceNotFoundException;
import com.javatpoint.model.Inventory;

@Service
public class InventoryServiceImpl implements InventoryService{

	  @Autowired
	    private InventoryRepository inventoryRepository;

	    public Inventory updateStockLevel(Long bookId, int stockLevel) {
	        Inventory inventory = inventoryRepository.findById(bookId)
	                .orElseThrow(() -> new ResourceNotFoundException("Inventory", "bookId", bookId));
	        inventory.setStockLevel(stockLevel);
	        return inventoryRepository.save(inventory);
	    }

	    public Inventory setBookAvailability(Long bookId, boolean available) {
	        Inventory inventory = inventoryRepository.findById(bookId)
	                .orElseThrow(() -> new ResourceNotFoundException("Inventory", "bookId", bookId));
	        inventory.getBook().setAvailable(available);
	        return inventoryRepository.save(inventory);
	    }
}
