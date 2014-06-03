package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ConnectJDBC {
	
	/**
	 * @author Adriano Casarim Duarte
	 * @throws SQLException 
	 *
	 */
	
	static Statement stmt;
	static Connection connect;
	static Scanner sc = new Scanner(System.in);
	
	private static void connectJDBC() throws SQLException {
		
		String url = "jdbc:postgresql://localhost:5432/CRUD";
		String user = "postgres";
		String password = "senacrs";
		
		try {
			
			Class.forName("org.postgresql.Driver");
			
				connect = DriverManager.getConnection(url, user, password);
				
				if ( connect != null ) {
				
					System.out.print("Database connected");
				
				}
				
				
				
		} catch (ClassNotFoundException e) {
			System.err.println("Driver.class not found");			
			
		}
		
		
	}
	
	
	public static void insert(){
		
		String cmd, name, mail;
		int id = 1;
		try {
			
			stmt = connect.createStatement();
			
			System.out.print("Nome: ");
			name = sc.next();
			
			System.out.print("Email: ");
			mail = sc.next();
			
			cmd = "INSERT INTO pessoa VALUES (" + id + "," + "'" + name + "'" + "'" + mail + "'" + ")";
			
			int affectedLines = stmt.executeUpdate(cmd);
			System.out.println("Linhas Afetadas: " + affectedLines);
			
		} catch (SQLException e) {
			System.err.println("Connection not found");
		}
		/*String sql = "INSERT INTO pessoa values(1, 'Adriano', 'mail@mail.me')";
		
		int affectedLines = stmt.executeUpdate(sql);*/

		//System.out.println("Linhas afetadas:" + affectedLines );
	}
	
	public static void main(String[] args) throws SQLException {
		connectJDBC();
		insert();
	}
	
	
	

}
