package com.rabobank.payments.beans.responses;

import java.io.Serializable;

public class PaymentsResponse implements Serializable{
	
	private static final long serialVersionUID = -5475526797203395987L;
	
	String paymentId;
	
	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	@Override
	public String toString() {
		return "PaymentsResponse [paymentId=" + paymentId + "]";
	}

}
