package com.telefonica.gal.SPAIN_TD_CDBProvision_Routing.exceptions;

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
}
