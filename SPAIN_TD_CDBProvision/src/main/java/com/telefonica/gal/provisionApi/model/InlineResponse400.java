package com.telefonica.gal.provisionApi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * InlineResponse400
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-06-17T12:14:01.690707800+02:00[Europe/Paris]")

public class InlineResponse400   {
  @JsonProperty("resultCode")
  private Integer resultCode;

  @JsonProperty("resultText")
  private String resultText;

  @JsonProperty("resultDetail")
  private String resultDetail;

  public InlineResponse400 resultCode(Integer resultCode) {
    this.resultCode = resultCode;
    return this;
  }

  /**
   * Get resultCode
   * @return resultCode
  */
  @ApiModelProperty(example = "40001", value = "")


  public Integer getResultCode() {
    return resultCode;
  }

  public void setResultCode(Integer resultCode) {
    this.resultCode = resultCode;
  }

  public InlineResponse400 resultText(String resultText) {
    this.resultText = resultText;
    return this;
  }

  /**
   * Get resultText
   * @return resultText
  */
  @ApiModelProperty(example = "Bad request", value = "")


  public String getResultText() {
    return resultText;
  }

  public void setResultText(String resultText) {
    this.resultText = resultText;
  }

  public InlineResponse400 resultDetail(String resultDetail) {
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
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineResponse400 inlineResponse400 = (InlineResponse400) o;
    return Objects.equals(this.resultCode, inlineResponse400.resultCode) &&
        Objects.equals(this.resultText, inlineResponse400.resultText) &&
        Objects.equals(this.resultDetail, inlineResponse400.resultDetail);
  }

  @Override
  public int hashCode() {
    return Objects.hash(resultCode, resultText, resultDetail);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{\n");
    
    sb.append("    resultCode: ").append(toIndentedString(resultCode)).append(",\n");
    sb.append("    resultText: ").append(toIndentedString(resultText)).append(",\n");
    sb.append("    resultDetail: ").append(toIndentedString(resultDetail)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

