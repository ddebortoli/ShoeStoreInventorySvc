package services;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import repositories.getShoes;
public class validateData {
	
	private String name;
	private String size;
	private ArrayList<String> result = new ArrayList<String>();
	
	public validateData(String name,String size) {
		this.name = name;
		this.size = size;
	}
	
	public ArrayList<String> getData(){
		if(!isNotValidData()) {
			getShoes getData = new getShoes(this.name,this.size);
			return (getData.getShoesFromDB());
		}
		return result;
		
	}
	
	private boolean isNotValidData() {
		boolean Error = false;
		List<String> list = Arrays.asList("31", "32", "33", "34");

		//Check for mandatory parameters
		if (this.name == null || this.size == null) {
			result.add("Mandatory parameter(s) missing");
			Error = true;
		}
		//Check for value of size
		if (!list.contains(this.size)) {
			result.add("input parameter value is not allowed");
			Error = true;
		}
		
		try {
	        Integer.parseInt(this.size);
	    }catch (NumberFormatException excepcion) {
	    	result.add("input parameter with wrong value");
	        Error = true;
	    }
		
		return Error;
		
		
	}
}
