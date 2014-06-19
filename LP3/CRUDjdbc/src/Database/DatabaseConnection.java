package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DatabaseConnection {
		
    private Connection connect = null;
    protected PreparedStatement cmd = null;
    
    public void startConnection(String sql) throws ClassNotFoundException, SQLException {
        
    	connect = ConnectionFactory.getConexaoPostgres();    
   
    		
    		System.out.print("Database connected");
    		cmd = connect.prepareStatement(sql);
    		
    	
    	
    }
    
   public void closeConnection() throws SQLException{
	   
	   cmd.close();
	   connect.close();
	   
   }

}
