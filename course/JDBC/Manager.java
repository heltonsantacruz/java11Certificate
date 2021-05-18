package JDBC;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Manager {
	
	
	public String findWaffles(String connectionStr, String search) throws SQLException {
		   
		   
		   var query = "SELECT * FROM meal WHERE type =" +search;
		   var con = DriverManager.getConnection(connectionStr);
		   try (con;
				var ps = con.prepareStatement(query); 
		        var rs = ps.executeQuery()) {
			   		return rs.getString("name");
		   		} 
		   }
	
	

}
