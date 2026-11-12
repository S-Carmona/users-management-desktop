package com.jcaa.usersmanagement.application.service.dto.command;

public record UpdateProviderCommand(String id, String nit, String name, String email, String phone, String address, String status) {}