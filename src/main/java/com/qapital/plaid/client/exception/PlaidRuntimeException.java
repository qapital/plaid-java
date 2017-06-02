package com.qapital.plaid.client.exception;

public class PlaidRuntimeException extends RuntimeException {

    public PlaidRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public PlaidRuntimeException(String message) {
        super(message);
    }

    public PlaidRuntimeException(Throwable cause) {
        super(cause);
    }

    public PlaidRuntimeException() {
        super();
    }
}
