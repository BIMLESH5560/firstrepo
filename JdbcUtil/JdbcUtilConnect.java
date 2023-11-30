package in.JdbcUtil;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;



public class JdbcUtilConnect {
	public static Connection getjdbcconnection() throws IOException, SQLException
	{
		
		// Task To Get The properties from the application File And Loading The Driver with connection
		FileInputStream FIS=new FileInputStream("Application.properties");
		Properties P=new Properties();
		P.load(FIS);
		String url=P.getProperty("url");
		String user=P.getProperty("user");
		String password=P.getProperty("password");
		System.out.println(url);
	    System.out.println(user);
	    System.out.println(password);
	    
	 Connection cnn=DriverManager.getConnection(url, user, password);
	 return cnn;
	}
	
	public static void closingResource(Connection cnn, PreparedStatement preparedstatement) throws SQLException {
		if(cnn!=null) {
			cnn.close();
		} 
		if(preparedstatement!=null) {
			preparedstatement.close();
		} 
		
	}

}
