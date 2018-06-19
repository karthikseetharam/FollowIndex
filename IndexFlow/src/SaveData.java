import java.sql.Connection;
import java.sql.SQLException;
import util.ConnectionManagerImpl;

public class SaveData {		
	
	public void nsedatadumpsave(String Company,String openrate,String previousClose,String low52,String high52,String lastprice , String deliveryToTradedQuantity) {
		
		/*if(deliveryToTradedQuantity.equals("")  ) {
			deliveryToTradedQuantity=null;
		}*/
		 Connection conn=ConnectionManagerImpl.getConnection();
		 String insertsql = "insert into nsedailydump(symbol,openrate,previousclose,lastprice,low52,high52,deliveryToTradedQuantity) values(?,?,?,?,?,?,?)";
		 java.sql.PreparedStatement pstmt = null;
		 
		try {
			pstmt = conn.prepareStatement(insertsql);
			pstmt.setString(1,Company);
			pstmt.setString(2,openrate);
			pstmt.setString(3,previousClose);
			pstmt.setString(4,lastprice);
			pstmt.setString(5,low52);
			pstmt.setString(6,high52);
			pstmt.setString(7,deliveryToTradedQuantity);
			pstmt.execute();
			 
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
		
	}

