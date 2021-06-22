package com.telefonica.gal.provisionApi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CDBProvisionRequest {

    @JsonProperty("clientSegmentName")
    private String clientSegmentName;

    @JsonProperty("devices")
    private ProvisionOttUserBASEDevicesDevices devices;

    @JsonProperty("serviceFlags")
    private ProvisionOttUserBASEFlagsServiceFlags serviceFlags;

    @JsonProperty("subscribedProducts")
    private List<SubscribedProductWRITE> subscribedProducts;

    public String getClientSegmentName() {
        return clientSegmentName;
    }

    public void setClientSegmentName(String clientSegmentName) {
        this.clientSegmentName = clientSegmentName;
    }

    public ProvisionOttUserBASEFlagsServiceFlags getServiceFlags() {
        return serviceFlags;
    }

    public void setServiceFlags(ProvisionOttUserBASEFlagsServiceFlags serviceFlags) {
        this.serviceFlags = serviceFlags;
    }

    public List<SubscribedProductWRITE> getSubscribedProducts() {
        return subscribedProducts;
    }

    public void setSubscribedProducts(List<SubscribedProductWRITE> subscribedProducts) {
        this.subscribedProducts = subscribedProducts;
    }

    public ProvisionOttUserBASEDevicesDevices getDevices() {
        return devices;
    }

    public void setDevices(ProvisionOttUserBASEDevicesDevices devices) {
        this.devices = devices;
    }
}
