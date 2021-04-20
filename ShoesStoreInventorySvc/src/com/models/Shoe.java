package models;

import org.json.simple.JSONArray;

import enums.Sizes;
public class Shoe {
	private Sizes size;
	private String name;
	private int stock;
	JSONArray shoes = new JSONArray();
	public Shoe(String name,Sizes size,int stock) {
		this.setName(name);
		this.setSize(size);
		this.setStock(stock);
	}
	public Sizes getSize() {
		return size;
	}
	public void setSize(Sizes size) {
		this.size = size;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String toString() {
		
		return this.name + "," + this.size.toString() + "," + String.valueOf(stock);
	}
		
}
