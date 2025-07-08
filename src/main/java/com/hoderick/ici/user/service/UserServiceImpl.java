package com.hoderick.ici.user.service;

import com.hoderick.ici.user.domain.model.User;
import com.hoderick.ici.user.domain.model.UserType;
import com.hoderick.ici.user.domain.repository.UserRepository;
import com.hoderick.ici.user.dto.UserDto;
import com.hoderick.ici.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    @Transactional
    public UserDto createUser(UserDto dto) {
        User user = userMapper.fromDto(dto);
        user = userRepository.save(user);

        UserType userType = dto.userType();
        switch (userType) {
            case REQUESTER -> createRequester(user);
            case PROVIDER -> createProvider(user);
        }
        return userMapper.toDto(user);
    }

    @Override
    public UserDto getUser(UUID id) {
        return null;
    }

    private void createRequester(User user) {

    }

    private void createProvider(User user) {
    }
}
