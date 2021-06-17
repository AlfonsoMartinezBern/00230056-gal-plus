package com.telefonica.gal.provisionApi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CDBProvisionRequest {

    @JsonProperty("clientSegmentName")
    private String clientSegmentName;

    @JsonProperty("devices")
    private ProvisionOttUserBASEDevices devices;

    @JsonProperty("serviceFlags")
    private ProvisionOttUserBASEFlagsServiceFlags serviceFlags;

    @JsonProperty("subscribedProducts")
    private ProvisionOttUserBASESubscribedProducts subscribedProducts;

    public String getClientSegmentName() {
        return clientSegmentName;
    }

    public void setClientSegmentName(String clientSegmentName) {
        this.clientSegmentName = clientSegmentName;
    }

    public ProvisionOttUserBASEDevices getDevices() {
        return devices;
    }

    public void setDevices(ProvisionOttUserBASEDevices devices) {
        this.devices = devices;
    }

    public ProvisionOttUserBASEFlagsServiceFlags getServiceFlags() {
        return serviceFlags;
    }

    public void setServiceFlags(ProvisionOttUserBASEFlagsServiceFlags serviceFlags) {
        this.serviceFlags = serviceFlags;
    }

    public ProvisionOttUserBASESubscribedProducts getSubscribedProducts() {
        return subscribedProducts;
    }

    public void setSubscribedProducts(ProvisionOttUserBASESubscribedProducts subscribedProducts) {
        this.subscribedProducts = subscribedProducts;
    }

}
