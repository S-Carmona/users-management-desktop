package com.jcaa.usersmanagement.domain.valueobject;

import com.jcaa.usersmanagement.domain.exception.InvalidProviderDataException;
import java.util.Objects;

public record ProviderEmail(String value) {
    public ProviderEmail {
        final String normalized = Objects.requireNonNull(value, "Provider email cannot be null").trim().toLowerCase();
        if (!normalized.contains("@") || !normalized.contains(".")) {
            throw new InvalidProviderDataException("Invalid provider email format.");
        }
        value = normalized;
    }
}