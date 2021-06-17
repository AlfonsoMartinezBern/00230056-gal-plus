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
 * InlineResponse409
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-06-16T10:44:28.456817200+02:00[Europe/Paris]")

public class InlineResponse409   {
  @JsonProperty("resultCode")
  private Integer resultCode;

  @JsonProperty("resultText")
  private String resultText;

  @JsonProperty("resultDetail")
  private String resultDetail;

  public InlineResponse409 resultCode(Integer resultCode) {
    this.resultCode = resultCode;
    return this;
  }

  /**
   * Get resultCode
   * @return resultCode
  */
  @ApiModelProperty(example = "4099079", value = "")


  public Integer getResultCode() {
    return resultCode;
  }

  public void setResultCode(Integer resultCode) {
    this.resultCode = resultCode;
  }

  public InlineResponse409 resultText(String resultText) {
    this.resultText = resultText;
    return this;
  }

  /**
   * Get resultText
   * @return resultText
  */
  @ApiModelProperty(example = "Product cannot be activated for this user. It is incompatible with another one", value = "")


  public String getResultText() {
    return resultText;
  }

  public void setResultText(String resultText) {
    this.resultText = resultText;
  }

  public InlineResponse409 resultDetail(String resultDetail) {
    this.resultDetail = resultDetail;
    return this;
  }

  /**
   * Get resultDetail
   * @return resultDetail
  */
  @ApiModelProperty(value = "")


  public String getResultDetail() {
    return resultDetail;
  }

  public void setResultDetail(String resultDetail) {
    this.resultDetail = resultDetail;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineResponse409 inlineResponse409 = (InlineResponse409) o;
    return Objects.equals(this.resultCode, inlineResponse409.resultCode) &&
        Objects.equals(this.resultText, inlineResponse409.resultText) &&
        Objects.equals(this.resultDetail, inlineResponse409.resultDetail);
  }

  @Override
  public int hashCode() {
    return Objects.hash(resultCode, resultText, resultDetail);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse409 {\n");
    
    sb.append("    resultCode: ").append(toIndentedString(resultCode)).append("\n");
    sb.append("    resultText: ").append(toIndentedString(resultText)).append("\n");
    sb.append("    resultDetail: ").append(toIndentedString(resultDetail)).append("\n");
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

