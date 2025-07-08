package com.hoderick.ici.user.domain.repository;

import com.hoderick.ici.user.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
