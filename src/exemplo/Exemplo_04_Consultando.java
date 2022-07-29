package exemplo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Exemplo_04_Consultando {

	   public static void main(String[] args) {
	        Connection connection = null;
	        Statement stmt = null;
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_projeto1", "root", "");
	 
	            stmt = connection.createStatement();
	            String sql = "SELECT * FROM funcionarios";
				ResultSet rs = stmt.executeQuery(sql);
				
				while (rs.next()) {
					//Recuperar dados pelo nome da coluna
					int id = rs.getInt("id");
					int age = rs.getInt("idade");
					String first = rs.getString("nome");
					String last = rs.getString("sobrenome");
					//Display values
					System.out.print("ID: " + id);
					System.out.print(", Idade: " + age);
					System.out.print(", Nome: " + first);
					System.out.println(", Sobrenome: " + last);
				}
				System.out.println("Fim da consulta!");
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
