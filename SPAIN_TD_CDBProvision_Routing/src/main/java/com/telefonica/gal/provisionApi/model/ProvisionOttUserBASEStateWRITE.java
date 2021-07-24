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
 * ProvisionOttUserBASEStateWRITE
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-06-17T12:14:01.690707800+02:00[Europe/Paris]")


public class ProvisionOttUserBASEStateWRITE   {
  /**
   * State of this user. Possible values are these (and only these)\\:   * 1 = active state (this is the default value).   * 0 = suspended state.   * NOTE\\: To set state=-1 (cancelled user), a DELETE request must be used instead.
   */
  public enum StateEnum {
    NUMBER_0(0),
    
    NUMBER_1(1);

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

  public ProvisionOttUserBASEStateWRITE state(StateEnum state) {
    this.state = state;
    return this;
  }

  /**
   * State of this user. Possible values are these (and only these)\\:   * 1 = active state (this is the default value).   * 0 = suspended state.   * NOTE\\: To set state=-1 (cancelled user), a DELETE request must be used instead.
   * @return state
  */
  @ApiModelProperty(example = "1", value = "State of this user. Possible values are these (and only these)\\:   * 1 = active state (this is the default value).   * 0 = suspended state.   * NOTE\\: To set state=-1 (cancelled user), a DELETE request must be used instead.")


  public StateEnum getState() {
    return state;
  }

  public void setState(StateEnum state) {
    this.state = state;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProvisionOttUserBASEStateWRITE provisionOttUserBASEStateWRITE = (ProvisionOttUserBASEStateWRITE) o;
    return Objects.equals(this.state, provisionOttUserBASEStateWRITE.state);
  }

  @Override
  public int hashCode() {
    return Objects.hash(state);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProvisionOttUserBASEStateWRITE {\n");
    
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
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

