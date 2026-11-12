package com.jcaa.usersmanagement.application.service;

import com.jcaa.usersmanagement.application.port.in.UpdateProviderUseCase;
import com.jcaa.usersmanagement.application.port.out.GetProviderByIdPort;
import com.jcaa.usersmanagement.application.port.out.UpdateProviderPort;
import com.jcaa.usersmanagement.application.service.dto.command.UpdateProviderCommand;
import com.jcaa.usersmanagement.domain.enums.ProviderStatus;
import com.jcaa.usersmanagement.domain.exception.ProviderNotFoundException;
import com.jcaa.usersmanagement.domain.model.ProviderModel;
import com.jcaa.usersmanagement.domain.valueobject.*;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class UpdateProviderService implements UpdateProviderUseCase {

    private final GetProviderByIdPort getProviderByIdPort;
    private final UpdateProviderPort updateProviderPort;

    @Override
    public ProviderModel execute(final UpdateProviderCommand command) {
        final ProviderId providerId = new ProviderId(command.id());
        final ProviderModel existing = getProviderByIdPort.getById(providerId)
                .orElseThrow(() -> ProviderNotFoundException.becauseIdWasNotFound(command.id()));

        final ProviderNit nit = (command.nit() == null || command.nit().isBlank())
                ? existing.getNit() : new ProviderNit(command.nit());
        final ProviderName name = (command.name() == null || command.name().isBlank())
                ? existing.getName() : new ProviderName(command.name());
        final ProviderEmail email = (command.email() == null || command.email().isBlank())
                ? existing.getEmail() : new ProviderEmail(command.email());
        final ProviderPhone phone = (command.phone() == null || command.phone().isBlank())
                ? existing.getPhone() : new ProviderPhone(command.phone());
        final ProviderAddress address = (command.address() == null || command.address().isBlank())
                ? existing.getAddress() : new ProviderAddress(command.address());
        final ProviderStatus status = (command.status() == null || command.status().isBlank())
                ? existing.getStatus() : ProviderStatus.valueOf(command.status().trim().toUpperCase());

        final ProviderModel updated = new ProviderModel(providerId, nit, name, email, phone, address, status);
        return updateProviderPort.update(updated);
    }
}