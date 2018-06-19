/**
 * 
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * @author Hari.Prakash
 *
 */
public class ConnectionManagerImpl {
	
	//static reference to itself
    private static ConnectionManagerImpl instance = new ConnectionManagerImpl();
    public static final String URL = "jdbc:mysql://localhost:3306/stockstalker?useSSL=false";
    public static final String USER = "root";
    public static final String PASSWORD = "admin";
    public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";

	/**
	 * 
	 */
	public ConnectionManagerImpl() {
		// TODO Auto-generated constructor stub
	}
	
	 private Connection createConnection() {
	        Connection connection = null;
	        try {
	            connection = DriverManager.getConnection(URL, USER, PASSWORD);
	        } catch (SQLException e) {
	            System.out.println("ERROR: Unable to Connect to Database.");
	        }
	        return connection;
	    }   
	     
	    public static Connection getConnection() {
	        return instance.createConnection();
	    }
	    

}
