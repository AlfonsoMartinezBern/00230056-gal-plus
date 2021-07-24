package com.telefonica.gal.provisionApi.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.telefonica.gal.provisionApi.model.ProvisionOttUserBASEFlagsServiceFlags;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ProvisionOttUserBASEFlags
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-06-17T12:14:01.690707800+02:00[Europe/Paris]")


public class ProvisionOttUserBASEFlags   {
  @JsonProperty("serviceFlags")
  private ProvisionOttUserBASEFlagsServiceFlags serviceFlags;

  public ProvisionOttUserBASEFlags serviceFlags(ProvisionOttUserBASEFlagsServiceFlags serviceFlags) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProvisionOttUserBASEFlags provisionOttUserBASEFlags = (ProvisionOttUserBASEFlags) o;
    return Objects.equals(this.serviceFlags, provisionOttUserBASEFlags.serviceFlags);
  }

  @Override
  public int hashCode() {
    return Objects.hash(serviceFlags);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProvisionOttUserBASEFlags {\n");
    
    sb.append("    serviceFlags: ").append(toIndentedString(serviceFlags)).append("\n");
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

