package com.jcaa.usersmanagement.application.port.out;

import com.jcaa.usersmanagement.domain.model.ProviderModel;
import com.jcaa.usersmanagement.domain.valueobject.ProviderId;
import java.util.Optional;

public interface GetProviderByIdPort {
    Optional<ProviderModel> getById(ProviderId id);
}