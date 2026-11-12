package com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.cli.handler;

import com.jcaa.usersmanagement.domain.model.ProviderModel;
import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.cli.io.ConsoleIO;
import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.controller.ProviderController;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public final class ListProvidersHandler implements OperationHandler {

    private final ProviderController providerController;
    private final ConsoleIO console;

    @Override
    public void handle() {
        final List<ProviderModel> providers = providerController.listAllProviders();
        if (providers.isEmpty()) {
            console.println("  No providers registered.");
            return;
        }
        console.println("\n  --- Providers List (CEA 8 - Educando S.A.) ---");
        for (final ProviderModel p : providers) {
            console.println(String.format("  ID: %s | NIT: %s | Name: %s | Email: %s | Phone: %s | Address: %s | Status: %s",
                    p.getId().value(), p.getNit().value(), p.getName().value(),
                    p.getEmail().value(), p.getPhone().value(), p.getAddress().value(), p.getStatus()));
        }
    }
}