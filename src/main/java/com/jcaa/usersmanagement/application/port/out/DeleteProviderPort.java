package com.jcaa.usersmanagement.application.port.out;

import com.jcaa.usersmanagement.domain.valueobject.ProviderId;

public interface DeleteProviderPort {
    void deleteById(ProviderId id);
}