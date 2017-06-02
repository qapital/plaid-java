package com.qapital.plaid.client.exception;

import com.qapital.plaid.client.response.ErrorResponse;

public class PlaidServersideException extends PlaidRuntimeException {
    
    private ErrorResponse errorResponse;
    private int httpStatusCode;
    
    public PlaidServersideException(ErrorResponse errorResponse, int httpStatusCode) {
        super(String.format("%s: %s", httpStatusCode, errorResponse != null ? errorResponse.getMessage() : null));
        this.errorResponse = errorResponse;
        this.httpStatusCode = httpStatusCode;
    }

    public ErrorResponse getErrorResponse() {
        return errorResponse;
    }
    
    public int getHttpStatusCode() {
		return httpStatusCode;
	}
    
}