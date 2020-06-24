package com.rabobank.payments.validators;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import org.springframework.stereotype.Component;

import com.rabobank.payments.advices.exceptions.APIException;
import com.rabobank.payments.beans.enums.ErrorReasonCode;
import com.rabobank.payments.beans.requests.PaymentInitiationRequest;


@Component
public class RabobankSignatureValidatorEngine {
	
	
	String publicKeyB64;
	
	String signatureB64;
	
	String requestId;
	
	PaymentInitiationRequest paymentInitiationRequest;
	
	
	public boolean isSignatureValid() {
		
		boolean isSignatureValid = true;
		
		try {
			
			// Use Public Key and create an instance of Signature Validator
			byte[] base64Encoded = Base64.getEncoder().encode(publicKeyB64.getBytes());
			byte[] encPublicKey = Base64.getDecoder().decode(base64Encoded);
			
			X509EncodedKeySpec pubKeySpec = new X509EncodedKeySpec(encPublicKey);
			KeyFactory keyFactory = KeyFactory.getInstance("DSA");
			PublicKey pubKey = keyFactory.generatePublic(pubKeySpec);
			
			Signature signature = Signature.getInstance("SHA256WithRSA");
			signature.initVerify(pubKey);
			
			// Merge the requestID and requestBody into single array of Bytes
			byte[] amalgamatedRequestIdAndRequestBody = amalagamateRequestIdAndRequestBody(requestId, paymentInitiationRequest);
			
			InputStream is = new ByteArrayInputStream(amalgamatedRequestIdAndRequestBody);
			BufferedInputStream bufin = new BufferedInputStream(is);
			
			// Update the Signature Validator with merged Data
			byte[] buffer = new byte[1024];
			int len;
			while (bufin.available() != 0) {
			    len = bufin.read(buffer);
			    signature.update(buffer, 0, len);
			};
			bufin.close();
			
			// Verify the signature from the request using Signature Validator
			byte[] base64EncodedSignature = Base64.getEncoder().encode(signatureB64.getBytes());
			byte[] sigToVerify = Base64.getDecoder().decode(base64EncodedSignature);
			
			boolean verifies = signature.verify(sigToVerify);

			isSignatureValid = verifies;
		}
		catch(Exception ex) {
			//throw new APIException(ErrorReasonCode.INVALID_SIGNATURE);
		}
		
		return isSignatureValid;
	}
		
	public byte[] amalagamateRequestIdAndRequestBody(String requestId,PaymentInitiationRequest paymentInitiationRequest) {
		
		byte[] amalgamatedRequestIdAndRequestBody = null;
		
		byte[] requestIdByteArray = requestId.getBytes();
		
		byte[] requestByteArray = convertRequestToByteArray(paymentInitiationRequest);
		
		byte[] sha256HashOfRequestByteArray = getSHA256HashDigestOfRequest(requestByteArray);
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		try {
			
			baos.write(requestIdByteArray);
			baos.write(sha256HashOfRequestByteArray);
			
			amalgamatedRequestIdAndRequestBody = baos.toByteArray();
			
		} catch (IOException e) {
			throw new APIException(ErrorReasonCode.GENERAL_ERROR);
		}
		
		return amalgamatedRequestIdAndRequestBody;
	}
	
	public byte[] convertRequestToByteArray(PaymentInitiationRequest paymentInitiationRequest) {
		
		byte[] requestBytes = null;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try {
			
			ObjectOutputStream out = null;
			out = new ObjectOutputStream(bos);   
			out.writeObject(paymentInitiationRequest);
			
			out.flush();
			requestBytes = bos.toByteArray();
			
		} catch (IOException e) {
			throw new APIException(ErrorReasonCode.GENERAL_ERROR);
		} finally {
		  try {
		    bos.close();
		  } catch (IOException ex) {
			  throw new APIException(ErrorReasonCode.GENERAL_ERROR);
		  }
		}
		
		return requestBytes;
	}

	public byte[] getSHA256HashDigestOfRequest(byte[] requestBytes) {
		
		byte[] sha256HashDigest = null;
		
		try {
			
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
			sha256HashDigest = messageDigest.digest(requestBytes);
			
		} catch (Exception e) {
			
			throw new APIException(ErrorReasonCode.GENERAL_ERROR);
		}
		
		return sha256HashDigest;
	}

	public String getPublicKeyB64() {
		return publicKeyB64;
	}

	public void setPublicKeyB64(String publicKeyB64) {
		this.publicKeyB64 = publicKeyB64;
	}

	public String getSignatureB64() {
		return signatureB64;
	}

	public void setSignatureB64(String signatureB64) {
		this.signatureB64 = signatureB64;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public PaymentInitiationRequest getPaymentInitiationRequest() {
		return paymentInitiationRequest;
	}

	public void setPaymentInitiationRequest(PaymentInitiationRequest paymentInitiationRequest) {
		this.paymentInitiationRequest = paymentInitiationRequest;
	}

}
