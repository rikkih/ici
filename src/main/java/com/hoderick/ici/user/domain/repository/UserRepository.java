package com.hoderick.ici.user.domain.repository;

import com.hoderick.ici.user.domain.model.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
    User save(User user);
    Optional<User> findById(UUID id);
}
