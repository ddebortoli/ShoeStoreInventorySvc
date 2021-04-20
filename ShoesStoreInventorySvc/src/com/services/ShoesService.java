package services;
import java.util.ArrayList;

import enums.Sizes;
import models.Shoe;
import repositories.ShoesRepository;
public class ShoesService {
	
	private ShoesRepository  shoesRepository = new ShoesRepository ();
	
	public ArrayList<Shoe> getBySize(int sizeValue){
		
		Sizes size = Sizes.fromSizeNumber(sizeValue);
		if (size == null) {
			throw new IllegalArgumentException("invalid size value:" + sizeValue);
		}
		try {
			return shoesRepository.getBySize(size);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<Shoe>();

	}
	public String getByName() {
		return null;
		
	}
}
