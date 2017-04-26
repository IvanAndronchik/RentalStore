package edu.bsu.sportshop.shop;

/**
 * Title: Sport equipment Description:iformation about sport good Copyright:
 * Ivan Andronchik Copyright (c) 2017 Company:
 * 
 * @author Ivan Andronchik
 * @version 0.1
 *
 */

public class SportEquipment {
	// private Category category; ???
	private String title;//title of good
	private int price;//price of good
	private int quantity;// amount of good

	/**
	  * Constructor Shop
	  */
	
	SportEquipment() {
		setTitle("");
		setPrice(0);
		setQuantity(quantity);
	}

	/**
	  * Constructor Shop
	  */
	
	SportEquipment(String title, int price, int quantity) {
		this.setTitle(title);
		this.setPrice(price);
		this.setQuantity(quantity);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String toString() {
		return title + "\n Price: " + price + " Quantity: " + quantity;
	}

	/*
	 * public Category getCategory() { return category; }
	 * 
	 * public void setCategory(Category category) { this.category = category; }
	 */
}
