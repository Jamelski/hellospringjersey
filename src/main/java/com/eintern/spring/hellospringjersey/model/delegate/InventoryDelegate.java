package com.eintern.spring.hellospringjersey.model.delegate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eintern.spring.hellospringjersey.data.dao.InventoryCrudRepository;

import com.eintern.spring.hellospringjersey.data.entity.Inventory;

@Component
public class InventoryDelegate {
	@Autowired
	private InventoryCrudRepository inventoryCrud;
	
	public Inventory saveItem(Inventory inventory) {
		return inventoryCrud.save(inventory);
	}
}
