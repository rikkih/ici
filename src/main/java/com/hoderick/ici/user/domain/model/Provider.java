package com.hoderick.ici.user.domain.model;

import com.hoderick.ici.common.Auditable;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.UUID;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Provider extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne
    private User user;

    @Enumerated(EnumType.STRING)
    private ProviderStatus status;

    public Provider(User user) {
        this.user = Objects.requireNonNull(user);
        this.status = ProviderStatus.ACTIVE;
    }

}
