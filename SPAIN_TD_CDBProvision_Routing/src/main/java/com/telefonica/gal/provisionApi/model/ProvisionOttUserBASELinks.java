package com.telefonica.gal.provisionApi.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.telefonica.gal.provisionApi.model.AnyOflinkUserSelflinkUserProducts;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ProvisionOttUserBASELinks
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-06-16T10:44:28.456817200+02:00[Europe/Paris]")

public class ProvisionOttUserBASELinks   {
  @JsonProperty("links")
  @Valid
  private List<AnyOflinkUserSelflinkUserProducts> links = null;

  public ProvisionOttUserBASELinks links(List<AnyOflinkUserSelflinkUserProducts> links) {
    this.links = links;
    return this;
  }

  public ProvisionOttUserBASELinks addLinksItem(AnyOflinkUserSelflinkUserProducts linksItem) {
    if (this.links == null) {
      this.links = new ArrayList<>();
    }
    this.links.add(linksItem);
    return this;
  }

  /**
   * List of hypermedia links related to this OTT user.
   * @return links
  */
  @ApiModelProperty(value = "List of hypermedia links related to this OTT user.")

  @Valid

  public List<AnyOflinkUserSelflinkUserProducts> getLinks() {
    return links;
  }

  public void setLinks(List<AnyOflinkUserSelflinkUserProducts> links) {
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
    ProvisionOttUserBASELinks provisionOttUserBASELinks = (ProvisionOttUserBASELinks) o;
    return Objects.equals(this.links, provisionOttUserBASELinks.links);
  }

  @Override
  public int hashCode() {
    return Objects.hash(links);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProvisionOttUserBASELinks {\n");
    
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

