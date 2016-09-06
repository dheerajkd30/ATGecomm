package practice;

import java.io.IOException;

import javax.servlet.ServletException;

import atg.core.util.StringUtils;
import atg.droplet.DropletFormException;
import atg.droplet.GenericFormHandler;
import atg.servlet.DynamoHttpServletRequest;
import atg.servlet.DynamoHttpServletResponse;
import atg.ui.commerce.pricing.NumberUtils;

public class ApnaFormHandler extends GenericFormHandler{
	
	public String yourInfo ;
	
	public boolean handleSeeApna(DynamoHttpServletRequest pRequest, DynamoHttpServletResponse pResponse)
		    throws ServletException, IOException{
		
		if(StringUtils.isEmpty(yourInfo)){
			addFormException(new DropletFormException("daal na bhai kuch", ""));
		}
		else if(NumberUtils.isValidNonFloatingPointFormat(yourInfo)){
			addFormException(new DropletFormException("number q daal bhai", ""));
		}
		return true;
		
	}
	
	public String getYourInfo() {
		return yourInfo;
	}

	public void setYourInfo(String yourInfo) {
		this.yourInfo = yourInfo;
	}

}