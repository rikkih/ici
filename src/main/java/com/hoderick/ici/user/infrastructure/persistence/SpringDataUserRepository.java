package com.hoderick.ici.user.infrastructure.persistence;

import com.hoderick.ici.user.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

interface SpringDataUserRepository extends JpaRepository<User, UUID> {
}
