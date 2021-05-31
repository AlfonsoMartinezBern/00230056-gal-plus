package com.telefonica.gal.utils;

public enum Utils {
    ServicesConsolidation("ServicesConsolidation");
    private String operation;


    Utils(String operation) {
        this.operation = operation;

    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}

