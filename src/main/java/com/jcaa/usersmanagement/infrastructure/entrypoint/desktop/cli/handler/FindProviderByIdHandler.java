package com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.cli.handler;

import com.jcaa.usersmanagement.domain.model.ProviderModel;
import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.cli.io.ConsoleIO;
import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.controller.ProviderController;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class FindProviderByIdHandler implements OperationHandler {

    private final ProviderController providerController;
    private final ConsoleIO console;

    @Override
    public void handle() {
        final String id = console.readRequired("  Enter Provider ID: ");
        final ProviderModel p = providerController.findProviderById(id);
        console.println(String.format("  Found -> ID: %s | NIT: %s | Name: %s | Email: %s | Phone: %s | Address: %s | Status: %s",
                p.getId().value(), p.getNit().value(), p.getName().value(),
                p.getEmail().value(), p.getPhone().value(), p.getAddress().value(), p.getStatus()));
    }
}