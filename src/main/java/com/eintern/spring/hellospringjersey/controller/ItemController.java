package com.eintern.spring.hellospringjersey.controller;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;
import javax.validation.Valid;
import javax.ws.rs.FormParam;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.eintern.spring.hellospringjersey.data.entity.Greeting;
import com.eintern.spring.hellospringjersey.data.entity.Inventory;
import com.eintern.spring.hellospringjersey.data.entity.Item;
import com.eintern.spring.hellospringjersey.data.entity.Warehouse;
import com.eintern.spring.hellospringjersey.model.delegate.InventoryDelegate;
import com.eintern.spring.hellospringjersey.model.delegate.ItemDelegate;
import com.eintern.spring.hellospringjersey.model.delegate.WarehouseDelegate;

@Controller
@RequestMapping("/item")
public class ItemController {
	@Autowired
	private ItemDelegate itemDelegate;
	
	@Autowired
	private InventoryDelegate inventoryDelegate;
	
	@Autowired
	private WarehouseDelegate warehouseDelegate;
	
	@RequestMapping(method=RequestMethod.GET)
	public String getItem(Model model) {
		model.addAttribute("item", itemDelegate.getItem());
		return "item";
	}
	
	@RequestMapping(value="/viewItems", method=RequestMethod.GET)
	public String getItemView(Model model){
		System.out.println("Hello " + itemDelegate.getAllItems());
		Iterable<Item> dbItems = itemDelegate.getAllItems();
		
		
		
		/*for(Item testItem:dbItems){
			System.out.println(testItem.getPhoto());
			System.out.println(testItem.getByteArrayString());
		}*/
		model.addAttribute("myItems", dbItems);
		
		return "/lead/currentItems";
	}
	
	@RequestMapping(value="/addItem", method=RequestMethod.GET)
	public String addItem(Model model){
		Iterable<Item> dbItems = itemDelegate.getAllItems();
		
		/*Testing the output of the picture
		 * 
		 * for(Item testItem:dbItems){
			System.out.println(testItem.getPhoto());
			System.out.println(testItem.getByteArrayString());
		}*/
		
		model.addAttribute("myItems", dbItems);
		
		return "addItemToWarehouse";
	}
	
	
	@RequestMapping(value="/addItem", method=RequestMethod.POST)
	public String updateInventory(@RequestParam("quantity") long quantity,
									@RequestParam("capacity") long capacity,
									@RequestParam("itemId") long itemId, Model model){
		Iterable<Item> dbItems = itemDelegate.getAllItems();
		Item itemToAdd = new Item();
		itemToAdd = itemDelegate.getOneItem(itemId);
		
		Warehouse warehouseToAdd = new Warehouse();
		warehouseToAdd = warehouseDelegate.retrieveWarehouse(50);
		
		Warehouse myWarehouse = new Warehouse();
		myWarehouse = warehouseDelegate.retrieveWarehouse(50);
		
		Long testWarehouseId = warehouseToAdd.getId();
		Long testItemId = itemToAdd.getId();
		
		//System.out.println(testWarehouseId);
		//System.out.println(testItemId);

		Inventory inventoryToAdd = new Inventory(quantity, capacity, warehouseToAdd, itemToAdd);
		
		/*inventoryToAdd.setQuantity(quantity);
		inventoryToAdd.setCapacity(capacity);
		inventoryToAdd.setItem(itemToAdd);
		inventoryToAdd.setWarehouse(warehouseToAdd);*/
		
		//itemToAdd.getInventory().add(inventoryToAdd);
	
		System.out.println(inventoryToAdd.getItem().getId());
		System.out.println(inventoryToAdd.getWarehouse().getId());
		
		
		myWarehouse.addToInventory(inventoryToAdd);
		
		//warehouseDelegate.saveWarehouse(myWarehouse);
		inventoryDelegate.saveItem(inventoryToAdd);
		//model.addAttribute("myInventory", inventoryToAdd);
		
		return "addItemToWarehouse";
	}
	@RequestMapping(value="/request",method=RequestMethod.GET)
	public String getItemForm(Model model) {
		System.out.println("Start");
		model.addAttribute("item", new Item());
		return "/lead/itemForm";
	}
	
	
	@RequestMapping(value="/submit",method=RequestMethod.POST)
	public String submit(@RequestParam("name") String name, @RequestParam("description") String description,
							@RequestParam("file") MultipartFile file, Model model){
		System.out.println("Start");
		
		if(!file.isEmpty()){
			try{
				byte[] bytes = file.getBytes();
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(name)));
				stream.write(bytes);
				Item myItem = new Item();
				myItem.setName(name);
				myItem.setDescription(description);
				myItem.setPhoto(bytes);
				
				itemDelegate.saveItem(myItem);
				model.addAttribute(myItem);
				
				stream.close();
				System.out.println("File was added");
				return "/lead/itemAdded";
			}catch(Exception e){
				System.out.println("File received, but not uploaded");
				return "File received, but not uploaded";
			}
		}else{
			System.out.println("File was empty");
			return "File was empty";
		}
	}
	
}
