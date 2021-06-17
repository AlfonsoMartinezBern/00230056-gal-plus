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
 * A specific voucher purchased by a certain OTT user. In this API, an external provision system will be able to purchase vouchers for a user, remove a voucher to a user and check the vouchers that a certain user has got.
 */
@ApiModel(description = "A specific voucher purchased by a certain OTT user. In this API, an external provision system will be able to purchase vouchers for a user, remove a voucher to a user and check the vouchers that a certain user has got.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-06-16T10:44:28.456817200+02:00[Europe/Paris]")

public class Voucher   {
  @JsonProperty("id")
  private String id;

  @JsonProperty("code")
  private String code;

  /**
   * State of this voucher for the user. Possible values are these (and only these)\\:   * 0 = Purchased but not activated (this means it has not been used yet).   * 1 = Activated and still not finished (there are pending items to purchase).   * 2 = Cannot be used anymore\\: it is either finished (there are NO pending items) or expired.  This attribute is generated and maintained by the server. 
   */
  public enum StateEnum {
    NUMBER_0(0),
    
    NUMBER_1(1),
    
    NUMBER_2(2);

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
   * Flag that indicates the type of voucher in terms of how it can be purchased. Two possible values\\:   * 0 = User voucher. These vouchers can be purchased by the users on their own (using FrontEnd APIs).   * 1 = Operator voucher. These vouchers can ONLY be assigned to the users by the operator (i.e. External Provision systems), using provision APIs such as this one.
   */
  public enum IsOperatorVoucherEnum {
    NUMBER_0(0),
    
    NUMBER_1(1);

    private Integer value;

    IsOperatorVoucherEnum(Integer value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static IsOperatorVoucherEnum fromValue(Integer value) {
      for (IsOperatorVoucherEnum b : IsOperatorVoucherEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("isOperatorVoucher")
  private IsOperatorVoucherEnum isOperatorVoucher;

  /**
   * Flag that indicates the type of voucher. Two possible values\\:   * 0 = Non renewable voucher (default case). Currently, only this type of vouchers will be used in this API.   * 1 = Monthly renewable voucher. Currently, this type of vouchers will NOT be used in this API.
   */
  public enum IsRenewableEnum {
    NUMBER_0(0),
    
    NUMBER_1(1);

    private Integer value;

    IsRenewableEnum(Integer value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static IsRenewableEnum fromValue(Integer value) {
      for (IsRenewableEnum b : IsRenewableEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("isRenewable")
  private IsRenewableEnum isRenewable;

  public Voucher id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of the purchase. Please, note that this is NOT the product ID of the voucher..
   * @return id
  */
  @ApiModelProperty(example = "1234", value = "Unique identifier of the purchase. Please, note that this is NOT the product ID of the voucher..")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Voucher code(String code) {
    this.code = code;
    return this;
  }

  /**
   * Unique identifier of the voucher product in operator's BSS/OSS systems (aka \"*Commercial code*\").
   * @return code
  */
  @ApiModelProperty(example = "EXTCOD1234", value = "Unique identifier of the voucher product in operator's BSS/OSS systems (aka \"*Commercial code*\").")


  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Voucher state(StateEnum state) {
    this.state = state;
    return this;
  }

  /**
   * State of this voucher for the user. Possible values are these (and only these)\\:   * 0 = Purchased but not activated (this means it has not been used yet).   * 1 = Activated and still not finished (there are pending items to purchase).   * 2 = Cannot be used anymore\\: it is either finished (there are NO pending items) or expired.  This attribute is generated and maintained by the server. 
   * @return state
  */
  @ApiModelProperty(example = "1", value = "State of this voucher for the user. Possible values are these (and only these)\\:   * 0 = Purchased but not activated (this means it has not been used yet).   * 1 = Activated and still not finished (there are pending items to purchase).   * 2 = Cannot be used anymore\\: it is either finished (there are NO pending items) or expired.  This attribute is generated and maintained by the server. ")


  public StateEnum getState() {
    return state;
  }

  public void setState(StateEnum state) {
    this.state = state;
  }

  public Voucher isOperatorVoucher(IsOperatorVoucherEnum isOperatorVoucher) {
    this.isOperatorVoucher = isOperatorVoucher;
    return this;
  }

  /**
   * Flag that indicates the type of voucher in terms of how it can be purchased. Two possible values\\:   * 0 = User voucher. These vouchers can be purchased by the users on their own (using FrontEnd APIs).   * 1 = Operator voucher. These vouchers can ONLY be assigned to the users by the operator (i.e. External Provision systems), using provision APIs such as this one.
   * @return isOperatorVoucher
  */
  @ApiModelProperty(example = "1", value = "Flag that indicates the type of voucher in terms of how it can be purchased. Two possible values\\:   * 0 = User voucher. These vouchers can be purchased by the users on their own (using FrontEnd APIs).   * 1 = Operator voucher. These vouchers can ONLY be assigned to the users by the operator (i.e. External Provision systems), using provision APIs such as this one.")


  public IsOperatorVoucherEnum getIsOperatorVoucher() {
    return isOperatorVoucher;
  }

  public void setIsOperatorVoucher(IsOperatorVoucherEnum isOperatorVoucher) {
    this.isOperatorVoucher = isOperatorVoucher;
  }

  public Voucher isRenewable(IsRenewableEnum isRenewable) {
    this.isRenewable = isRenewable;
    return this;
  }

  /**
   * Flag that indicates the type of voucher. Two possible values\\:   * 0 = Non renewable voucher (default case). Currently, only this type of vouchers will be used in this API.   * 1 = Monthly renewable voucher. Currently, this type of vouchers will NOT be used in this API.
   * @return isRenewable
  */
  @ApiModelProperty(example = "1", value = "Flag that indicates the type of voucher. Two possible values\\:   * 0 = Non renewable voucher (default case). Currently, only this type of vouchers will be used in this API.   * 1 = Monthly renewable voucher. Currently, this type of vouchers will NOT be used in this API.")


  public IsRenewableEnum getIsRenewable() {
    return isRenewable;
  }

  public void setIsRenewable(IsRenewableEnum isRenewable) {
    this.isRenewable = isRenewable;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Voucher voucher = (Voucher) o;
    return Objects.equals(this.id, voucher.id) &&
        Objects.equals(this.code, voucher.code) &&
        Objects.equals(this.state, voucher.state) &&
        Objects.equals(this.isOperatorVoucher, voucher.isOperatorVoucher) &&
        Objects.equals(this.isRenewable, voucher.isRenewable);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, code, state, isOperatorVoucher, isRenewable);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Voucher {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    isOperatorVoucher: ").append(toIndentedString(isOperatorVoucher)).append("\n");
    sb.append("    isRenewable: ").append(toIndentedString(isRenewable)).append("\n");
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

