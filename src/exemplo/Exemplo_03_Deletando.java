package exemplo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Exemplo_03_Deletando {

	   public static void main(String[] args) {
	        Connection connection = null;
	        Statement stmt = null;
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_projeto1", "root", "");
	 
	            stmt = connection.createStatement();
	            stmt.execute("DELETE FROM funcionarios WHERE id = 2");
	            System.out.println("Deletado com sucesso!");
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                stmt.close();
	                connection.close();
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    }

}
