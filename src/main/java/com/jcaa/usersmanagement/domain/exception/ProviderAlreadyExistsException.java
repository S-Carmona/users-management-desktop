package com.jcaa.usersmanagement.domain.exception;

public final class ProviderAlreadyExistsException extends RuntimeException {
    private ProviderAlreadyExistsException(final String message) {
        super(message);
    }

    public static ProviderAlreadyExistsException becauseNitAlreadyExists(final String nit) {
        return new ProviderAlreadyExistsException("Provider with NIT '" + nit + "' already exists.");
    }
}