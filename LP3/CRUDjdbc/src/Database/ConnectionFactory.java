package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {



	public final static String BANCO = "CRUDjdbc";
	public final static String USER="postgres";
	public final static String SENHA="123";

	public static Connection getConexaoPostgres() throws ClassNotFoundException, SQLException {
		
		Class.forName("org.postgresql.Driver");
		String url = "jdbc:postgresql://localhost:5432/"+BANCO;

		Connection conexao = DriverManager.getConnection(url, USER, SENHA);
		return(conexao);
	
	}

}
