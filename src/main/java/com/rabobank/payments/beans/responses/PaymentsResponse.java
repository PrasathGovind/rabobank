package com.rabobank.payments.beans.responses;

import java.io.Serializable;

import com.rabobank.payments.beans.enums.TransactionStatus;

public class PaymentsResponse implements Serializable{
	
	private static final long serialVersionUID = -5475526797203395987L;

	String paymentId;
	
	TransactionStatus status;
	
	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public TransactionStatus getStatus() {
		return status;
	}

	public void setStatus(TransactionStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "PaymentsResponse [paymentId=" + paymentId + ", status=" + status + "]";
	}

}
