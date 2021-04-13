package services;

public class TestForValidations {

	public static void main(String[] args) {
		
		validateData testSucess = new validateData("Vans", "31");
		System.out.println(testSucess.getData());
		
		validateData testMissingParameter = new validateData("Vans", null);
		System.out.println(testMissingParameter.getData());
		
		validateData testNoContent = new validateData("Adidas", "32");
		System.out.println(testNoContent.getData());

	}

}
