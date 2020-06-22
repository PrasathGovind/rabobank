package com.rabobank.payments.beans.responses;

import java.io.Serializable;

import com.rabobank.payments.beans.enums.TransactionStatus;

public class PaymentAcceptedResponse extends PaymentsResponse implements Serializable{
	
	private static final long serialVersionUID = 5179601411449992519L;

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
		return "PaymentAcceptedResponse [paymentId=" + paymentId + ", status=" + status + "]";
	}

}
