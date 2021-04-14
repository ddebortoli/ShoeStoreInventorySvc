package models;

public class Shoe {
	private String size;
	private String name;
	public Shoe(String name,String size) {
		this.setName(name);
		this.setSize(size);
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
