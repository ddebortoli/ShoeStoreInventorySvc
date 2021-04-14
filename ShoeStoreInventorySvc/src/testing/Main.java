package testing;

import models.Shoe;
import services.validateData;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shoe Vans = new Shoe("Vans","34");
		validateData validar = new validateData(Vans);
		System.out.println(validar.getData());
	}

}
