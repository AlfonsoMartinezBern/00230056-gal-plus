package com.telefonica.gal.provisionApi.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Object containing the following elements.
 */
@ApiModel(description = "Object containing the following elements.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-06-17T12:14:01.690707800+02:00[Europe/Paris]")

public class ProvisionOttUserBASEDevicesDevices   {
  @JsonProperty("maxNumDevices")
  private Integer maxNumDevices;

  public ProvisionOttUserBASEDevicesDevices maxNumDevices(Integer maxNumDevices) {
    this.maxNumDevices = maxNumDevices;
    return this;
  }

  /**
   * Maximum number of devices the user may register in the platform.  The possible values are numbers\\:   * A NEGATIVE value means there is NO maximum for this user (unlimited).   * A 0 value means the user may NOT register any device.   * A POSITIVE value is to be taken as the specific maximum for this user.  The default value is -1.  The maximum value is 99. 
   * @return maxNumDevices
  */
  @ApiModelProperty(example = "5", value = "Maximum number of devices the user may register in the platform.  The possible values are numbers\\:   * A NEGATIVE value means there is NO maximum for this user (unlimited).   * A 0 value means the user may NOT register any device.   * A POSITIVE value is to be taken as the specific maximum for this user.  The default value is -1.  The maximum value is 99. ")


  public Integer getMaxNumDevices() {
    return maxNumDevices;
  }

  public void setMaxNumDevices(Integer maxNumDevices) {
    this.maxNumDevices = maxNumDevices;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProvisionOttUserBASEDevicesDevices provisionOttUserBASEDevicesDevices = (ProvisionOttUserBASEDevicesDevices) o;
    return Objects.equals(this.maxNumDevices, provisionOttUserBASEDevicesDevices.maxNumDevices);
  }

  @Override
  public int hashCode() {
    return Objects.hash(maxNumDevices);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProvisionOttUserBASEDevicesDevices {\n");
    
    sb.append("    maxNumDevices: ").append(toIndentedString(maxNumDevices)).append("\n");
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

