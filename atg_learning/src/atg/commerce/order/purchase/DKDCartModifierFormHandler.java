package atg.commerce.order.purchase;

import java.io.IOException;

import javax.servlet.ServletException;

import atg.commerce.order.DKDOrder;
import atg.projects.store.order.purchase.StoreCartFormHandler;
import atg.servlet.DynamoHttpServletRequest;
import atg.servlet.DynamoHttpServletResponse;

public class DKDCartModifierFormHandler extends StoreCartFormHandler{
	
	public String messageToPrint;
	public DKDOrder dkdOrder;
	

	/**
	 * @return the messageToPrint
	 */
	public String getMessageToPrint() {
		return messageToPrint;
	}

	/**
	 * @param messageToPrint the messageToPrint to set
	 */
	public void setMessageToPrint(String messageToPrint) {
		this.messageToPrint = messageToPrint;
	}

	@Override
	public boolean handleCheckout(DynamoHttpServletRequest pRequest,
			DynamoHttpServletResponse pResponse) throws ServletException,
			IOException {
		
		addMessageToOrder(pRequest,pResponse);
		
		return super.handleCheckout(pRequest, pResponse);
	}

	/**
	 * Adds text value to DB 
	 * @param pResponse 
	 * @param pRequest 
	 */
	private void addMessageToOrder(DynamoHttpServletRequest pRequest, DynamoHttpServletResponse pResponse) {
		
		getDkdOrder().setMessageToPrint(getMessageToPrint());
		
	}

	/**
	 * @return the dkdOrder
	 */
	public DKDOrder getDkdOrder() {
		return dkdOrder;
	}

	/**
	 * @param dkdOrder the dkdOrder to set
	 */
	public void setDkdOrder(DKDOrder dkdOrder) {
		this.dkdOrder = dkdOrder;
	}
}
