package testing;

import models.Shoe;
import services.ValidateData;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shoe vans = new Shoe("Vans","34");
		Shoe adidas = new Shoe("Adidas Style 3","32");
		Shoe zapatillaError = new Shoe("New Ballance","AAA");
		
		ValidateData validar = new ValidateData();
		
		System.out.println(validar.getData(vans));
		System.out.println(validar.getData(adidas));
		System.out.println(validar.getData(zapatillaError));
		

	}

}
