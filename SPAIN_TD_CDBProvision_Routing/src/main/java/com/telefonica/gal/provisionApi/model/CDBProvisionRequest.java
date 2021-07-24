package com.telefonica.gal.provisionApi.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CDBProvisionRequest {

    @JsonProperty("clientSegmentName")
    private String clientSegmentName;

    @JsonProperty("devices")
    private ProvisionOttUserBASEDevicesDevices devices;

    @JsonProperty("serviceFlags")
    private ServiceFlags serviceFlags;

    @JsonProperty("subscribedProducts")
    private List<SubscribedProduct> subscribedProducts;

    public String getClientSegmentName() {
        return clientSegmentName;
    }

    public void setClientSegmentName(String clientSegmentName) {
        this.clientSegmentName = clientSegmentName;
    }

    public ServiceFlags getServiceFlags() {
        return serviceFlags;
    }

    public void setServiceFlags(ServiceFlags serviceFlags) {
        this.serviceFlags = serviceFlags;
    }

    /*public ProvisionOttUserBASEFlagsServiceFlags getServiceFlags() {
        return serviceFlags;
    }

    public void setServiceFlags(ProvisionOttUserBASEFlagsServiceFlags serviceFlags) {
        this.serviceFlags = serviceFlags;
    }*/

    public ProvisionOttUserBASEDevicesDevices getDevices() {
        return devices;
    }

    public void setDevices(ProvisionOttUserBASEDevicesDevices devices) {
        this.devices = devices;
    }

    public List<SubscribedProduct> getSubscribedProducts() {
        return subscribedProducts;
    }

    public void setSubscribedProducts(List<SubscribedProduct> subscribedProducts) {
        this.subscribedProducts = subscribedProducts;
    }

    public CDBProvisionRequest() {}

    /*public CDBProvisionRequest(String request) throws ErrorMessage {
        SubscribedProduct subscribedProduct = new SubscribedProduct();
        String row_aux;
        int index, sw = 0;
        if (!request.contains("clientSegmentName")) {
            throw new CustomerException().getErrorInfo(40001, ErrorCodeEnum.OBLIGATORY_FIELD_CLIENT_SEGMENT_NAME.getValue(), "Bad request.");
        } else {
            row_aux = request.substring(request.indexOf("clientSegmentName") + 19);
            row_aux = row_aux.substring(row_aux.indexOf("\"") + 1);
            this.clientSegmentName = row_aux.substring(0, row_aux.indexOf("\""));
        }

        if (!request.contains("devices")) {
            this.devices = null;
        } else if (!request.contains("maxNumDevices")) {
            this.devices = new ProvisionOttUserBASEDevicesDevices();
            this.devices.setMaxNumDevices(null);
        } else {
            this.devices = new ProvisionOttUserBASEDevicesDevices();
            row_aux = request.substring(request.indexOf("maxNumDevices") + 13);
            row_aux = row_aux.substring(row_aux.indexOf(":") + 1);
            this.devices.setMaxNumDevices(Integer.valueOf(row_aux.substring(0, row_aux.indexOf("\r")).replaceAll(" ", "")));
        }

        if (!request.contains("serviceFlags")) {
            this.serviceFlags = null;
        } else {
            if (!request.contains("transactionalPurchases")) {
                this.serviceFlags = new ProvisionOttUserBASEFlagsServiceFlags();
                this.serviceFlags.setTransactionalPurchases(null);
            } else {
                this.serviceFlags = new ProvisionOttUserBASEFlagsServiceFlags();
                row_aux = request.substring(request.indexOf("transactionalPurchases") + 23);
                row_aux = row_aux.substring(row_aux.indexOf(":") + 1);
                row_aux = row_aux.substring(0, row_aux.indexOf(",")).replaceAll(" ", "");
                if (row_aux.equals("0")) {
                    this.serviceFlags.transactionalPurchases(TransactionalPurchasesEnum.NUMBER_0);
                } else if (row_aux.equals("1")) {
                    this.serviceFlags.transactionalPurchases(TransactionalPurchasesEnum.NUMBER_1);
                } else {
                    throw new CustomerException().getErrorInfo(40001, ErrorCodeEnum.FORMAT_ERROR_TRANSACTIONAL_PURCHASES.getValue(), "Bad request.");
                }
            }

            if (!request.contains("downloadToGo")) {
                this.serviceFlags.setDownloadToGo(null);
            } else {
                if (this.serviceFlags == null) this.serviceFlags = new ProvisionOttUserBASEFlagsServiceFlags();
                row_aux = request.substring(request.indexOf("downloadToGo") + 12);
                row_aux = row_aux.substring(row_aux.indexOf(":") + 1);
                row_aux = row_aux.substring(0, row_aux.indexOf("\r")).replaceAll(" ", "");
                if (row_aux.equals("0")) {
                    this.serviceFlags.setDownloadToGo(ProvisionOttUserBASEFlagsServiceFlags.DownloadToGoEnum.NUMBER_1);
                } else if (row_aux.equals("1")) {
                    this.serviceFlags.setDownloadToGo(ProvisionOttUserBASEFlagsServiceFlags.DownloadToGoEnum.NUMBER_1);
                } else {
                    throw new CustomerException().getErrorInfo(40001, ErrorCodeEnum.FORMAT_ERROR_DOWNLOAD_TO_GO.getValue(), "Bad request.");
                }
            }
        }

        if (!request.contains("subscribedProducts")) {
            this.subscribedProducts = null;
        } else if (!request.contains("code")) {
            throw new CustomerException().getErrorInfo(40001, ErrorCodeEnum.OBLIGATORY_FIELD_CODE.getValue(), "Bad request.");
        } else {
            this.subscribedProducts = new ArrayList<>();
            row_aux = request.substring(request.indexOf("code") + 5);
            row_aux = row_aux.substring(row_aux.indexOf("\"") + 1);
            subscribedProduct.setCode(row_aux.substring(0, row_aux.indexOf("\"")));
            this.subscribedProducts.add(subscribedProduct);
            while (sw == 0) {
                row_aux = request.substring(request.indexOf(row_aux) + row_aux.length());
                if (row_aux.contains("code")) {
                    row_aux = request.substring(request.indexOf("code") + 5);
                    row_aux = row_aux.substring(row_aux.indexOf("\"") + 1);
                    subscribedProduct.setCode(row_aux.substring(0, row_aux.indexOf("\"")));
                    this.subscribedProducts.add(subscribedProduct);
                } else {
                    sw = 1;
                }
            }
        }
    }*/
}
