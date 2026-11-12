package com.jcaa.usersmanagement.application.port.in;

import com.jcaa.usersmanagement.application.service.dto.command.CreateProviderCommand;
import com.jcaa.usersmanagement.domain.model.ProviderModel;

public interface CreateProviderUseCase {
    ProviderModel execute(CreateProviderCommand command);
}