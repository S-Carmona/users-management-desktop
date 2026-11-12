package com.jcaa.usersmanagement.application.port.out;

import com.jcaa.usersmanagement.domain.model.ProviderModel;

public interface UpdateProviderPort {
    ProviderModel update(ProviderModel provider);
}