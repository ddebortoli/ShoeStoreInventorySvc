package services;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import models.Shoe;
import repositories.getShoes;
public class validateData {
	
	private Shoe shoe;
	private ArrayList<String> result = new ArrayList<String>();
	
	public validateData(Shoe shoe) {
		this.shoe = shoe;
	}
	
	public ArrayList<String> getData(){
		if(!isNotValidData()) {
			getShoes getData = new getShoes(shoe.getName(),shoe.getSize());
			return (getData.getShoesFromDB());
		}
		return result;
		
	}
	
	private boolean isNotValidData() {
		boolean Error = false;
		String size = shoe.getSize();
		List<String> list = Arrays.asList("31", "32", "33", "34");

		
		//Check for value of size
		if (!list.contains(size)) {
			result.add("input parameter value is not allowed");
			Error = true;
		}
		
		try {
	        Integer.parseInt(size);
	    }catch (NumberFormatException excepcion) {
	    	result.add("input parameter with wrong value");
	        Error = true;
	    }
		
		return Error;
		
		
	}
}
