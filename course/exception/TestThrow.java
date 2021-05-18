package exception;

import java.sql.DriverManager;
import java.sql.SQLException;

public class TestThrow {
	
	public String findNewLego(String url, int type) 
		      throws SQLException {
		
		   var query = "SELECT name FROM sets WHERE "
		      + "type = " + type + " ORDER BY date DESC";
		   var con = DriverManager.getConnection(url);
		   var ps = con.createStatement();
		   
		   try(con; ps; var rs = ps.executeQuery(query)) {
		      if(rs.next()) 
		    	  return rs.getString(1);
		   }
		   throw new RuntimeException("None available, try  later");
		}
	
	
	public String getExcecao() throws Exception{
		//if(true) return "50";
		throw new RuntimeException("None available, try  later");
	}

}
