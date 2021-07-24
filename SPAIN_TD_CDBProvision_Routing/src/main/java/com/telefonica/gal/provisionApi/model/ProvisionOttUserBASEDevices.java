package com.telefonica.gal.provisionApi.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.telefonica.gal.provisionApi.model.ProvisionOttUserBASEDevicesDevices;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ProvisionOttUserBASEDevices
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-06-17T12:14:01.690707800+02:00[Europe/Paris]")


public class ProvisionOttUserBASEDevices   {
  @JsonProperty("devices")
  private ProvisionOttUserBASEDevicesDevices devices;

  public ProvisionOttUserBASEDevices devices(ProvisionOttUserBASEDevicesDevices devices) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProvisionOttUserBASEDevices provisionOttUserBASEDevices = (ProvisionOttUserBASEDevices) o;
    return Objects.equals(this.devices, provisionOttUserBASEDevices.devices);
  }

  @Override
  public int hashCode() {
    return Objects.hash(devices);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProvisionOttUserBASEDevices {\n");
    
    sb.append("    devices: ").append(toIndentedString(devices)).append("\n");
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

