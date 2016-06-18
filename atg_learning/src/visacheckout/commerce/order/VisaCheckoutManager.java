
package visacheckout.commerce.order;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import visacheckout.VisaCheckoutEncryptDecrypt;
import visacheckout.util.CFIUtil;
import atg.json.JSONException;
import atg.nucleus.GenericService;

/**
 * @author dheeraj
 * 
 * 
 */
public class VisaCheckoutManager extends GenericService {

	public Object getPayloadData(Object payment) {
		
		if(isLoggingDebug()){
			logDebug("VisaCheckoutManager.getPayloadData :: starts");
		}

		byte[] key = null;
		byte[] data = null; 
		Object payload = null;
		String jsonString = null; 
		Map<String, String> payData = null;

		try {
			if (null != payment) {
				jsonString = payment.toString();
				payData = CFIUtil.jsonToMap(jsonString);
			}
			if(null != payData){
			key = payData.get("encKey").getBytes(StandardCharsets.UTF_8);
			data = payData.get("encPaymentData").getBytes(StandardCharsets.UTF_8);
			}
			//get payLoad data
			payload = VisaCheckoutEncryptDecrypt.decrypt(key, data);

		} catch (JSONException je) {
			if (isLoggingError())
				logError("json exception >>" + je);
		}
		System.out.println(payload);
		
		if(isLoggingDebug()){
			logDebug("VisaCheckoutManager.getPayloadData :: data "+ payload.toString());
		}
		
		if(isLoggingDebug()){
			logDebug("VisaCheckoutManager.getPayloadData :: ends");
		}
		return payload;

	}
	
	/**
	 * 
	 */
	public void doIt(){
		
		VisaCheckoutManager checkoutManager = new VisaCheckoutManager();
		try {
			String payd = checkoutManager.readFile("C:/Common/pdata.txt");
			
			checkoutManager.getPayloadData(payd);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	String readFile(String fileName) throws IOException {
	    BufferedReader br = new BufferedReader(new FileReader(fileName));
	    try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();

	        while (line != null) {
	            sb.append(line);
	            line = br.readLine();
	        }
	        return sb.toString();
	    } finally {
	        br.close();
	    }
	}

public static void main(String[] args) {
	VisaCheckoutManager checkoutManager = new VisaCheckoutManager();
	checkoutManager.doIt();
	
	}
}
