package storepoint.processor;

import storepoint.commerce.order.StorePoints;
import atg.commerce.payment.PaymentManagerPipelineArgs;
import atg.nucleus.GenericService;
import atg.service.pipeline.PipelineProcessor;
import atg.service.pipeline.PipelineResult;

public class ProcCreateStorePointInfo extends GenericService implements
		PipelineProcessor {

	private final int SUCCESS = 1;
	private final int FAILURE = -1;
	protected int mRetCodes[] = { SUCCESS };
	String mIdentifier;

	public ProcCreateStorePointInfo() {
		mIdentifier = "ProcCreateStorePointInfo";
	}

	public int runProcess(Object obj, PipelineResult pipelineresult)
			throws Exception {
		if (obj != null)
			return addDataToStorePointPayment(obj, pipelineresult);
		else
			return FAILURE;
	}

	public int addDataToStorePointPayment(Object obj,
			PipelineResult pipelineresult) {
		if (isLoggingDebug())
			logDebug("Entered::addDataToStorePointPayment(Object, PipelineResult)");

		PaymentManagerPipelineArgs paymentmanagerpipelineargs = (PaymentManagerPipelineArgs) obj;
		StorePoints storePointpaygroup = (StorePoints) paymentmanagerpipelineargs
				.getPaymentGroup();
		double d = paymentmanagerpipelineargs.getAmount();

		// This is prepared for refund.
		if (storePointpaygroup.getAmount() > 0.0
				&& storePointpaygroup.getAmountDebited() > 0.0) {
			if (isLoggingDebug())
				logDebug("not resetting the amount for debit or credit");
			// do nothing
		} else {
			if (isLoggingDebug())
				logDebug("Setting the amount authorized:" + d);
			storePointpaygroup.setAmount(d);
		}

		paymentmanagerpipelineargs.setPaymentInfo(storePointpaygroup);

		if (isLoggingDebug())
			logDebug("End::addDataToBMLPayment(Object, PipelineResult)");
		return SUCCESS;
	}

	public int[] getRetCodes() {
		return mRetCodes;
	}

}
