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
 * ProvisionOttUserAllOf
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-06-16T10:44:28.456817200+02:00[Europe/Paris]")

public class ProvisionOttUserAllOf   {
  @JsonProperty("adminCode")
  private String adminCode;

  public ProvisionOttUserAllOf adminCode(String adminCode) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProvisionOttUserAllOf provisionOttUserAllOf = (ProvisionOttUserAllOf) o;
    return Objects.equals(this.adminCode, provisionOttUserAllOf.adminCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(adminCode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProvisionOttUserAllOf {\n");
    
    sb.append("    adminCode: ").append(toIndentedString(adminCode)).append("\n");
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

