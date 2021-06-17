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
 * Object containing the following elements.
 */
@ApiModel(description = "Object containing the following elements.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-06-16T10:44:28.456817200+02:00[Europe/Paris]")

public class ProvisionOttUserBASEFlagsServiceFlags   {
  /**
   * Flag enabling/disabling the user to apply transactional purchases\\:   * 0 = option is disabled.   * 1 = option is enabled (this is the default value).  Other values are not expected, and will be forbidden by the server. 
   */
  public enum TransactionalPurchasesEnum {
    NUMBER_0(0),
    
    NUMBER_1(1);

    private Integer value;

    TransactionalPurchasesEnum(Integer value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TransactionalPurchasesEnum fromValue(Integer value) {
      for (TransactionalPurchasesEnum b : TransactionalPurchasesEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("transactionalPurchases")
  private TransactionalPurchasesEnum transactionalPurchases;

  /**
   * Flag enabling/disabling the user to enjoy \"Download to go\" services\\:   * 0 = option is disabled.   * 1 = option is enabled (this is the default value).  Other values are not expected, and will be forbidden by the server. 
   */
  public enum DownloadToGoEnum {
    NUMBER_0(0),
    
    NUMBER_1(1);

    private Integer value;

    DownloadToGoEnum(Integer value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static DownloadToGoEnum fromValue(Integer value) {
      for (DownloadToGoEnum b : DownloadToGoEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("downloadToGo")
  private DownloadToGoEnum downloadToGo;

  public ProvisionOttUserBASEFlagsServiceFlags transactionalPurchases(TransactionalPurchasesEnum transactionalPurchases) {
    this.transactionalPurchases = transactionalPurchases;
    return this;
  }

  /**
   * Flag enabling/disabling the user to apply transactional purchases\\:   * 0 = option is disabled.   * 1 = option is enabled (this is the default value).  Other values are not expected, and will be forbidden by the server. 
   * @return transactionalPurchases
  */
  @ApiModelProperty(example = "1", value = "Flag enabling/disabling the user to apply transactional purchases\\:   * 0 = option is disabled.   * 1 = option is enabled (this is the default value).  Other values are not expected, and will be forbidden by the server. ")


  public TransactionalPurchasesEnum getTransactionalPurchases() {
    return transactionalPurchases;
  }

  public void setTransactionalPurchases(TransactionalPurchasesEnum transactionalPurchases) {
    this.transactionalPurchases = transactionalPurchases;
  }

  public ProvisionOttUserBASEFlagsServiceFlags downloadToGo(DownloadToGoEnum downloadToGo) {
    this.downloadToGo = downloadToGo;
    return this;
  }

  /**
   * Flag enabling/disabling the user to enjoy \"Download to go\" services\\:   * 0 = option is disabled.   * 1 = option is enabled (this is the default value).  Other values are not expected, and will be forbidden by the server. 
   * @return downloadToGo
  */
  @ApiModelProperty(example = "1", value = "Flag enabling/disabling the user to enjoy \"Download to go\" services\\:   * 0 = option is disabled.   * 1 = option is enabled (this is the default value).  Other values are not expected, and will be forbidden by the server. ")


  public DownloadToGoEnum getDownloadToGo() {
    return downloadToGo;
  }

  public void setDownloadToGo(DownloadToGoEnum downloadToGo) {
    this.downloadToGo = downloadToGo;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProvisionOttUserBASEFlagsServiceFlags provisionOttUserBASEFlagsServiceFlags = (ProvisionOttUserBASEFlagsServiceFlags) o;
    return Objects.equals(this.transactionalPurchases, provisionOttUserBASEFlagsServiceFlags.transactionalPurchases) &&
        Objects.equals(this.downloadToGo, provisionOttUserBASEFlagsServiceFlags.downloadToGo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(transactionalPurchases, downloadToGo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProvisionOttUserBASEFlagsServiceFlags {\n");
    
    sb.append("    transactionalPurchases: ").append(toIndentedString(transactionalPurchases)).append("\n");
    sb.append("    downloadToGo: ").append(toIndentedString(downloadToGo)).append("\n");
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

