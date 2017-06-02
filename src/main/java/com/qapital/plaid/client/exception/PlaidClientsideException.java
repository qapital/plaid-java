package com.qapital.plaid.client.exception;

public class PlaidClientsideException extends PlaidRuntimeException {

    public PlaidClientsideException(String message, Throwable cause) {
        super(message, cause);
    }

    public PlaidClientsideException(String message) {
        super(message);
    }

    public PlaidClientsideException(Throwable cause) {
        super(cause);
    }

}
