package com.eintern.spring.hellospringjersey.data.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.eintern.spring.hellospringjersey.model.delegate.InventoryDelegate;
import com.eintern.spring.hellospringjersey.model.delegate.LogisticsLeadDelegate;

@Entity
@Table(name = "Inventory")
public class Inventory {
	

	@Embeddable
	public static class Id implements Serializable{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Column(name="WAREHOUSE_ID")
		private Long warehouseId;
		
		@Column(name="ITEM_ID")
		private Long itemId;
		
		public Id(){}
		
		public Id(Long warehouseId, Long itemId){
			this.warehouseId = warehouseId;
			this.itemId = itemId;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result
					+ ((itemId == null) ? 0 : itemId.hashCode());
			result = prime * result
					+ ((warehouseId == null) ? 0 : warehouseId.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Id other = (Id) obj;
			if (itemId == null) {
				if (other.itemId != null)
					return false;
			} else if (!itemId.equals(other.itemId))
				return false;
			if (warehouseId == null) {
				if (other.warehouseId != null)
					return false;
			} else if (!warehouseId.equals(other.warehouseId))
				return false;
			return true;
		}
		
		
		/*public boolean equals(Object o){
			if (o != null && o instanceof Id){
				Id that = (Id)o;
				return this.warehouseId.equals(that.warehouseId) &&
						this.itemId.equals(that.itemId);
			}else{
				return false;
			}
		}
		
		
		public int hashCode(){
			return (warehouseId.hashCode() + itemId.hashCode());
		}*/
	}
	
	@EmbeddedId
	private Id id = new Id();
	
	@Column(name = "QUANTITY")
	private Long quantity;
	
	@Column(name = "CAPACITY")
	private Long capacity;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="WAREHOUSE_ID",
				insertable = false,
				updatable = false)
	private Warehouse warehouse;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="ITEM_ID",
				insertable = false,
				updatable = false)
	private Item item;
	
	public Inventory(){}
	
	public Inventory(long quantity,
						long capacity,
						Warehouse warehouse,
						Item item){
		this.quantity = quantity;
		this.capacity = capacity;
		this.warehouse = warehouse;
		this.item = item;
		
		//Set identifier values
		this.id.warehouseId = warehouse.getId();
		this.id.itemId = item.getId();
		
		//Guarantee referential integrity
		warehouse.getInventory().add(this);
		item.getInventory().add(this);
	}

	public Id getId() {
		return id;
	}

	public void setId(Id id) {
		this.id = id;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Long getCapacity() {
		return capacity;
	}

	public void setCapacity(Long capacity) {
		this.capacity = capacity;
	}

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
	
	

	
}
