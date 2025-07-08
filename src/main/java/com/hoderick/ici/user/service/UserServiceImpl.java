package com.hoderick.ici.user.service;

import com.hoderick.ici.user.domain.model.Provider;
import com.hoderick.ici.user.domain.model.Requester;
import com.hoderick.ici.user.domain.model.User;
import com.hoderick.ici.user.domain.model.UserType;
import com.hoderick.ici.user.domain.repository.UserRepository;
import com.hoderick.ici.user.dto.UserDto;
import com.hoderick.ici.user.exception.UserNotFoundException;
import com.hoderick.ici.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ProviderService providerService;
    private final RequesterService requesterService;
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
        return userRepository.findById(id)
                .map(userMapper::toDto)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::toDto)
                .toList();
    }

    private Requester createRequester(User user) {
        Requester requester = new Requester(user);
        return requesterService.createRequester(requester);
    }

    private Provider createProvider(User user) {
        Provider provider = new Provider(user);
        return providerService.createProvider(provider);
    }
}
