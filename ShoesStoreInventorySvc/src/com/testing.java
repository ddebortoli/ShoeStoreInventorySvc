import services.ShoesService;

public class testing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShoesService validar = new ShoesService();
		
		System.out.println(validar.getBySize(34));
	}

}
