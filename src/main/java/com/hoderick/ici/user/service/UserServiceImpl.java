package com.hoderick.ici.user.service;

import com.hoderick.ici.user.domain.model.User;
import com.hoderick.ici.user.domain.repository.UserRepository;
import com.hoderick.ici.user.dto.UserDto;
import com.hoderick.ici.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDto createUser(UserDto dto) {
        User user = userMapper.fromDto(dto);
        return userMapper.toDto(userRepository.save(user));
    }

    @Override
    public UserDto getUser(UUID id) {
        return null;
    }
}
