package com.telefonica.gal.SPAIN_TD_CDBProvision.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogCustomer implements Serializable {
    private String logVersion = "1.0.0";
    private String idLog;
    private String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    private LogTypeCustomer logType;
    private ServiceInfoCustomer serviceInfo;
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

    public LogTypeCustomer getLogType() {
        return logType;
    }

    public void setLogType(LogTypeCustomer logType) {
        this.logType = logType;
    }

    public ServiceInfoCustomer getServiceInfo() {
        return serviceInfo;
    }

    public void setServiceInfo(ServiceInfoCustomer serviceInfo) {
        this.serviceInfo = serviceInfo;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
