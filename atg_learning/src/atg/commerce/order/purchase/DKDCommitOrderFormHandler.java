package atg.commerce.order.purchase;

import java.io.IOException;

import javax.servlet.ServletException;

import atg.commerce.order.DKDOrder;
import atg.commerce.order.OrderTools;
import atg.projects.store.order.purchase.StoreCommitOrderHandler;
import atg.repository.MutableRepository;
import atg.repository.MutableRepositoryItem;
import atg.repository.RepositoryException;
import atg.servlet.DynamoHttpServletRequest;
import atg.servlet.DynamoHttpServletResponse;

public class DKDCommitOrderFormHandler extends StoreCommitOrderHandler {

	private OrderTools orderTools;
	public DKDOrder dkdOrder;

	@Override
	public void postCommitOrder(DynamoHttpServletRequest pRequest,
			DynamoHttpServletResponse pResponse) throws ServletException,
			IOException {
		// TODO Auto-generated method stub

		updateMessageToDB(pRequest,pResponse);

		super.postCommitOrder(pRequest, pResponse);
	}

	/**
	 * @param pResponse 
	 * @param pRequest 
	 * 
	 */
	private void updateMessageToDB(DynamoHttpServletRequest pRequest, DynamoHttpServletResponse pResponse) {

		try {
			
				MutableRepository mutableRepository = (MutableRepository) getOrderTools().getOrderRepository();
				MutableRepositoryItem mutableRepositoryItem = mutableRepository.createItem("msgPrint");
				logInfo("DDDDDDDDDDDDD"+ getDkdOrder().getMessageToPrint());
				mutableRepositoryItem.setPropertyValue("msgToPrint", getDkdOrder().getMessageToPrint());
				mutableRepositoryItem.setPropertyValue("orderId", getOrderId());
				mutableRepositoryItem.setPropertyValue("profileId", getOrder().getProfileId());
			
		} catch (RepositoryException e) {
			logError(e);
		}

	}

	/**
	 * @return the orderTools
	 */
	public OrderTools getOrderTools() {
		return orderTools;
	}

	/**
	 * @param orderTools
	 *            the orderTools to set
	 */
	public void setOrderTools(OrderTools orderTools) {
		this.orderTools = orderTools;
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
