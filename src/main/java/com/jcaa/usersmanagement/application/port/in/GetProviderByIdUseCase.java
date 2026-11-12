package com.jcaa.usersmanagement.application.port.in;

import com.jcaa.usersmanagement.domain.model.ProviderModel;

public interface GetProviderByIdUseCase {
    ProviderModel execute(String id);
}