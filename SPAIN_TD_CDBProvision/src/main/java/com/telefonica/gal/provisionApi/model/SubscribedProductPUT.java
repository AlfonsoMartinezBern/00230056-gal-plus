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
 * SubscribedProductPUT
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-06-17T12:14:01.690707800+02:00[Europe/Paris]")

public class SubscribedProductPUT   {
  @JsonProperty("pendingConsolidation")
  private Integer pendingConsolidation;

  public SubscribedProductPUT pendingConsolidation(Integer pendingConsolidation) {
    this.pendingConsolidation = pendingConsolidation;
    return this;
  }

  /**
   * Flag that specifies whether this product must be assigned to the user in a CONSOLIDATED (0), or in a NON-consolidated (1) state.  OPTIONAL parameter. Default value: 0. 
   * @return pendingConsolidation
  */
  @ApiModelProperty(example = "1", value = "Flag that specifies whether this product must be assigned to the user in a CONSOLIDATED (0), or in a NON-consolidated (1) state.  OPTIONAL parameter. Default value: 0. ")


  public Integer getPendingConsolidation() {
    return pendingConsolidation;
  }

  public void setPendingConsolidation(Integer pendingConsolidation) {
    this.pendingConsolidation = pendingConsolidation;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SubscribedProductPUT subscribedProductPUT = (SubscribedProductPUT) o;
    return Objects.equals(this.pendingConsolidation, subscribedProductPUT.pendingConsolidation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pendingConsolidation);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SubscribedProductPUT {\n");
    
    sb.append("    pendingConsolidation: ").append(toIndentedString(pendingConsolidation)).append("\n");
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

