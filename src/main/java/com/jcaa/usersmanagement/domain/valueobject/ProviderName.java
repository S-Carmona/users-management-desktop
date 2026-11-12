package com.jcaa.usersmanagement.domain.valueobject;

import com.jcaa.usersmanagement.domain.exception.InvalidProviderDataException;
import java.util.Objects;

public record ProviderName(String value) {
    public ProviderName {
        final String normalized = Objects.requireNonNull(value, "Provider name cannot be null").trim();
        if (normalized.length() < 3) {
            throw new InvalidProviderDataException("Provider name must have at least 3 characters.");
        }
        value = normalized;
    }
}