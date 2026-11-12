package com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.cli.menu;

import java.util.Optional;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MenuOption {

  LIST_USERS(1, "List all users"),
    FIND_USER(2, "Find user by ID"),
    CREATE_USER(3, "Create user"),
    UPDATE_USER(4, "Update user"),
    DELETE_USER(5, "Delete user"),
    LOGIN(6, "Login"),
    LIST_PROVIDERS(7, "List all providers (CEA 8)"),
    FIND_PROVIDER(8, "Find provider by ID"),
    CREATE_PROVIDER(9, "Create provider"),
    UPDATE_PROVIDER(10, "Update provider"),
    DELETE_PROVIDER(11, "Delete provider"),
    EXIT(0, "Exit");

  private final int number;
  private final String description;

  public static Optional<MenuOption> fromNumber(final int number) {
    for (final MenuOption option : values()) {
      if (option.number == number) {
        return Optional.of(option);
      }
    }
    return Optional.empty();
  }
}

