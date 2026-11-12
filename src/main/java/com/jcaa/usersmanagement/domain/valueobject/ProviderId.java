package com.jcaa.usersmanagement.domain.valueobject;

import com.jcaa.usersmanagement.domain.exception.InvalidProviderDataException;
import java.util.Objects;
import java.util.UUID;

public record ProviderId(String value) {
    public ProviderId {
        final String normalized = Objects.requireNonNull(value, "ProviderId cannot be null").trim();
        if (normalized.isEmpty()) {
            throw new InvalidProviderDataException("ProviderId cannot be empty.");
        }
        value = normalized;
    }

    public static ProviderId generate() {
        return new ProviderId(UUID.randomUUID().toString());
    }
}