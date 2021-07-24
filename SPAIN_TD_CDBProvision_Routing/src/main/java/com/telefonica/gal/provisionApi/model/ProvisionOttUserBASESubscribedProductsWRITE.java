package com.telefonica.gal.provisionApi.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.telefonica.gal.provisionApi.model.SubscribedProductWRITE;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ProvisionOttUserBASESubscribedProductsWRITE
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-06-17T12:14:01.690707800+02:00[Europe/Paris]")


public class ProvisionOttUserBASESubscribedProductsWRITE   {
  @JsonProperty("subscribedProducts")
  @Valid
  private List<SubscribedProductWRITE> subscribedProducts = null;

  public ProvisionOttUserBASESubscribedProductsWRITE subscribedProducts(List<SubscribedProductWRITE> subscribedProducts) {
    this.subscribedProducts = subscribedProducts;
    return this;
  }

  public ProvisionOttUserBASESubscribedProductsWRITE addSubscribedProductsItem(SubscribedProductWRITE subscribedProductsItem) {
    if (this.subscribedProducts == null) {
      this.subscribedProducts = new ArrayList<>();
    }
    this.subscribedProducts.add(subscribedProductsItem);
    return this;
  }

  /**
   * List of products (subscriptions and TV Packages) to be subscribed by this user.  This will be the FULL list of products that the user must be subscribed to after this modification (i.e. \"final picture\" modification).  In case this field is NOT included in the request, current user's subscribed product list is left unmodified. BUT, in case the field is included as an EMPTY list (value equal to []), the user is left with NO subscribed product in the database. 
   * @return subscribedProducts
  */
  @ApiModelProperty(value = "List of products (subscriptions and TV Packages) to be subscribed by this user.  This will be the FULL list of products that the user must be subscribed to after this modification (i.e. \"final picture\" modification).  In case this field is NOT included in the request, current user's subscribed product list is left unmodified. BUT, in case the field is included as an EMPTY list (value equal to []), the user is left with NO subscribed product in the database. ")

  @Valid

  public List<SubscribedProductWRITE> getSubscribedProducts() {
    return subscribedProducts;
  }

  public void setSubscribedProducts(List<SubscribedProductWRITE> subscribedProducts) {
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
    ProvisionOttUserBASESubscribedProductsWRITE provisionOttUserBASESubscribedProductsWRITE = (ProvisionOttUserBASESubscribedProductsWRITE) o;
    return Objects.equals(this.subscribedProducts, provisionOttUserBASESubscribedProductsWRITE.subscribedProducts);
  }

  @Override
  public int hashCode() {
    return Objects.hash(subscribedProducts);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProvisionOttUserBASESubscribedProductsWRITE {\n");
    
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

