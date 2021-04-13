package repositories;
import java.sql.*;
import java.util.ArrayList;
public class getShoes {
	
	private String nameShoe;
	private String size;
	private ArrayList<String> result = new ArrayList<String>();
	
	public getShoes(String nameShoe, String size) {
		this.nameShoe = nameShoe;
		this.size = size;
	}
	
	public ArrayList<String> getShoesFromDB() {
		//Preparo la consulta
		String query = "SELECT shoes.Name,shoesquantity.T"+size
				+ " FROM `shoes` INNER join shoesquantity on SHOES.Quantity = shoesquantity.Id "
				+ "WHERE SHOES.Name = ?";
		
		try {
			//Me conecto a la base de datos
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost/db_shoesinventory",
					"root",
					"");
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, this.nameShoe);
			ResultSet rs = pstmt.executeQuery();
			
			//Guardo los resultados en un ArrayList
			while(rs.next()){
				result.add(rs.getString("Name"));
				result.add(rs.getString("T"+this.size));
			}
			
			rs.close();
			pstmt.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
