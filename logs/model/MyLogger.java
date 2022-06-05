package logs.model;

import java.time.LocalDateTime;

public class MyLogger {
    String logMsg;
    int logType;
    LocalDateTime logDateTime;
    String logLevel;


    public MyLogger(String logMsg, int logType, String logLevel) {
        this.logMsg = logMsg;
        this.logType = logType;
        this.logLevel = logLevel;
        this.logDateTime = LocalDateTime.now();
    }

    
}

