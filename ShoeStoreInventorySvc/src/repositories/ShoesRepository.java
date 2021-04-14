package repositories;
import java.sql.*;

import models.Shoe;
public class ShoesRepository implements AutoCloseable {
	
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
	
	public String getShoesFromDB(Shoe shoe) {

		//Preparo la consulta		
		try {
			//Me conecto a la base de datos
			PreparedStatement pstmt = cn.prepareStatement("SELECT shoes.Name,shoesquantity.T"+shoe.getSize()
			+ " FROM `shoes` INNER join shoesquantity on SHOES.Quantity = shoesquantity.Id "
			+ "WHERE SHOES.Name = '" + shoe.getName() + "'");
			ResultSet rs = pstmt.executeQuery();
			
			//Guardo los resultados en un ArrayList
			while(rs.next()){
				return (rs.getString("T"+shoe.getSize()));
			}
			
			rs.close();
			pstmt.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		cn.close();
	}
}
