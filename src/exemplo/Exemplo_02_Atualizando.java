package exemplo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Exemplo_02_Atualizando {

	   public static void main(String[] args) {
	        Connection connection = null;
	        Statement stmt = null;
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_projeto1", "root", "");
	 
	            stmt = connection.createStatement();
	            stmt.execute("UPDATE funcionarios SET nome='James Bond' WHERE id='7'");
	            System.out.println("Atualizado com sucesso!");
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
