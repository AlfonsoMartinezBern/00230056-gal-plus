package com.telefonica.gal.provisionApi.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.telefonica.gal.provisionApi.model.AnyOflinkVoucherSelf;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * VoucherBASELinks
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-06-16T10:44:28.456817200+02:00[Europe/Paris]")

public class VoucherBASELinks   {
  @JsonProperty("links")
  @Valid
  private List<AnyOflinkVoucherSelf> links = null;

  public VoucherBASELinks links(List<AnyOflinkVoucherSelf> links) {
    this.links = links;
    return this;
  }

  public VoucherBASELinks addLinksItem(AnyOflinkVoucherSelf linksItem) {
    if (this.links == null) {
      this.links = new ArrayList<>();
    }
    this.links.add(linksItem);
    return this;
  }

  /**
   * List of hypermedia links related to this voucher.
   * @return links
  */
  @ApiModelProperty(value = "List of hypermedia links related to this voucher.")

  @Valid

  public List<AnyOflinkVoucherSelf> getLinks() {
    return links;
  }

  public void setLinks(List<AnyOflinkVoucherSelf> links) {
    this.links = links;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VoucherBASELinks voucherBASELinks = (VoucherBASELinks) o;
    return Objects.equals(this.links, voucherBASELinks.links);
  }

  @Override
  public int hashCode() {
    return Objects.hash(links);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VoucherBASELinks {\n");
    
    sb.append("    links: ").append(toIndentedString(links)).append("\n");
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

