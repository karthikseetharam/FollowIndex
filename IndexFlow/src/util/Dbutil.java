package util;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;


 /**
 * @author Hari.Prakash
 *
 */
public class Dbutil {
	
	
	 private Connection connection;
	

	/**
	 * @return
	 */
	public   Connection getConn() {

		  connection = ConnectionManagerImpl.getConnection();
		  return  connection;
	}

	/**
	 * @param conn
	 * @throws SQLException
	 */
	public static void releaseResources(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		if(conn!=null)
			conn.close();
	}
	
	
	
}
