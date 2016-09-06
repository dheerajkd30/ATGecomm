package atg.commerce.order;

public class DKDOrder extends OrderImpl{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String messageToPrint;

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

}
