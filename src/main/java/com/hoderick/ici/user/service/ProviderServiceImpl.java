package com.hoderick.ici.user.service;

import com.hoderick.ici.user.domain.model.Provider;
import com.hoderick.ici.user.domain.repository.ProviderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProviderServiceImpl implements ProviderService {

    private final ProviderRepository providerRepository;

    @Override
    public Provider createProvider(Provider provider) {
        return providerRepository.save(provider);
    }

    @Override
    public boolean isValidProvider(UUID id) {
        return providerRepository.existsById(id);
    }
}
