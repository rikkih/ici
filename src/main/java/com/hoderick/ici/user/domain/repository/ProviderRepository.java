package com.hoderick.ici.user.domain.repository;

import com.hoderick.ici.user.domain.model.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProviderRepository extends JpaRepository<Provider, UUID> {
}
