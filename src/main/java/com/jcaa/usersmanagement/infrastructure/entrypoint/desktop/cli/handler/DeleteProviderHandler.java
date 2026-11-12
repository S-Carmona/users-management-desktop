package com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.cli.handler;

import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.cli.io.ConsoleIO;
import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.controller.ProviderController;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class DeleteProviderHandler implements OperationHandler {

    private final ProviderController providerController;
    private final ConsoleIO console;

    @Override
    public void handle() {
        final String id = console.readRequired("  Provider ID to delete: ");
        providerController.deleteProvider(id);
        console.println("  Provider deleted successfully!");
    }
}