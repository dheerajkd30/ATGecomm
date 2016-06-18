package storepoint.processor;

import atg.nucleus.GenericService;
import atg.service.pipeline.PipelineProcessor;
import atg.service.pipeline.PipelineResult;

public class ProcValidateStorePointGroup extends GenericService 
implements PipelineProcessor{

	private static int SUCCESS_CODE =1;
	   private static int[] RETURN_CODES={SUCCESS_CODE};


	   public int[] getRetCodes()
	   {
	      return RETURN_CODES;
	   }

	   public int runProcess(Object obj, PipelineResult pipelineresult)
	        throws Exception
	   {
	      return SUCCESS_CODE;
	    }
	
}
