package com.telefonica.gal.SRV_SPAIN_TD_Helpdesk.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogHelpdesk implements Serializable {
    private String logVersion = "1.0.0";
    private String idLog;
    private String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    private LogTypeHelpdesk logType;
    private ServiceInfoHelpdesk serviceInfo;
    private String message;

    public String getLogVersion() {
        return logVersion;
    }

    public void setLogVersion(String logVersion) {
        this.logVersion = logVersion;
    }

    public String getIdLog() {
        return idLog;
    }

    public void setIdLog(String idLog) {
        this.idLog = idLog;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public LogTypeHelpdesk getLogType() {
        return logType;
    }

    public void setLogType(LogTypeHelpdesk logType) {
        this.logType = logType;
    }

    public ServiceInfoHelpdesk getServiceInfo() {
        return serviceInfo;
    }

    public void setServiceInfo(ServiceInfoHelpdesk serviceInfo) {
        this.serviceInfo = serviceInfo;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
