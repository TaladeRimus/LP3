package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectJDBC {
	
	
	public Connection connection() throws SQLException{
		
		Connection connect = null;
		try {
			
			Class.forName("org.postgresql.Driver");
			
			String url = "jdbc:postgresql://localhost:5432/CRUDjdbc";
			String user = "postgres";
			String password = "senacrs";
			
			
			
			connect = DriverManager.getConnection(url, user, password);
			
			if ( connect != null) {
				
				System.out.println("Database connected");
				
			}
			
			
		} catch (ClassNotFoundException e) {

			System.err.println("Driver not found");
		
		}
		
		return connect;
		
		
		
	}
	
	public static void main(String[] args) throws SQLException {
		//connection();
	}

}
