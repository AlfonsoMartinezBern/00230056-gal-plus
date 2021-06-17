package com.telefonica.gal.provisionApi.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.telefonica.gal.provisionApi.model.SubscribedProduct;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ProvisionOttUserBASESubscribedProducts
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-06-16T10:44:28.456817200+02:00[Europe/Paris]")

public class ProvisionOttUserBASESubscribedProducts   {
  @JsonProperty("subscribedProducts")
  @Valid
  private List<SubscribedProduct> subscribedProducts = null;

  public ProvisionOttUserBASESubscribedProducts subscribedProducts(List<SubscribedProduct> subscribedProducts) {
    this.subscribedProducts = subscribedProducts;
    return this;
  }

  public ProvisionOttUserBASESubscribedProducts addSubscribedProductsItem(SubscribedProduct subscribedProductsItem) {
    if (this.subscribedProducts == null) {
      this.subscribedProducts = new ArrayList<>();
    }
    this.subscribedProducts.add(subscribedProductsItem);
    return this;
  }

  /**
   * List of products (subscriptions and TV Packages) subscribed by this user.
   * @return subscribedProducts
  */
  @ApiModelProperty(value = "List of products (subscriptions and TV Packages) subscribed by this user.")

  @Valid

  public List<SubscribedProduct> getSubscribedProducts() {
    return subscribedProducts;
  }

  public void setSubscribedProducts(List<SubscribedProduct> subscribedProducts) {
    this.subscribedProducts = subscribedProducts;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProvisionOttUserBASESubscribedProducts provisionOttUserBASESubscribedProducts = (ProvisionOttUserBASESubscribedProducts) o;
    return Objects.equals(this.subscribedProducts, provisionOttUserBASESubscribedProducts.subscribedProducts);
  }

  @Override
  public int hashCode() {
    return Objects.hash(subscribedProducts);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProvisionOttUserBASESubscribedProducts {\n");
    
    sb.append("    subscribedProducts: ").append(toIndentedString(subscribedProducts)).append("\n");
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

