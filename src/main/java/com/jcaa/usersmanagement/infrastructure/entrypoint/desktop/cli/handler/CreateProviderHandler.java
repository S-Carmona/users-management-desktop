package com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.cli.handler;

import com.jcaa.usersmanagement.application.service.dto.command.CreateProviderCommand;
import com.jcaa.usersmanagement.domain.model.ProviderModel;
import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.cli.io.ConsoleIO;
import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.controller.ProviderController;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class CreateProviderHandler implements OperationHandler {

    private final ProviderController providerController;
    private final ConsoleIO console;

    @Override
    public void handle() {
        final String nit = console.readRequired("  NIT: ");
        final String name = console.readRequired("  Name: ");
        final String email = console.readRequired("  Email: ");
        final String phone = console.readRequired("  Phone: ");
        final String address = console.readRequired("  Address: ");

        final ProviderModel created = providerController.createProvider(
                new CreateProviderCommand(nit, name, email, phone, address));
        console.println("  Provider created successfully! ID: " + created.getId().value());
    }
}