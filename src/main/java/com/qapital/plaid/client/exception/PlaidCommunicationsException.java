package com.qapital.plaid.client.exception;

public class PlaidCommunicationsException extends PlaidRuntimeException {

    public PlaidCommunicationsException(String message, Throwable cause) {
        super(message, cause);
    }

    public PlaidCommunicationsException(String message) {
        super(message);
    }

    public PlaidCommunicationsException(Throwable cause) {
        super(cause);
    }
    
}
