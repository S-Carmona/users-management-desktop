package com.jcaa.usersmanagement.application.port.out;

import com.jcaa.usersmanagement.domain.model.ProviderModel;

public interface SaveProviderPort {
    ProviderModel save(ProviderModel provider);
}