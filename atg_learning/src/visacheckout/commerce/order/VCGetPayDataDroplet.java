package visacheckout.commerce.order;

import java.io.IOException;

import javax.servlet.ServletException;

import atg.servlet.DynamoHttpServletRequest;
import atg.servlet.DynamoHttpServletResponse;
import atg.servlet.DynamoServlet;

public class VCGetPayDataDroplet extends DynamoServlet {
	
	private VisaCheckoutManager vcCheckoutManager;

	public void service(DynamoHttpServletRequest req,
			DynamoHttpServletResponse res) throws ServletException, IOException {
		
		if(isLoggingInfo()){
			logInfo("VCGetPayDataDroplet.service :: starts");
		}

		Object pay = req.getParameter("payment"); 
		
		getVcCheckoutManager().getPayloadData(pay); 
		
		if(isLoggingInfo()){
			logInfo("VCGetPayDataDroplet.service :: ends");
		}
	}

	/**
	 * @return the vcCheckoutManager
	 */
	public VisaCheckoutManager getVcCheckoutManager() {
		return vcCheckoutManager;
	}

	/**
	 * @param vcCheckoutManager the vcCheckoutManager to set
	 */
	public void setVcCheckoutManager(VisaCheckoutManager vcCheckoutManager) {
		this.vcCheckoutManager = vcCheckoutManager;
	}
}
