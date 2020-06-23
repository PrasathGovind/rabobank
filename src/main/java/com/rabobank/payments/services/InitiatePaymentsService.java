package com.rabobank.payments.services;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rabobank.payments.advices.exceptions.APIException;
import com.rabobank.payments.beans.enums.ErrorReasonCode;
import com.rabobank.payments.beans.enums.TransactionStatus;
import com.rabobank.payments.beans.requests.PaymentInitiationRequest;
import com.rabobank.payments.beans.responses.PaymentAcceptedResponse;
import com.rabobank.payments.beans.responses.PaymentsResponse;
import com.rabobank.payments.utils.PaymentsUtils;

@Service
public class InitiatePaymentsService {
	
	@Autowired
	PaymentsUtils paymentsUtils;
	
	public PaymentsResponse initiatePayments(PaymentInitiationRequest paymentInitiationRequest) {
		
		BigDecimal amount = getAmount(paymentInitiationRequest.getAmount());
		Long sumOfDigitsInDebtorAccountIBAN = getSumOfDebtorAccountIBAN(paymentInitiationRequest.getDebtorIBAN());
		Long lenghtOfDigitsInDebtorAccountIBAN = getLengthOfDebtorAccountIBAN(paymentInitiationRequest.getDebtorIBAN());
		
		boolean isLimitEceededError = isLimitExceededError(amount, sumOfDigitsInDebtorAccountIBAN, lenghtOfDigitsInDebtorAccountIBAN);
		
		if(isLimitEceededError) {
			throw new APIException(ErrorReasonCode.LIMIT_EXCEEDED);
		}

		PaymentAcceptedResponse paymentAcceptedResponse = new PaymentAcceptedResponse();
		paymentAcceptedResponse.setPaymentId(paymentsUtils.generateUUID());
		paymentAcceptedResponse.setStatus(TransactionStatus.Accepted);
		return paymentAcceptedResponse;
		
	}
	
	public boolean isLimitExceededError(BigDecimal amount, Long sumOfDigitsInDebtorAccountIBAN, Long lenghtOfDigitsInDebtorAccountIBAN) {
		return amount.compareTo(BigDecimal.ZERO) > 0 && (sumOfDigitsInDebtorAccountIBAN.longValue() % lenghtOfDigitsInDebtorAccountIBAN.longValue() == 0);
	}
	
	public BigDecimal getAmount(String amountStr) {
		
		if(amountStr==null)
			return null;
	
		return new BigDecimal(String.valueOf(amountStr));
	}
	
	public Long getSumOfDebtorAccountIBAN(String debtorAccountIBAN) {
		
		if(debtorAccountIBAN==null)
			return null;
		
		char[] digits = debtorAccountIBAN.trim().toUpperCase().toCharArray();
		long sumOfDigits = 0;
		for(int i=0 ; digits!=null && i<=digits.length-1 ; i++) {
			if(digits[i]-48 >=0 && digits[i]-48 <= 9) {
				sumOfDigits = sumOfDigits+digits[i]-48;
			}	
		}
		
		return new Long(sumOfDigits);
	}
	
	public Long getLengthOfDebtorAccountIBAN(String debtorAccountIBAN) {
		
		if(debtorAccountIBAN==null)
			return null;
		
		return new Long(debtorAccountIBAN.length());
	}
	
	
}
