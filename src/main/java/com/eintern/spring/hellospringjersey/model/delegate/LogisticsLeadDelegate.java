package com.eintern.spring.hellospringjersey.model.delegate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eintern.spring.hellospringjersey.data.dao.LogisticsLeadCrudRepository;
import com.eintern.spring.hellospringjersey.data.entity.Greeting;
import com.eintern.spring.hellospringjersey.data.entity.Item;
import com.eintern.spring.hellospringjersey.data.entity.Warehouse;

@Component
public class LogisticsLeadDelegate {
	@Autowired
	private LogisticsLeadCrudRepository leadRepository;
	
	public Warehouse saveWarehouse(Warehouse warehouse){
		return leadRepository.save(warehouse);
	}
	
	
	public Iterable<Warehouse> getAllWarehouses() {
		return leadRepository.findAll();
	}
	
	public Warehouse retrieveWarehouse(long id){
		return leadRepository.findOne(id);
	}
}
