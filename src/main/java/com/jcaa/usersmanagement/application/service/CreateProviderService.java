package com.jcaa.usersmanagement.application.service;

import com.jcaa.usersmanagement.application.port.in.CreateProviderUseCase;
import com.jcaa.usersmanagement.application.port.out.GetProviderByNitPort;
import com.jcaa.usersmanagement.application.port.out.SaveProviderPort;
import com.jcaa.usersmanagement.application.service.dto.command.CreateProviderCommand;
import com.jcaa.usersmanagement.domain.exception.ProviderAlreadyExistsException;
import com.jcaa.usersmanagement.domain.model.ProviderModel;
import com.jcaa.usersmanagement.domain.valueobject.*;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class CreateProviderService implements CreateProviderUseCase {

    private final SaveProviderPort saveProviderPort;
    private final GetProviderByNitPort getProviderByNitPort;

    @Override
    public ProviderModel execute(final CreateProviderCommand command) {
        final ProviderNit nit = new ProviderNit(command.nit());
        if (getProviderByNitPort.getByNit(nit).isPresent()) {
            throw ProviderAlreadyExistsException.becauseNitAlreadyExists(nit.value());
        }
        final ProviderModel provider = ProviderModel.create(
                ProviderId.generate(),
                nit,
                new ProviderName(command.name()),
                new ProviderEmail(command.email()),
                new ProviderPhone(command.phone()),
                new ProviderAddress(command.address())
        );
        return saveProviderPort.save(provider);
    }
}