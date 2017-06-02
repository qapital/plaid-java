package com.qapital.plaid.client.exception;

import com.qapital.plaid.client.response.MfaResponse;

public class PlaidMfaException extends PlaidRuntimeException {

    private MfaResponse mfaResponse;
    private int httpStatusCode;

    public PlaidMfaException(MfaResponse mfaResponse, int httpStatusCode) {
        super();
        this.mfaResponse = mfaResponse;
        this.httpStatusCode = httpStatusCode;
    }

    public MfaResponse getMfaResponse() {
        return mfaResponse;
    }
    
    public int getHttpStatusCode() {
		return httpStatusCode;
	}
}
