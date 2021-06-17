package com.telefonica.gal.provisionApi.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * \\\&quot;Self\\\&quot; Hypermedia link to this OTT user.
 */
@ApiModel(description = "\\\"Self\\\" Hypermedia link to this OTT user.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-06-17T12:14:01.690707800+02:00[Europe/Paris]")

public class LinkUserSelf   {
  @JsonProperty("href")
  private String href;

  /**
   * Gets or Sets rel
   */
  public enum RelEnum {
    SELF("self");

    private String value;

    RelEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static RelEnum fromValue(String value) {
      for (RelEnum b : RelEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("rel")
  private RelEnum rel;

  public LinkUserSelf href(String href) {
    this.href = href;
    return this;
  }

  /**
   * Get href
   * @return href
  */
  @ApiModelProperty(example = "http://api.imagenio.telefonica.net/cdbprovision/rest/provision/OTT/codigo1234", value = "")


  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public LinkUserSelf rel(RelEnum rel) {
    this.rel = rel;
    return this;
  }

  /**
   * Get rel
   * @return rel
  */
  @ApiModelProperty(value = "")


  public RelEnum getRel() {
    return rel;
  }

  public void setRel(RelEnum rel) {
    this.rel = rel;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LinkUserSelf linkUserSelf = (LinkUserSelf) o;
    return Objects.equals(this.href, linkUserSelf.href) &&
        Objects.equals(this.rel, linkUserSelf.rel);
  }

  @Override
  public int hashCode() {
    return Objects.hash(href, rel);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LinkUserSelf {\n");
    
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    rel: ").append(toIndentedString(rel)).append("\n");
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

