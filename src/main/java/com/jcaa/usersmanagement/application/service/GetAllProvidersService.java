package com.jcaa.usersmanagement.application.service;

import com.jcaa.usersmanagement.application.port.in.GetAllProvidersUseCase;
import com.jcaa.usersmanagement.application.port.out.GetAllProvidersPort;
import com.jcaa.usersmanagement.domain.model.ProviderModel;
import lombok.RequiredArgsConstructor;
import java.util.List;

@RequiredArgsConstructor
public final class GetAllProvidersService implements GetAllProvidersUseCase {

    private final GetAllProvidersPort getAllProvidersPort;

    @Override
    public List<ProviderModel> execute() {
        return getAllProvidersPort.getAll();
    }
}