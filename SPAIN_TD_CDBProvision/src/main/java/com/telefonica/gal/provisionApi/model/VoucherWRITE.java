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
 * A specific voucher to be purchased for a certain OTT user.
 */
@ApiModel(description = "A specific voucher to be purchased for a certain OTT user.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-06-17T12:14:01.690707800+02:00[Europe/Paris]")

public class VoucherWRITE   {
  @JsonProperty("code")
  private String code;

  public VoucherWRITE code(String code) {
    this.code = code;
    return this;
  }

  /**
   * Unique identifier of the voucher product in operator's BSS/OSS systems (aka \"*Commercial code*\").
   * @return code
  */
  @ApiModelProperty(example = "EXTCOD1234", required = true, value = "Unique identifier of the voucher product in operator's BSS/OSS systems (aka \"*Commercial code*\").")
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
    VoucherWRITE voucherWRITE = (VoucherWRITE) o;
    return Objects.equals(this.code, voucherWRITE.code);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VoucherWRITE {\n");
    
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

