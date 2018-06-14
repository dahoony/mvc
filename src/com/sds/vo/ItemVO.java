package com.sds.vo;

public class ItemVO {
	private int itemId;
	private String itemName;
	private double price;
	private String id;
	
	public ItemVO() {
	}

	public ItemVO(String name, double price, String id) {
		this.itemName = name;
		this.price = price;
		this.id = id;
	}

	public ItemVO(int itemId, String name, double price, String id) {
		this.itemId = itemId;
		this.itemName = name;
		this.price = price;
		this.id = id;
	}
	
	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ItemVO [itemId=" + itemId + ", name=" + itemName + ", price=" + price + ", id=" + id + "]";
	}
	
}
