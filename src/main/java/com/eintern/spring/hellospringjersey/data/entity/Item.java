package com.eintern.spring.hellospringjersey.data.entity;

import java.sql.Blob;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Size;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;


@Entity
public class Item {
	@Id
	@GeneratedValue(generator="seq_greetingid", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="seq_greetingid",sequenceName="seq_greetingid")
	private long id;
	
	@Column
	@Size(min=2)
	private String name;
	
	@Column
	@Size(min=2)
	private String description;
	
	@Column
	@Lob
	private byte[] photo;
	
	//Invetories that this item is a part of
	@OneToMany(mappedBy="item", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private Set<Inventory> inventory = new HashSet<Inventory>();
	
	public Item(){}
	
	public Item(long id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	
	public String getByteArrayString(){
		String imageName = new String(this.photo);
		return new String(this.photo);
	}
	
	public String getBase(){
		return new String(Base64.encodeBase64(this.getPhoto(), false));
	}

	/*public Set<Warehouse> getInventory() {
		return inventory;
	}

	public void setInventory(Set<Warehouse> inventory) {
		this.inventory = inventory;
	}*/

	public Set<Inventory> getInventory() {
		return inventory;
	}

	public void setInventory(Set<Inventory> inventory) {
		this.inventory = inventory;
	}
	
	
	
	

	
}
