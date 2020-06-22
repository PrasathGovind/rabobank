package com.rabobank.payments.advices.exceptions;

import com.rabobank.payments.beans.enums.ErrorReasonCode;

public class APIException extends RuntimeException{
	
	private static final long serialVersionUID = 575010531796832714L;

	private ErrorReasonCode errorReasonCode;
	
	public APIException(ErrorReasonCode errorConstant) {
		super(errorConstant.toString());
		this.errorReasonCode = errorConstant;
    }

	public ErrorReasonCode getErrorReasonCode() {
		return errorReasonCode;
	}

	public void setErrorReasonCode(ErrorReasonCode ErrorReasonCode) {
		this.errorReasonCode = ErrorReasonCode;
	}

}
