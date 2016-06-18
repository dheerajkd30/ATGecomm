package util;

import atg.nucleus.GenericService;

public class GenericServices extends GenericService{
	
	@Override
	public void logDebug(String pMessage) {
		if(isLoggingDebug())
		super.logDebug(pMessage);
	}
	
	@Override
	public void logInfo(String pMessage) {
		if(isLoggingInfo())
		super.logInfo(pMessage);
	}
	
	@Override
	public void logError(String pMessage) {
		if(isLoggingError())
		super.logError(pMessage);
	}

	@Override
	public void logWarning(String pMessage) {
		if(isLoggingWarning())
		super.logWarning(pMessage);
	}
}
