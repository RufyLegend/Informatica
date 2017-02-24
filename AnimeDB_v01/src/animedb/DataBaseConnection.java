package animedb;

import java.sql.*;
/**
 *
 * @author Nicholas Ottaviani
 * @date 24 feb 2017 17:05:42
 */
public class DataBaseConnection {
	
	/**
     * Inserisce un record all'interno database 
     * @param username
     * @param password
     * @param query 
     */
    public void insertMethod(String username, String password, String query, String database){
        try (
         Connection conn = DriverManager.getConnection(
               "jdbc:mysql://localhost:3306/" + database + "?useSSL=false" , username ,password );
       
         Statement stmt = conn.createStatement();
      ) {
         System.out.println("La query è: " + query); 
         System.out.println();
 
         int countInserted = stmt.executeUpdate(query);
         
         System.out.println("Insert eseguito correttamente!");
 
      } catch(SQLException ex) {
         ex.printStackTrace();
      }
      
    }

}
