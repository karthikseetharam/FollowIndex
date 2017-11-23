import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadSymbols {

	public void prepareURL(){
		 String csvFile = "AllSymbols.csv";
	        BufferedReader br = null;
	        String line = "";
	        String cvsSplitBy = ",";
	        String URL= "https://www.nseindia.com/live_market/dynaContent/live_watch/get_quote/GetQuote.jsp?symbol=";
	        FetchData fd= new FetchData();
		 try {

	            br = new BufferedReader(new FileReader(csvFile));
	            while ((line = br.readLine()) != null) {

	                // use comma as separator
	                String[] symbol = line.split(cvsSplitBy);

	               // System.out.println(symbol[0] );
	                int i=1;
	                for (String CompanySymbol : symbol) {
	                
						fd.getpricedata(URL+CompanySymbol, CompanySymbol);
					}

	            }
	
		 } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            if (br != null) {
	                try {
	                    br.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	}
}
