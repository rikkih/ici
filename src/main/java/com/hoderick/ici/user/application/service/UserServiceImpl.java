package com.hoderick.ici.user.application.service;

import com.hoderick.ici.user.application.dto.UserDto;
import com.hoderick.ici.user.application.mapper.UserMapper;
import com.hoderick.ici.user.domain.model.User;
import com.hoderick.ici.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements InternalUserService, UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDto getUserById(UUID id) {
        return userMapper.toDto(findUserOrThrow(id));
    }

    @Override
    public User getUserEntityById(UUID id) {
        return findUserOrThrow(id);
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(UUID id) {
    }

    private User findUserOrThrow(UUID id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No user found for id " + id));
    }
}
