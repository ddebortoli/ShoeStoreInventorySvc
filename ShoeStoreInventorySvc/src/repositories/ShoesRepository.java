package repositories;
import java.sql.*;
import java.util.ArrayList;

import models.Shoe;
public class ShoesRepository implements AutoCloseable {
	
	private ArrayList<String> result = new ArrayList<String>();
	private Connection cn;
	
	public ShoesRepository () {
		try {
			this.cn = DriverManager.getConnection(
					"jdbc:mysql://localhost/db_shoesinventory",
					"root",
					"");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> getShoesFromDB(Shoe shoe) {
		//Preparo la consulta
		String query = "SELECT shoes.Name,shoesquantity.T"+shoe.getSize()
				+ " FROM `shoes` INNER join shoesquantity on SHOES.Quantity = shoesquantity.Id "
				+ "WHERE SHOES.Name = ?";
		
		try {
			//Me conecto a la base de datos
			PreparedStatement pstmt = cn.prepareStatement(query);
			pstmt.setString(1, shoe.getName());
			ResultSet rs = pstmt.executeQuery();
			
			//Guardo los resultados en un ArrayList
			while(rs.next()){
				result.add(rs.getString("Name"));
				result.add(rs.getString("T"+shoe.getSize()));
			}
			
			rs.close();
			pstmt.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		cn.close();
	}
}
