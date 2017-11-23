import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class FetchData {

	
	public void getpricedata( String URL,String Company) throws IOException{


		Document doc=Jsoup.connect(URL).execute().parse();
		
		System.out.println(doc.getElementById("responseDiv").toString());
		String data = doc.getElementById("responseDiv").toString();
		
		if(!data.contains(",\"data\":[],")){// incase if the symbol is not traded anymore
		String openrate = data.substring(data.indexOf("\"open\":")+8, data.indexOf(",\"low52")-1);
		String previousClose=data.substring(data.indexOf("\"previousClose\":")+17, data.indexOf(",\"symbol")-1);		
		String low52 = data.substring(data.indexOf("\"low52\":")+9, data.indexOf(",\"securityVar")-1);
		String high52 = data.substring(data.indexOf("\"high52\":")+10, data.indexOf(",\"purpose")-1);		
		String lastPrice=data.substring(data.indexOf("\"lastPrice\":")+13, data.indexOf(",\"pChange")-1);
		
		System.out.println("Company: "+Company);
		System.out.println("openrate: "+openrate);
		System.out.println("previousClose: " +previousClose);
		System.out.println("low52: "+low52);
		System.out.println("lastPrice: "+ lastPrice);
		System.out.println("high52: "+ high52);}
		
	}
	
}
