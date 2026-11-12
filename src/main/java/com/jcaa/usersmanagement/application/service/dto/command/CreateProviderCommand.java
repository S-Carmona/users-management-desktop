package com.jcaa.usersmanagement.application.service.dto.command;

public record CreateProviderCommand(String nit, String name, String email, String phone, String address) {}