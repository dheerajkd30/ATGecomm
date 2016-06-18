package storepoint.commerce.order;

import atg.commerce.order.PaymentGroupImpl;

public class StorePoints extends PaymentGroupImpl{

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StorePoints() {
	  }

	  public String getUserId() {
	    return (String) getPropertyValue("userId");
	  }

	  public void setUserId(String pUserId) {
	    setPropertyValue("userId", pUserId);
	  }

	  public int getNumberOfPoints() {
	    return ((Integer) getPropertyValue("numberOfPoints")).intValue();
	  }

	  public void setNumberOfPoints(int pNumberOfPoints) {
	    setPropertyValue("numberOfPoints", new Integer(pNumberOfPoints));
	  }
	  
}
