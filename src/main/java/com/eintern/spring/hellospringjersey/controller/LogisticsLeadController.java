package com.eintern.spring.hellospringjersey.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.eintern.spring.hellospringjersey.data.entity.Item;
import com.eintern.spring.hellospringjersey.data.entity.Warehouse;
import com.eintern.spring.hellospringjersey.model.delegate.LogisticsLeadDelegate;

@Controller
@RequestMapping("/logisticslead")
public class LogisticsLeadController {
	@Autowired
	private LogisticsLeadDelegate leadDelegate;
	
	@RequestMapping(value="/request",method=RequestMethod.GET)
	public String getWarehouseForm(Model model) {
		model.addAttribute("warehouse", new Warehouse());
		return "/lead/addWarehouse";
	}
	
	@RequestMapping(value="/viewWarehouses", method=RequestMethod.GET)
	public String getItemView(Model model){
		System.out.println("Hello " + leadDelegate.getAllWarehouses());
		Iterable<Warehouse> dbWarehouses = leadDelegate.getAllWarehouses();
		
		
		
		for(Warehouse warehouse:dbWarehouses){
			System.out.println(warehouse.getName());
			
		}
		model.addAttribute("myWarehouses", dbWarehouses);
		
		return "/lead/currentWarehouses";
	}
	
	@RequestMapping(value="/submit",method=RequestMethod.POST)
	public String submit(@RequestParam("name") String name, @RequestParam("address") String address,
							@RequestParam("addressTwo") String addressTwo, @RequestParam("city") String city, 
							@RequestParam("state") String state, @RequestParam("zipcode") String zipcode, 
							Model model){
		System.out.println("Creating warehouse");
		Warehouse warehouse = new Warehouse();
		warehouse.setName(name);
		warehouse.setAddress(address);
		warehouse.setAptNumber(addressTwo);
		warehouse.setCity(city);
		warehouse.setState(state);
		warehouse.setZipcode(zipcode);
		
		leadDelegate.saveWarehouse(warehouse);
		model.addAttribute(warehouse);
		
		return "/lead/warehouseAdded";
	}
}
