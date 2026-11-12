package com.jcaa.usersmanagement.application.service;

import com.jcaa.usersmanagement.application.port.in.GetProviderByIdUseCase;
import com.jcaa.usersmanagement.application.port.out.GetProviderByIdPort;
import com.jcaa.usersmanagement.domain.exception.ProviderNotFoundException;
import com.jcaa.usersmanagement.domain.model.ProviderModel;
import com.jcaa.usersmanagement.domain.valueobject.ProviderId;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class GetProviderByIdService implements GetProviderByIdUseCase {

    private final GetProviderByIdPort getProviderByIdPort;

    @Override
    public ProviderModel execute(final String id) {
        final ProviderId providerId = new ProviderId(id);
        return getProviderByIdPort.getById(providerId)
                .orElseThrow(() -> ProviderNotFoundException.becauseIdWasNotFound(id));
    }
}