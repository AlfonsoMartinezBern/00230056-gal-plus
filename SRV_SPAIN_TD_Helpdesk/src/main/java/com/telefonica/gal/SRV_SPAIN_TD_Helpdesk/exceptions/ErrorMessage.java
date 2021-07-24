package com.telefonica.gal.SRV_SPAIN_TD_Helpdesk.exceptions;

public class ErrorMessage extends Throwable {
    private String message;
    private String codError;
    private String userid;
    private String orden_hidra;

    public String getOrden_hidra() {
        return orden_hidra;
    }

    public void setOrden_hidra(String orden_hidra) {
        this.orden_hidra = orden_hidra;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCodError() {
        return codError;
    }

    public void setCodError(String codError) {
        this.codError = codError;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

}
