package com.hoderick.ici.user.infrastructure.persistence;

import com.hoderick.ici.user.domain.model.User;
import com.hoderick.ici.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
class JpaUserRepository implements UserRepository {

    private final SpringDataUserRepository springDataUserRepository;

    @Override
    public Optional<User> findById(UUID id) {
        return springDataUserRepository.findById(id);
    }

    @Override
    public User save(User user) {
        return springDataUserRepository.save(user);
    }

}
