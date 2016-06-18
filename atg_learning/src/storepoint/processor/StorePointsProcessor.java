package storepoint.processor;

import atg.commerce.CommerceException;
import storepoint.commerce.StorePointsStatus;
import storepoint.commerce.StorePointsInfo;

public abstract interface StorePointsProcessor {
	
	public StorePointsStatus authorize(StorePointsInfo pStorePointsInfo) throws CommerceException;
	
	public StorePointsStatus debit(StorePointsInfo pStorePointsInfo, StorePointsStatus pStatus) throws CommerceException;
	
	public StorePointsStatus credit(StorePointsInfo pStorePointsInfo, StorePointsStatus pStatus) throws CommerceException;
	
	//public StorePointsStatus credit(StorePointsInfo pStorePointsInfo);

}
