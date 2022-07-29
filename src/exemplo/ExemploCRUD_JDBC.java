
package exemplo;

//Passo 1. Import required packages
import java.sql.*;

public class ExemploCRUD_JDBC {
	//JDBC nome do drive e URL do banco de dados
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/db_projeto1";
	// Usu�rio e senha do banco de dados
	static final String USUARIO = "root";
	static final String SENHA = ""; // Quando instala o banco ele pede para criar a senha, no xampp vem sem senha

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			//Passo 2: Registrar o drive JDBC
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Passo 3: Abrir a conex�o com o banco de dados
			System.out.println("Conectando o banco de dados...");
			conn = DriverManager.getConnection(DB_URL, USUARIO, SENHA);
			
			//Passo 4: Criando caminho para executar comandos SQL
			System.out.println("Criando statement...");
			stmt = conn.createStatement();
			
			//Passo 5: Inserir dados
			System.out.println("Criando statement...");
			stmt = conn.createStatement();
			String sql = "INSERT INTO funcionarios (id, idade, nome, sobrenome) VALUES (7, 50, 'Jammes', 'Bond')";
			stmt.execute(sql);
			
			//Passo 6: Atualizar dados
			sql = "UPDATE funcionarios SET nome='James' WHERE id='7'";
			stmt.execute(sql);
			
			//Passo 7: Deletar dados
			sql = "DELETE FROM funcionarios WHERE id = 1";
			stmt.execute(sql);
			
			//Passo 8: Consultar e Extrair dados do ResultSet
			sql = "SELECT * FROM funcionarios";
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
			
			//Passo 9: Fechando conex�o com o banco de dados
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			//Tratando erros tipo "SQLException"
			e.printStackTrace();
		} catch (Exception e) {
			//Tratando erros tipo "Class.forName"
			e.printStackTrace();
		} finally {
			//bloco finally usado para fechar as conex�es
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Fim do sistema");
	}
}