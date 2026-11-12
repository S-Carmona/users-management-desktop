package com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.controller;

import com.jcaa.usersmanagement.application.port.in.*;
import com.jcaa.usersmanagement.application.service.dto.command.CreateProviderCommand;
import com.jcaa.usersmanagement.application.service.dto.command.UpdateProviderCommand;
import com.jcaa.usersmanagement.domain.model.ProviderModel;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public final class ProviderController {

    private final CreateProviderUseCase createProviderUseCase;
    private final UpdateProviderUseCase updateProviderUseCase;
    private final DeleteProviderUseCase deleteProviderUseCase;
    private final GetProviderByIdUseCase getProviderByIdUseCase;
    private final GetAllProvidersUseCase getAllProvidersUseCase;

    public List<ProviderModel> listAllProviders() {
        return getAllProvidersUseCase.execute();
    }

    public ProviderModel findProviderById(final String id) {
        return getProviderByIdUseCase.execute(id);
    }

    public ProviderModel createProvider(final CreateProviderCommand command) {
        return createProviderUseCase.execute(command);
    }

    public ProviderModel updateProvider(final UpdateProviderCommand command) {
        return updateProviderUseCase.execute(command);
    }

    public void deleteProvider(final String id) {
        deleteProviderUseCase.execute(id);
    }
}