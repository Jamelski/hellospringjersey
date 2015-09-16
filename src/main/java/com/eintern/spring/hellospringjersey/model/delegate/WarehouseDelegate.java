package com.eintern.spring.hellospringjersey.model.delegate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eintern.spring.hellospringjersey.data.dao.LogisticsLeadCrudRepository;
import com.eintern.spring.hellospringjersey.data.entity.Warehouse;

@Component
public class WarehouseDelegate {
	@Autowired
	private LogisticsLeadCrudRepository leadRepository;
	
	public Warehouse retrieveWarehouse(long id){
		return leadRepository.findOne(id);
	}
	
	public Warehouse saveWarehouse(Warehouse warehouse){
		return leadRepository.save(warehouse);
	}
}
