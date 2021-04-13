package repositories;

public class Main {

	public static void main(String[] args) {
		getShoes prueba = new getShoes("Vans","31");
		System.out.println(prueba.getShoesFromDB());

	}

}
