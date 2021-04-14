package services;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import models.Shoe;
import repositories.ShoesRepository;
public class ValidateData {
	
	private ArrayList<String> result = new ArrayList<String>();
	
	public ValidateData() {
	}
	
	public ArrayList<String> getData(Shoe shoe){
		if(isValidData(shoe)) {
			ShoesRepository  getData = new ShoesRepository (shoe.getName(),shoe.getSize());
			return (getData.getShoesFromDB());
		}
		return result;
	}
	
	private boolean isValidData(Shoe shoe) {
		boolean Error = true;
		String size = shoe.getSize();
		List<String> list = Arrays.asList("31", "32", "33", "34");

		
		//Check for value of size
		if (!list.contains(size)) {
			result.add("input parameter value is not allowed");
			Error = false;
		}
		
		try {
	        Integer.parseInt(size);
	    }catch (NumberFormatException excepcion) {
	    	result.add("input parameter with wrong value");
	        Error = false;
	    }
		
		return Error;
		
		
	}
}
