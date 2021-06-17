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
 * InlineResponse403
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-06-16T10:44:28.456817200+02:00[Europe/Paris]")

public class InlineResponse403   {
  @JsonProperty("resultCode")
  private Integer resultCode;

  @JsonProperty("resultText")
  private String resultText;

  @JsonProperty("resultDetail")
  private String resultDetail;

  public InlineResponse403 resultCode(Integer resultCode) {
    this.resultCode = resultCode;
    return this;
  }

  /**
   * Get resultCode
   * @return resultCode
  */
  @ApiModelProperty(example = "4039198", value = "")


  public Integer getResultCode() {
    return resultCode;
  }

  public void setResultCode(Integer resultCode) {
    this.resultCode = resultCode;
  }

  public InlineResponse403 resultText(String resultText) {
    this.resultText = resultText;
    return this;
  }

  /**
   * Get resultText
   * @return resultText
  */
  @ApiModelProperty(example = "The user belongs to a FORBIDDEN segment for this request", value = "")


  public String getResultText() {
    return resultText;
  }

  public void setResultText(String resultText) {
    this.resultText = resultText;
  }

  public InlineResponse403 resultDetail(String resultDetail) {
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
    InlineResponse403 inlineResponse403 = (InlineResponse403) o;
    return Objects.equals(this.resultCode, inlineResponse403.resultCode) &&
        Objects.equals(this.resultText, inlineResponse403.resultText) &&
        Objects.equals(this.resultDetail, inlineResponse403.resultDetail);
  }

  @Override
  public int hashCode() {
    return Objects.hash(resultCode, resultText, resultDetail);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse403 {\n");
    
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

