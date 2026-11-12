package com.jcaa.usersmanagement.application.port.out;

import com.jcaa.usersmanagement.domain.model.ProviderModel;
import java.util.List;

public interface GetAllProvidersPort {
    List<ProviderModel> getAll();
}