package eu.gloria.rtc;

import eu.gloria.rt.exception.RTException;
import eu.gloria.rtc.op.ExtExecInfo;
import eu.gloria.rtc.op.ExtExecState;
import eu.gloria.rtc.op.OpInfo;
import eu.gloria.rtc.op.OpManager;

/**
 * 
 * @author jcabello
 *
 */
public class ExecutorControl implements ExecutorControlInterface {

	@Override
	public String start(String uuidOp, String user, long seconds) throws RTException {
		try{
			return OpManager.getOpManager().start(uuidOp, user, seconds);
		}catch(Exception ex){
			ex.printStackTrace();
			throw new RTException("Error starting the OP execution. " + ex.getMessage());
		}
	}

	@Override
	public void stop() throws RTException {
		try{
			OpManager.getOpManager().stop();
		}catch(Exception ex){
			ex.printStackTrace();
			throw new RTException("Error stopping the OP execution. " + ex.getMessage());
		}
	}

	@Override
	public ExtExecInfo getExtExecInfo() throws RTException {
		try{
			return OpManager.getOpManager().getExtExecInfo();
		}catch(Exception ex){
			ex.printStackTrace();
			throw new RTException("Error recovering the External executor information. " + ex.getMessage());
		}
	}

	@Override
	public boolean isRunningOp() throws RTException {
		
		//return true;
		
		try{
			ExtExecInfo info = OpManager.getOpManager().getExtExecInfo();
			return info.getState() == ExtExecState.RUNNING;
		}catch(Exception ex){
			ex.printStackTrace();
			throw new RTException("Error checking if an Observing Plan is running. " + ex.getMessage());
		}
		
	}

	@Override
	public OpInfo getLastOpInfo() throws RTException {
		try{
			return OpManager.getOpManager().getOp();
		}catch(Exception ex){
			ex.printStackTrace();
			throw new RTException("Error recovering the Last OP information. " + ex.getMessage());
		}
	}

}
