package storepoint.commerce;

import atg.payment.PaymentStatus;

public interface StorePointsStatus extends PaymentStatus {

	public abstract String getDecision();

}