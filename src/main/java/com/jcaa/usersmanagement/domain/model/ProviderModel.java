package com.jcaa.usersmanagement.domain.model;

import com.jcaa.usersmanagement.domain.enums.ProviderStatus;
import com.jcaa.usersmanagement.domain.valueobject.*;
import lombok.Value;

@Value
public class ProviderModel {
    ProviderId id;
    ProviderNit nit;
    ProviderName name;
    ProviderEmail email;
    ProviderPhone phone;
    ProviderAddress address;
    ProviderStatus status;

    public static ProviderModel create(
            final ProviderId id,
            final ProviderNit nit,
            final ProviderName name,
            final ProviderEmail email,
            final ProviderPhone phone,
            final ProviderAddress address) {
        return new ProviderModel(id, nit, name, email, phone, address, ProviderStatus.ACTIVE);
    }
}