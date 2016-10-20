package classes;

import java.sql.Connection;
import java.sql.DriverManager;

public class SqlConnection {
	
	public Connection getJDBCConnection() throws Exception
	{
		Connection connection = null;
		
		Class.forName("com.mysql.jdbc.Driver");  
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/partyshop","root","1234");  
		
		return connection;
	}

}
