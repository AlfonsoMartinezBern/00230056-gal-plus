package com.telefonica.gal.provisionApi.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.telefonica.gal.provisionApi.model.ProvisionOttUserAllOf;
import com.telefonica.gal.provisionApi.model.ProvisionOttUserBASEClientSegment;
import com.telefonica.gal.provisionApi.model.ProvisionOttUserBASEDevices;
import com.telefonica.gal.provisionApi.model.ProvisionOttUserBASEDevicesDevices;
import com.telefonica.gal.provisionApi.model.ProvisionOttUserBASEFlags;
import com.telefonica.gal.provisionApi.model.ProvisionOttUserBASEFlagsServiceFlags;
import com.telefonica.gal.provisionApi.model.ProvisionOttUserBASEState;
import com.telefonica.gal.provisionApi.model.ProvisionOttUserBASESubscribedProducts;
import com.telefonica.gal.provisionApi.model.SubscribedProduct;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * A specific user provisioned in the platform from the OTT platform.
 */
@ApiModel(description = "A specific user provisioned in the platform from the OTT platform.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-06-17T12:14:01.690707800+02:00[Europe/Paris]")

public class ProvisionOttUser   {
  @JsonProperty("adminCode")
  private String adminCode;

  @JsonProperty("clientSegmentName")
  private String clientSegmentName;

  @JsonProperty("devices")
  private ProvisionOttUserBASEDevicesDevices devices;

  @JsonProperty("serviceFlags")
  private ProvisionOttUserBASEFlagsServiceFlags serviceFlags;

  /**
   * State of this user. Possible values are these (and only these)\\:   * 1 = active state (this is the default value).   * 0 = suspended state.   * -1 = cancelled state.
   */
  public enum StateEnum {
    NUMBER_0(0),
    
    NUMBER_1(1),
    
    NUMBER_MINUS_1(-1);

    private Integer value;

    StateEnum(Integer value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StateEnum fromValue(Integer value) {
      for (StateEnum b : StateEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("state")
  private StateEnum state;

  @JsonProperty("subscribedProducts")
  @Valid
  private List<SubscribedProduct> subscribedProducts = null;

  public ProvisionOttUser adminCode(String adminCode) {
    this.adminCode = adminCode;
    return this;
  }

  /**
   * Unique identifier of the user in operator's network and BSS/OSS systems.
   * @return adminCode
  */
  @ApiModelProperty(example = "codigo1234", value = "Unique identifier of the user in operator's network and BSS/OSS systems.")


  public String getAdminCode() {
    return adminCode;
  }

  public void setAdminCode(String adminCode) {
    this.adminCode = adminCode;
  }

  public ProvisionOttUser clientSegmentName(String clientSegmentName) {
    this.clientSegmentName = clientSegmentName;
    return this;
  }

  /**
   * Client segment the user belongs to (referenced by its name).  This parameter defines which products may be contracted or purchased by this user. 
   * @return clientSegmentName
  */
  @ApiModelProperty(example = "SAT1", value = "Client segment the user belongs to (referenced by its name).  This parameter defines which products may be contracted or purchased by this user. ")


  public String getClientSegmentName() {
    return clientSegmentName;
  }

  public void setClientSegmentName(String clientSegmentName) {
    this.clientSegmentName = clientSegmentName;
  }

  public ProvisionOttUser devices(ProvisionOttUserBASEDevicesDevices devices) {
    this.devices = devices;
    return this;
  }

  /**
   * Get devices
   * @return devices
  */
  @ApiModelProperty(value = "")

  @Valid

  public ProvisionOttUserBASEDevicesDevices getDevices() {
    return devices;
  }

  public void setDevices(ProvisionOttUserBASEDevicesDevices devices) {
    this.devices = devices;
  }

  public ProvisionOttUser serviceFlags(ProvisionOttUserBASEFlagsServiceFlags serviceFlags) {
    this.serviceFlags = serviceFlags;
    return this;
  }

  /**
   * Get serviceFlags
   * @return serviceFlags
  */
  @ApiModelProperty(value = "")

  @Valid

  public ProvisionOttUserBASEFlagsServiceFlags getServiceFlags() {
    return serviceFlags;
  }

  public void setServiceFlags(ProvisionOttUserBASEFlagsServiceFlags serviceFlags) {
    this.serviceFlags = serviceFlags;
  }

  public ProvisionOttUser state(StateEnum state) {
    this.state = state;
    return this;
  }

  /**
   * State of this user. Possible values are these (and only these)\\:   * 1 = active state (this is the default value).   * 0 = suspended state.   * -1 = cancelled state.
   * @return state
  */
  @ApiModelProperty(example = "1", value = "State of this user. Possible values are these (and only these)\\:   * 1 = active state (this is the default value).   * 0 = suspended state.   * -1 = cancelled state.")


  public StateEnum getState() {
    return state;
  }

  public void setState(StateEnum state) {
    this.state = state;
  }

  public ProvisionOttUser subscribedProducts(List<SubscribedProduct> subscribedProducts) {
    this.subscribedProducts = subscribedProducts;
    return this;
  }

  public ProvisionOttUser addSubscribedProductsItem(SubscribedProduct subscribedProductsItem) {
    if (this.subscribedProducts == null) {
      this.subscribedProducts = new ArrayList<>();
    }
    this.subscribedProducts.add(subscribedProductsItem);
    return this;
  }

  /**
   * List of products (subscriptions and TV Packages) subscribed by this user.
   * @return subscribedProducts
  */
  @ApiModelProperty(value = "List of products (subscriptions and TV Packages) subscribed by this user.")

  @Valid

  public List<SubscribedProduct> getSubscribedProducts() {
    return subscribedProducts;
  }

  public void setSubscribedProducts(List<SubscribedProduct> subscribedProducts) {
    this.subscribedProducts = subscribedProducts;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProvisionOttUser provisionOttUser = (ProvisionOttUser) o;
    return Objects.equals(this.adminCode, provisionOttUser.adminCode) &&
        Objects.equals(this.clientSegmentName, provisionOttUser.clientSegmentName) &&
        Objects.equals(this.devices, provisionOttUser.devices) &&
        Objects.equals(this.serviceFlags, provisionOttUser.serviceFlags) &&
        Objects.equals(this.state, provisionOttUser.state) &&
        Objects.equals(this.subscribedProducts, provisionOttUser.subscribedProducts);
  }

  @Override
  public int hashCode() {
    return Objects.hash(adminCode, clientSegmentName, devices, serviceFlags, state, subscribedProducts);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProvisionOttUser {\n");
    
    sb.append("    adminCode: ").append(toIndentedString(adminCode)).append("\n");
    sb.append("    clientSegmentName: ").append(toIndentedString(clientSegmentName)).append("\n");
    sb.append("    devices: ").append(toIndentedString(devices)).append("\n");
    sb.append("    serviceFlags: ").append(toIndentedString(serviceFlags)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    subscribedProducts: ").append(toIndentedString(subscribedProducts)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

