package storepoint.processor;

import java.util.Date;

import storepoint.commerce.StorePointStatusImpl;
import storepoint.commerce.StorePointsInfo;
import storepoint.commerce.StorePointsStatus;
import storepoint.commerce.order.StorePoints;
import atg.commerce.CommerceException;
import atg.nucleus.GenericService;

public class StorePointsProcessorImpl extends GenericService implements
		StorePointsProcessor {

	public StorePointsStatus authorize(StorePointsInfo pStorePointsInfo)
			throws CommerceException {

		String decision = null;
		StorePointStatusImpl storePointStatus = null;

		if (pStorePointsInfo == null) {
			logDebug("authorize()::storePointInfo is null");
		}

		StorePoints storePointPayGroup = (StorePoints) pStorePointsInfo;

		if (null != storePointPayGroup && storePointPayGroup.getAmount() > 0d) {
			storePointPayGroup.setAmount(java.lang.Math
					.round(storePointPayGroup.getAmount()));
		}

		//

		try {

			storePointStatus = new StorePointStatusImpl(null,
					java.lang.Math.round(pStorePointsInfo.getAmount()), false,
					"", new Date(), null);
			storePointStatus.setTransactionSuccess(true);
			storePointStatus.setDecision("");

		} catch (Exception e) {
			if (isLoggingError())
				logError(e);
		}

		return storePointStatus;

	}

	public StorePointsStatus debit(StorePointsInfo pStorePointsInfo,
			StorePointsStatus pStatus) throws CommerceException {

		StorePointStatusImpl storePointstatus = null;

		StorePoints storePointPayGroup = (StorePoints) pStorePointsInfo;

		if (null != storePointPayGroup && storePointPayGroup.getAmount() > 0d) {
			storePointPayGroup.setAmount(java.lang.Math
					.round(storePointPayGroup.getAmount()));
		}
		if (null != storePointPayGroup && null != storePointstatus
				&& storePointPayGroup.getAmount() == 0d) {
			storePointstatus = new StorePointStatusImpl(null,
					storePointPayGroup.getAmount(), true,
					"PAYMENT GROUP AMOUNT - ZERO", new Date(), null);
			storePointstatus.setDecision("ACCEPT");

			return storePointstatus;
		}

		return storePointstatus;

	}

	public StorePointsStatus credit(StorePointsInfo pStorePointsInfo,
			StorePointsStatus pStatus) throws CommerceException {

		String decision = null;
		String reasonCode = null;
		StorePointStatusImpl storePointstatus = null;

		storePointstatus = new StorePointStatusImpl(null, 0d, false, "",
				new Date(), null);

		StorePoints storePointPayGroup = (StorePoints) pStorePointsInfo;

		if (storePointPayGroup != null && storePointPayGroup.getAmount() > 0d) {
			storePointPayGroup.setAmount(java.lang.Math
					.round(storePointPayGroup.getAmount()));
		}

		decision = "ACCEPT";
		if ("ACCEPT".equalsIgnoreCase(decision)) {

			storePointstatus.setTransactionSuccess(true);
		} else {

			String errorMsg = "Error";

			storePointstatus.setTransactionSuccess(false);
			storePointstatus.setErrorMessage(errorMsg);
		}

		storePointstatus.setDecision(decision);
		storePointstatus.setTransactionTimestamp(new Date(System
				.currentTimeMillis()));

		return storePointstatus;
	}

}
