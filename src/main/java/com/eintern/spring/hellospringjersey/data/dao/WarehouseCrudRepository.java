package com.eintern.spring.hellospringjersey.data.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.eintern.spring.hellospringjersey.data.entity.Warehouse;

public interface WarehouseCrudRepository extends CrudRepository<Warehouse, Long> {
	@Query("FROM Warehouse g WHERE g.name = :name")
	public Iterable<Warehouse> findAllByName(@Param("name") String name);
}
