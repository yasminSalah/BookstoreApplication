package com.javatpoint.service;

import com.javatpoint.model.Inventory;

public interface InventoryService {
	
	 Inventory updateStockLevel(Long bookId, int stockLevel);
	 Inventory setBookAvailability(Long bookId, boolean available);

}
