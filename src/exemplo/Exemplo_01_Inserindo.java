package exemplo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Exemplo_01_Inserindo {

	   public static void main(String[] args) {
	        Connection connection = null;
	        Statement stmt = null;
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_projeto1", "root", "");
	 
	            stmt = connection.createStatement();
	            stmt.execute("INSERT INTO funcionarios (id, idade, nome, sobrenome) VALUES (10, 40, 'Jos�', 'Silva')");
	            System.out.println("Inserido com sucesso!");
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
