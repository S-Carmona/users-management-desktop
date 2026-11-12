package com.jcaa.usersmanagement.domain.valueobject;

import com.jcaa.usersmanagement.domain.exception.InvalidProviderDataException;
import java.util.Objects;

public record ProviderAddress(String value) {
    public ProviderAddress {
        final String normalized = Objects.requireNonNull(value, "Provider address cannot be null").trim();
        if (normalized.length() < 5) {
            throw new InvalidProviderDataException("Provider address must have at least 5 characters.");
        }
        value = normalized;
    }
}