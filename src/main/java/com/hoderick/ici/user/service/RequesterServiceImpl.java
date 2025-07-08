package com.hoderick.ici.user.service;

import com.hoderick.ici.user.domain.model.Requester;
import com.hoderick.ici.user.domain.repository.RequesterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RequesterServiceImpl implements RequesterService {

    private final RequesterRepository repository;

    @Override
    public Requester createRequester(Requester requester) {
        return repository.save(requester);
    }
}
