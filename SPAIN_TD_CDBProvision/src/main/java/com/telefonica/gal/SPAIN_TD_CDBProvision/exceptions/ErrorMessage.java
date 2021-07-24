package com.telefonica.gal.SPAIN_TD_CDBProvision.exceptions;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorMessage extends Throwable {
    private Integer resultCode;
    private String resultText;
    private String resultDetail;

    public Integer getResultCode() {
        return resultCode;
    }

    public void setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultText() {
        return resultText;
    }

    public void setResultText(String resultText) {
        this.resultText = resultText;
    }

    public String getResultDetail() {
        return resultDetail;
    }

    public void setResultDetail(String resultDetail) {
        this.resultDetail = resultDetail;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        sb.append("    \"resultCode\": \"").append(toIndentedString(resultCode)).append("\",\n");
        sb.append("    \"resultText\": \"").append(toIndentedString(resultText)).append("\",\n");
        sb.append("    \"resultDetail\": \"").append(toIndentedString(resultDetail)).append("\"\n");
        sb.append("}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}
