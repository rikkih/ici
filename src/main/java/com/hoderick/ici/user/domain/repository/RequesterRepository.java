package com.hoderick.ici.user.domain.repository;

import com.hoderick.ici.user.domain.model.Requester;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RequesterRepository extends JpaRepository<Requester, UUID> {
}
