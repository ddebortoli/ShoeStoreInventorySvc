package repositories;

import enums.Sizes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.json.simple.JSONArray;

import models.Shoe;

/**
 * @author: Damian A. Debortoli. 

 * @version: 22/09/2016/A
 * @see "https://www.linkedin.com/in/damian-debortoli-23844a179"
 */

public class ShoesRepository implements AutoCloseable {
	
  private Connection cn;
/**
   * Constructor para la conexion a la base de datos   */
  
  public ShoesRepository(){
    try{
    	
    	this.cn = DriverManager.getConnection(
					"jdbc:mysql://localhost/db_shoesinventory",
					"root",
					"");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Shoe> getBySize(Sizes shoeSize) throws Exception {
		//Preparo la consulta		
			//Me conecto a la base de datos
			PreparedStatement pstmt = cn.prepareStatement("SELECT *"
			+ " FROM shoes INNER join stock on shoes.Id = stock.ShoeId "
			+ "WHERE stock.Size = '" + shoeSize + "'");
			ResultSet rs = pstmt.executeQuery();
		    
		    //ArrayList<Shoe> shoes = new ArrayList<Shoe>();
		    JSONArray shoes = new JSONArray();
			//Guardo los resultados en un ArrayList
		    while(rs.next()) {
		    		shoes.add(new Shoe(rs.getString("Name"),
		    				Sizes.fromSizeNumber(rs.getInt("Size")),
		    				rs.getInt("Stock")));
		    	
		    	return shoes;
		    }
		    return null;
	}

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		cn.close();
	}
}
