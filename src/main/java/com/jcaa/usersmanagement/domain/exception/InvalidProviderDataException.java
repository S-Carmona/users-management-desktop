package com.jcaa.usersmanagement.domain.exception;

public final class InvalidProviderDataException extends RuntimeException {
    public InvalidProviderDataException(final String message) {
        super(message);
    }
}