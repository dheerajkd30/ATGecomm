package storepoint.commerce;

import java.io.Serializable;

import atg.commerce.order.Order;
import atg.core.util.Address;

public interface StorePointsInfo extends Serializable{

	public abstract Order getOrder();

	public abstract String getProfileId();

	public abstract Address getBillingAddress();

	public abstract double getAmount();

}
