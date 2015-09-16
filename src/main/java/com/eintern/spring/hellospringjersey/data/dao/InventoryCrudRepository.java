package com.eintern.spring.hellospringjersey.data.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.eintern.spring.hellospringjersey.data.entity.Inventory;
import com.eintern.spring.hellospringjersey.data.entity.Item;
import com.eintern.spring.hellospringjersey.data.entity.Warehouse;

@Repository
public interface InventoryCrudRepository extends CrudRepository<Inventory, Long> {
	List<Inventory> findByWarehouse(Warehouse warehouse);
}
