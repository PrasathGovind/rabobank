package com.rabobank.payments.beans.enums;

public enum ErrorReasonCode {
	
	UNKNOWN_CERTIFICATE("API-01","The certificate is not known",400), 
	INVALID_SIGNATURE("API-02","The certificate signature is invalid",400), 
	INVALID_REQUEST("API-03","The initiate payments request is invalid",400), 
	LIMIT_EXCEEDED("API-04","We are sorry! The amount limit exceeded",422), 
	GENERAL_ERROR("API-05","Please check if the certificate is missing",500);
	
	private final String code;
    private final String description;
    private final int statusCode;

    private ErrorReasonCode(String code, String description, int statusCode) {
        this.code = code;
        this.description = description;
        this.statusCode = statusCode;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public int getStatusCode() {
        return statusCode;
    }

    @Override
    public String toString() {
        return code + ": " + description;
    }

}
