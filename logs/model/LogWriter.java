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
}
