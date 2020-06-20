package com.rabobank.payments.beans.requests;

import java.io.Serializable;

public class PaymentInitiationRequest implements Serializable{
	
	private static final long serialVersionUID = -1197324722162982591L;

	String debtorIBAN;
	
	String creditorIBAN;
	
	String amount;
	
	String currency;
	
	String endToEndId;

	public String getDebtorIBAN() {
		return debtorIBAN;
	}

	public void setDebtorIBAN(String debtorIBAN) {
		this.debtorIBAN = debtorIBAN;
	}

	public String getCreditorIBAN() {
		return creditorIBAN;
	}

	public void setCreditorIBAN(String creditorIBAN) {
		this.creditorIBAN = creditorIBAN;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getEndToEndId() {
		return endToEndId;
	}

	public void setEndToEndId(String endToEndId) {
		this.endToEndId = endToEndId;
	}

	@Override
	public String toString() {
		return "PaymentInitiationRequest [debtorIBAN=" + debtorIBAN + ", creditorIBAN=" + creditorIBAN + ", amount="
				+ amount + ", currency=" + currency + ", endToEndId=" + endToEndId + "]";
	}
	
	

}
