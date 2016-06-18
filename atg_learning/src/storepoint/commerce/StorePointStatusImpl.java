package storepoint.commerce;

import java.util.Date;

import atg.payment.PaymentStatusImpl;

public class StorePointStatusImpl extends PaymentStatusImpl implements StorePointsStatus{

	private String mDecision;	

	public StorePointStatusImpl() {
		mDecision = null;
	}

	public StorePointStatusImpl(String s, double d, boolean flag, String s1,
			Date date, Date date1) {
		super(s, d, flag, s1, date);
		mDecision = null;
	}

	
	public String getDecision() {
		return mDecision;
	}

	public void setDecision(String s) {
		mDecision = s;
	}

}
