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
 * A specific product subscribed by a certain OTT user. Products that may be subscribed by the users are \&quot;subscriptions\&quot; and \&quot;TV Packages\&quot;; both types are managed together in this API.
 */
@ApiModel(description = "A specific product subscribed by a certain OTT user. Products that may be subscribed by the users are \"subscriptions\" and \"TV Packages\"; both types are managed together in this API.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-06-17T12:14:01.690707800+02:00[Europe/Paris]")

public class SubscribedProduct   {
  @JsonProperty("code")
  private String code;

  /**
   * State of this product for the user. Possible values are these (and only these)\\:   * 1 = Still being provisioned (aka, pending consolidation order from Provision API).   * 2 = Active.   * 3 = Being cancelled (aka, pending removal order from Provision API).  This attribute is generated and maintained by the server. 
   */
  public enum StateEnum {
    NUMBER_1(1),
    
    NUMBER_2(2),
    
    NUMBER_3(3);

    private Integer value;

    StateEnum(Integer value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StateEnum fromValue(Integer value) {
      for (StateEnum b : StateEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("state")
  private StateEnum state;

  /**
   * Type  of the product. Possible values are these (and only these)\\:   * 0 = Subscriptions.   * 1 = TV Packages.
   */
  public enum TypeEnum {
    NUMBER_0(0),
    
    NUMBER_1(1);

    private Integer value;

    TypeEnum(Integer value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TypeEnum fromValue(Integer value) {
      for (TypeEnum b : TypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("type")
  private TypeEnum type;

  public SubscribedProduct code(String code) {
    this.code = code;
    return this;
  }

  /**
   * Unique identifier of the product in operator's BSS/OSS systems (aka \"*Commercial code*\").
   * @return code
  */
  @ApiModelProperty(example = "EXTCOD125", value = "Unique identifier of the product in operator's BSS/OSS systems (aka \"*Commercial code*\").")


  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public SubscribedProduct state(StateEnum state) {
    this.state = state;
    return this;
  }

  /**
   * State of this product for the user. Possible values are these (and only these)\\:   * 1 = Still being provisioned (aka, pending consolidation order from Provision API).   * 2 = Active.   * 3 = Being cancelled (aka, pending removal order from Provision API).  This attribute is generated and maintained by the server. 
   * @return state
  */
  @ApiModelProperty(example = "2", value = "State of this product for the user. Possible values are these (and only these)\\:   * 1 = Still being provisioned (aka, pending consolidation order from Provision API).   * 2 = Active.   * 3 = Being cancelled (aka, pending removal order from Provision API).  This attribute is generated and maintained by the server. ")


  public StateEnum getState() {
    return state;
  }

  public void setState(StateEnum state) {
    this.state = state;
  }

  public SubscribedProduct type(TypeEnum type) {
    this.type = type;
    return this;
  }

  /**
   * Type  of the product. Possible values are these (and only these)\\:   * 0 = Subscriptions.   * 1 = TV Packages.
   * @return type
  */
  @ApiModelProperty(example = "1", value = "Type  of the product. Possible values are these (and only these)\\:   * 0 = Subscriptions.   * 1 = TV Packages.")


  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SubscribedProduct subscribedProduct = (SubscribedProduct) o;
    return Objects.equals(this.code, subscribedProduct.code) &&
        Objects.equals(this.state, subscribedProduct.state) &&
        Objects.equals(this.type, subscribedProduct.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, state, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SubscribedProduct {\n");
    
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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

