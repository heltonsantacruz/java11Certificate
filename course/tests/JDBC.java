package tests;

import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC {
	
	
	public static void main(String[] args){
		var url = "jdbc:derby:birds";
		var sql = "SELECT name FROM peacocks WHERE name = ?";
		try (var conn = DriverManager.getConnection(url); var stmt = conn.prepareStatement(sql)) {        // s1
		   stmt.setString(1, "Feathers");
		   try (var rs = stmt.executeQuery()) {           // s2
		      while (rs.hasNext()) {
		         System.out.println(rs.next());
		      }
		   }
		}
		
		
	}

}
