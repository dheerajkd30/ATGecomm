package atg.commerce.promotion;

import java.io.IOException;

import javax.servlet.ServletException;

import atg.projects.store.order.purchase.StoreCouponFormHandler;
import atg.servlet.DynamoHttpServletRequest;
import atg.servlet.DynamoHttpServletResponse;

public class MyCouponFormHandler extends StoreCouponFormHandler{
	
	
	@Override
	public boolean handleClaimCoupon(DynamoHttpServletRequest pRequest,
			DynamoHttpServletResponse pResponse) throws ServletException,
			IOException {
		// TODO Auto-generated method stub
		return super.handleClaimCoupon(pRequest, pResponse);
	}

}
