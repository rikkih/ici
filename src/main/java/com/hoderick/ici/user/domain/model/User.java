package com.hoderick.ici.user.domain.model;

import lombok.Getter;

import java.util.UUID;

@Getter
public class User {

    private UUID id;
    private final String name;
    private final String email;
    private final UserType type;

    public User(String name, String email, UserType type) {
        this.name = name;
        this.email = email;
        this.type = type;
    }

    // Package-private constructor including id — for persistence and tests only
    User(UUID id, String name, String email, UserType type) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.type = type;
    }

}
