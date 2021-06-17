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
 * ProvisionOttUserBASEClientSegment
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-06-17T12:14:01.690707800+02:00[Europe/Paris]")

public class ProvisionOttUserBASEClientSegment   {
  @JsonProperty("clientSegmentName")
  private String clientSegmentName;

  public ProvisionOttUserBASEClientSegment clientSegmentName(String clientSegmentName) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProvisionOttUserBASEClientSegment provisionOttUserBASEClientSegment = (ProvisionOttUserBASEClientSegment) o;
    return Objects.equals(this.clientSegmentName, provisionOttUserBASEClientSegment.clientSegmentName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(clientSegmentName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProvisionOttUserBASEClientSegment {\n");
    
    sb.append("    clientSegmentName: ").append(toIndentedString(clientSegmentName)).append("\n");
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

