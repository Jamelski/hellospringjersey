package com.eintern.spring.hellospringjersey.data.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.eintern.spring.hellospringjersey.data.entity.*;


@Repository
public interface ItemCrudRepository extends CrudRepository<Item, Long> {
	@Query("FROM Item g WHERE g.name = :name")
	public Iterable<Item> findAllByName(@Param("name") String name);
}
