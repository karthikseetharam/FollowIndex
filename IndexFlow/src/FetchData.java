import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class FetchData {

	
	public void getpricedata( String URL,String Company) throws IOException{
		SaveData s =new SaveData();		

		try {
		Document doc=Jsoup.connect(URL).execute().parse();
		
		System.out.println(doc.getElementById("responseDiv").toString());
		String data = doc.getElementById("responseDiv").toString();
		
		if(!data.contains(",\"data\":[],")){// incase if the symbol is not traded anymore
		String openrate = data.substring(data.indexOf("\"open\":")+8, data.indexOf(",\"low52")-1).replace(",", "");
		String previousClose=data.substring(data.indexOf("\"previousClose\":")+17, data.indexOf(",\"symbol")-1).replace(",", "");		
		String low52 = data.substring(data.indexOf("\"low52\":")+9, data.indexOf(",\"securityVar")-1).replace(",", "");
		String high52 = data.substring(data.indexOf("\"high52\":")+10, data.indexOf(",\"purpose")-1).replace(",", "");		
		String lastPrice=data.substring(data.indexOf("\"lastPrice\":")+13, data.indexOf(",\"pChange")-1).replace(",", "");
		String deliveryToTradedQuantity=data.substring(data.indexOf("\"deliveryToTradedQuantity\":")+28, data.indexOf(",\"basePrice")-1).replace("-", "0");
		//deliveryToTradedQuantity
		
		
		/*quantityTraded
		totalTradedValue
		deliveryQuantity
		pricebandupper
		pChange
		varMargin
		averagePrice
		dayLow
		totalTradedVolume*/
		
		
		
		System.out.println("test");
		System.out.println("deliveryToTradedQuantity: "+ deliveryToTradedQuantity);
		
		s.nsedatadumpsave(Company,openrate,previousClose,low52,high52,lastPrice,deliveryToTradedQuantity);
		}
		
		
		
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
