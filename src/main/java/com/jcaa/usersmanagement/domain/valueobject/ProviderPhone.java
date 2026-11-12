package com.jcaa.usersmanagement.domain.valueobject;

import com.jcaa.usersmanagement.domain.exception.InvalidProviderDataException;
import java.util.Objects;

public record ProviderPhone(String value) {
    public ProviderPhone {
        final String normalized = Objects.requireNonNull(value, "Provider phone cannot be null").trim();
        if (normalized.length() < 7) {
            throw new InvalidProviderDataException("Provider phone must have at least 7 characters.");
        }
        value = normalized;
    }
}