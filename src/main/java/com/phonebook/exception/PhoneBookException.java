package com.phonebook.exception;

/**
 * Custom PhoneBookException class
 *
 * @author Ram Niwash
 * @since 1.0.0
 */
public class PhoneBookException extends Exception {

    public PhoneBookException() {
    }

    public PhoneBookException(String message) {
        super(message);
    }

    public PhoneBookException(String message, Throwable cause) {
        super(message, cause);
    }

    public PhoneBookException(Throwable cause) {
        super(cause);
    }

    public PhoneBookException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
