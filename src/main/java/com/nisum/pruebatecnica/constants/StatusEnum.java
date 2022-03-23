package com.nisum.pruebatecnica.constants;

public enum StatusEnum {
    ACTIVE("1"),INACTIVE("0");
    private String status;
    private StatusEnum(String status){
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
