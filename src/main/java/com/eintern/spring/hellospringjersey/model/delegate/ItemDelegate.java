package com.eintern.spring.hellospringjersey.model.delegate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eintern.spring.hellospringjersey.data.dao.GreetingCrudRepository;
import com.eintern.spring.hellospringjersey.data.dao.ItemCrudRepository;
import com.eintern.spring.hellospringjersey.data.entity.Greeting;
import com.eintern.spring.hellospringjersey.data.entity.Item;

@Component
public class ItemDelegate {
	@Autowired
	private ItemCrudRepository itemCrud;
	public String getItem() {
		return "Hello Item!";
	}
	
	public Item saveItem(Item item) {
		return itemCrud.save(item);
	}
	
	public Iterable<Item> getAllItems() {
		return itemCrud.findAll();
	}
	
	public Item getOneItem(Long id){
		return itemCrud.findOne(id);
	}
	
	public Iterable<Item> getAllItemsByName(String name) {
		return itemCrud.findAllByName(name);
	}
}
