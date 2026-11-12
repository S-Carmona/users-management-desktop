package com.jcaa.usersmanagement.application.service;

import com.jcaa.usersmanagement.application.port.in.DeleteProviderUseCase;
import com.jcaa.usersmanagement.application.port.out.DeleteProviderPort;
import com.jcaa.usersmanagement.application.port.out.GetProviderByIdPort;
import com.jcaa.usersmanagement.domain.exception.ProviderNotFoundException;
import com.jcaa.usersmanagement.domain.valueobject.ProviderId;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class DeleteProviderService implements DeleteProviderUseCase {

    private final GetProviderByIdPort getProviderByIdPort;
    private final DeleteProviderPort deleteProviderPort;

    @Override
    public void execute(final String id) {
        final ProviderId providerId = new ProviderId(id);
        if (getProviderByIdPort.getById(providerId).isEmpty()) {
            throw ProviderNotFoundException.becauseIdWasNotFound(id);
        }
        deleteProviderPort.deleteById(providerId);
    }
}