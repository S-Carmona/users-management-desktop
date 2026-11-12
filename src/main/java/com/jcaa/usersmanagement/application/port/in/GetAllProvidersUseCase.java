package com.jcaa.usersmanagement.application.port.in;

import com.jcaa.usersmanagement.domain.model.ProviderModel;
import java.util.List;

public interface GetAllProvidersUseCase {
    List<ProviderModel> execute();
}