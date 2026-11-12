package com.jcaa.usersmanagement.application.port.in;

import com.jcaa.usersmanagement.application.service.dto.command.UpdateProviderCommand;
import com.jcaa.usersmanagement.domain.model.ProviderModel;

public interface UpdateProviderUseCase {
    ProviderModel execute(UpdateProviderCommand command);
}