package com.telefonica.gal.dto;

import java.io.Serializable;
import java.util.Map;

public class MessageInfo implements Serializable {
    private String messageOriginalFormat;
    private String url;
    private Map<String, String> indexKey;

    public String getMessageOriginalFormat() {
        return messageOriginalFormat;
    }

    public void setMessageOriginalFormat(String messageOriginalFormat) {
        this.messageOriginalFormat = messageOriginalFormat;
    }

    public Map<String, String> getIndexKey() {
        return indexKey;
    }

    public void setIndexKey(Map<String, String> indexKey) {
        this.indexKey = indexKey;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
