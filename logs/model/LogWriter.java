package logs.model;

import java.util.ArrayList;

public class LogWriter {
    ArrayList<MyLogger> AL_LOG = new ArrayList<MyLogger>();

    public void log(String logMsg, int logType, String logLevel){
        MyLogger ml = new MyLogger(logMsg,logType,logLevel);
        AL_LOG.add(ml);
    }

    public void dumpLog()
    {
        for (MyLogger myLogger : AL_LOG) {
            System.out.println(myLogger.logLevel+" ("+myLogger.logType+")::"+"At "+myLogger.logDateTime+" "+myLogger.logMsg);
        }
    }
    
    public void dumpLastLog(int count) {
    	int logCount = AL_LOG.size(); 
    	if(count==1) {
    		System.out.println(AL_LOG.get(logCount).logLevel+" ("+AL_LOG.get(logCount).logType+")::"+"At "+AL_LOG.get(logCount).logDateTime+" "+AL_LOG.get(logCount).logMsg);
    		
    	}
    	else {
    		for(int k=0;k<count;k++)
    			System.out.println(AL_LOG.get(logCount-k).logLevel+" ("+AL_LOG.get(logCount-k).logType+")::"+"At "+AL_LOG.get(logCount-k).logDateTime+" "+AL_LOG.get(logCount-k).logMsg);
            }
    	}
}
