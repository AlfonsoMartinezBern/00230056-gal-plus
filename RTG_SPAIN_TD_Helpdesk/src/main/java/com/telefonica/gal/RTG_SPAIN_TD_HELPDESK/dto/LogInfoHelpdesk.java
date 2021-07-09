package com.telefonica.gal.RTG_SPAIN_TD_HELPDESK.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogInfoHelpdesk<T,F,E> implements Serializable  {
    private String logVersion = "1.0.0";
    private String idLog;
    private String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    private LogTypeHelpdesk logType;
    private ServiceInfoHelpdesk serviceInfo;
    private MessageInfoHelpdesk messageInfo;
    private T request;
    private F response;
    private E transformationResponse;

    public LogInfoHelpdesk(T request, F response, E transformationResponse) {
        this.request = request;
        this.response = response;
        this.transformationResponse = transformationResponse;
    }

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

    public MessageInfoHelpdesk getMessageInfo() {
        return messageInfo;
    }

    public void setMessageInfo(MessageInfoHelpdesk messageInfo) {
        this.messageInfo = messageInfo;
    }

    public T getRequest() {
        return request;
    }

    public void setRequest(T request) {
        this.request = request;
    }

    public F getResponse() {
        return response;
    }

    public void setResponse(F response) {
        this.response = response;
    }

    public E getTransformationResponse() {
        return transformationResponse;
    }

    public void setTransformationResponse(E transformationResponse) {
        this.transformationResponse = transformationResponse;
    }
}
