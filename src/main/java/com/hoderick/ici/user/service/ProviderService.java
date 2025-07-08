package com.hoderick.ici.user.service;

import com.hoderick.ici.user.domain.model.Provider;
import org.springframework.modulith.NamedInterface;

import java.util.UUID;

@NamedInterface
public interface ProviderService {
    Provider createProvider(Provider provider);
    boolean isValidProvider(UUID id);
}
