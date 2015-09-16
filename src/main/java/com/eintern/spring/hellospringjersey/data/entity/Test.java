package com.eintern.spring.hellospringjersey.data.entity;

import com.eintern.spring.hellospringjersey.model.delegate.InventoryDelegate;
import com.eintern.spring.hellospringjersey.model.delegate.ItemDelegate;
import com.eintern.spring.hellospringjersey.model.delegate.LogisticsLeadDelegate;

public class Test {
	public static void main(String[] args) {
		InventoryDelegate inventoryDelegate = new InventoryDelegate();
		LogisticsLeadDelegate llDelegate = new LogisticsLeadDelegate();
		

		//Warehouse oneWarehouse = llDelegate.retrieveWarehouse(50);
		//System.out.println(oneWarehouse.getName());
		
		//Iterable<Warehouse> warehouses = llDelegate.getAllWarehouses();
		
		Warehouse warehouse = new Warehouse();
		Item item = new Item();
		
		Inventory myInventory = new Inventory();
		
		ItemDelegate iDelegate = new ItemDelegate();
		
		Iterable<Item> myItem = iDelegate.getAllItems();
		for(Item i:myItem){
			System.out.println(i.getName());
		}
	}
}
