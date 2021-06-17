package com.telefonica.gal.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogInfoCustomerOp implements Serializable {
    private String logVersion = "1.0.0";
    private String idLog;
    private String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    private LogTypeCustomer logType;
    private ServiceInfoCustomer serviceInfo;
    private MessageInfoCustomer messageInfo;
    private String request;
    private String transformationRequest;
    private String response;
    private String transformationResponse;

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

    public MessageInfoCustomer getMessageInfo() {
        return messageInfo;
    }

    public void setMessageInfo(MessageInfoCustomer messageInfo) {
        this.messageInfo = messageInfo;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getTransformationRequest() {
        return transformationRequest;
    }

    public void setTransformationRequest(String transformationRequest) {
        this.transformationRequest = transformationRequest;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getTransformationResponse() {
        return transformationResponse;
    }

    public void setTransformationResponse(String transformationResponse) {
        this.transformationResponse = transformationResponse;
    }
}
