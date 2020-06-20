package com.rabobank.payments.beans.responses;

import java.io.Serializable;

import com.rabobank.payments.beans.enums.ErrorReasonCode;
import com.rabobank.payments.beans.enums.TransactionStatus;

public class PaymentRejectedResponse implements Serializable{
	
	private static final long serialVersionUID = -3873828704853534302L;

	TransactionStatus status;
	
	String reason;
	
	ErrorReasonCode reasonCode;

	public TransactionStatus getStatus() {
		return status;
	}

	public void setStatus(TransactionStatus status) {
		this.status = status;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public ErrorReasonCode getReasonCode() {
		return reasonCode;
	}

	public void setReasonCode(ErrorReasonCode reasonCode) {
		this.reasonCode = reasonCode;
	}

	@Override
	public String toString() {
		return "PaymentRejectedResponse [status=" + status + ", reason=" + reason + ", reasonCode=" + reasonCode + "]";
	}

}
