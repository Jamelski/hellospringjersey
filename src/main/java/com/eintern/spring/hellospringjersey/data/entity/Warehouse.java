package com.eintern.spring.hellospringjersey.data.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Warehouse {
	@Id
	@GeneratedValue(generator="seq_warehouseid", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="seq_warehouseid",sequenceName="seq_warehouseid")
	private long id;
	
	@Column
	private String name;
	
	@Column
	private String address;
	
	@Column
	private String city;
	
	@Column
	private String state;
	
	@Column
	private String zipcode;
	
	@Column
	private String aptNumber;
	
	@OneToMany(mappedBy = "warehouse", fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	private Set<Inventory> inventory = new HashSet<Inventory>();
	
	//Implement when roles are implemented
	//private User manager;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getAptNumber() {
		return aptNumber;
	}
	public void setAptNumber(String aptNumber) {
		this.aptNumber = aptNumber;
	}
	public Set<Inventory> getInventory() {
		return inventory;
	}
	
	public void addToInventory(Inventory inventory){
		this.inventory.add(inventory);
	}
	public void setInventory(Set<Inventory> inventory) {
		this.inventory = inventory;
	}
	
	/*public Set<Item> getInventory() {
		return inventory;
	}
	public void setInventory(Set<Item> inventory) {
		this.inventory = inventory;
	}*/
	
	
	
}
