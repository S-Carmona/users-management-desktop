package com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.cli.handler;

import com.jcaa.usersmanagement.application.service.dto.command.UpdateProviderCommand;
import com.jcaa.usersmanagement.domain.model.ProviderModel;
import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.cli.io.ConsoleIO;
import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.controller.ProviderController;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class UpdateProviderHandler implements OperationHandler {

    private final ProviderController providerController;
    private final ConsoleIO console;

    @Override
    public void handle() {
        final String id = console.readRequired("  Provider ID to update: ");
        console.println("  (Leave blank to keep current value)");
        final String nit = console.readOptional("  New NIT: ");
        final String name = console.readOptional("  New Name: ");
        final String email = console.readOptional("  New Email: ");
        final String phone = console.readOptional("  New Phone: ");
        final String address = console.readOptional("  New Address: ");
        final String status = console.readOptional("  New Status (ACTIVE / INACTIVE): ");

        final ProviderModel updated = providerController.updateProvider(
                new UpdateProviderCommand(id, nit, name, email, phone, address, status));
        console.println("  Provider updated successfully! Name: " + updated.getName().value());
    }
}