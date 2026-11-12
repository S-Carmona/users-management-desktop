package com.jcaa.usersmanagement.domain.exception;

public final class ProviderNotFoundException extends RuntimeException {
    private ProviderNotFoundException(final String message) {
        super(message);
    }

    public static ProviderNotFoundException becauseIdWasNotFound(final String id) {
        return new ProviderNotFoundException("Provider with ID '" + id + "' was not found.");
    }
}