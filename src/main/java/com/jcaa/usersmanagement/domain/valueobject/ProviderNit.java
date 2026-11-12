package com.jcaa.usersmanagement.domain.valueobject;

import com.jcaa.usersmanagement.domain.exception.InvalidProviderDataException;
import java.util.Objects;

public record ProviderNit(String value) {
    public ProviderNit {
        final String normalized = Objects.requireNonNull(value, "Provider NIT cannot be null").trim();
        if (normalized.length() < 5) {
            throw new InvalidProviderDataException("Provider NIT must have at least 5 characters.");
        }
        value = normalized;
    }
}