package com.telefonica.gal.provisionApi.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServiceFlags {

    @JsonProperty("transactionalPurchases")
    private Integer transactionalPurchases;

    @JsonProperty("downloadToGo")
    private Integer downloadToGo;

    public Integer getTransactionalPurchases() {
        return transactionalPurchases;
    }

    public void setTransactionalPurchases(Integer transactionalPurchases) {
        this.transactionalPurchases = transactionalPurchases;
    }

    public Integer getDownloadToGo() {
        return downloadToGo;
    }

    public void setDownloadToGo(Integer downloadToGo) {
        this.downloadToGo = downloadToGo;
    }
}
