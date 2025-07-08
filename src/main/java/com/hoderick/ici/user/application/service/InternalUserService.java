package com.hoderick.ici.user.application.service;

import com.hoderick.ici.user.domain.model.User;

import java.util.UUID;

public interface InternalUserService {
    User createUser(User user);
    User getUserEntityById(UUID id);
    void deleteUser(UUID id);
}
