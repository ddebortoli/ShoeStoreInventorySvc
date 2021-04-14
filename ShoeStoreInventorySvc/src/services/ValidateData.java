package services;
import java.util.Arrays;
import java.util.List;

import models.Shoe;
import repositories.ShoesRepository;
public class ValidateData {
	
	private String result;	
	private ShoesRepository  getData = new ShoesRepository ();
	public ValidateData() {
	}
	
	public String getData(Shoe shoe){
		if(isValidData(shoe)) {
			try {
				return getData.getShoesFromDB(shoe);
			}finally {
				
			}
		}
		return result;
	}
	
	private boolean isValidData(Shoe shoe) {
		boolean Error = true;
		result = "";
		String size = shoe.getSize();
		List<String> list = Arrays.asList("31", "32", "33", "34");

		
		//Check for value of size
		if (!list.contains(size)) {
			result = result + ("input parameter value is not allowed. ");
			Error = false;
		}
		
		try {
	        Integer.parseInt(size);
	    }catch (NumberFormatException excepcion) {
	    	result = result + ("input parameter with wrong value. ");
	        Error = false;
	    }
		
		return Error;
		
		
	}
}
