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
 * A specific product to be subscribed by a certain OTT user. Products that may be subscribed by the users are \&quot;subscriptions\&quot; and \&quot;TV Packages\&quot;; both types are managed together in this API.
 */
@ApiModel(description = "A specific product to be subscribed by a certain OTT user. Products that may be subscribed by the users are \"subscriptions\" and \"TV Packages\"; both types are managed together in this API.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-06-16T10:44:28.456817200+02:00[Europe/Paris]")

public class SubscribedProductWRITE   {
  @JsonProperty("code")
  private String code;

  public SubscribedProductWRITE code(String code) {
    this.code = code;
    return this;
  }

  /**
   * Unique identifier of the product in operator's BSS/OSS systems (aka \"*Commercial code*\").
   * @return code
  */
  @ApiModelProperty(example = "EXTCOD125", required = true, value = "Unique identifier of the product in operator's BSS/OSS systems (aka \"*Commercial code*\").")
  @NotNull


  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SubscribedProductWRITE subscribedProductWRITE = (SubscribedProductWRITE) o;
    return Objects.equals(this.code, subscribedProductWRITE.code);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SubscribedProductWRITE {\n");
    
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
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

