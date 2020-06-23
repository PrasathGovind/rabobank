package com.rabobank.payments.beans.responses;

import java.io.Serializable;

import com.rabobank.payments.beans.enums.TransactionStatus;

public class PaymentAcceptedResponse extends PaymentsResponse implements Serializable{
	
	private static final long serialVersionUID = 5179601411449992519L;

	TransactionStatus status;

	public TransactionStatus getStatus() {
		return status;
	}

	public void setStatus(TransactionStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "PaymentAcceptedResponse [status=" + status + "]";
	}

}
