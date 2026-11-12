package com.jcaa.usersmanagement.application.port.out;

import com.jcaa.usersmanagement.domain.model.ProviderModel;
import com.jcaa.usersmanagement.domain.valueobject.ProviderNit;
import java.util.Optional;

public interface GetProviderByNitPort {
    Optional<ProviderModel> getByNit(ProviderNit nit);
}