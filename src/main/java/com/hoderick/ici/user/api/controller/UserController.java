package com.hoderick.ici.user.api.controller;

import com.hoderick.ici.user.api.dto.response.HttpUserDto;
import com.hoderick.ici.user.api.dto.request.CreateUserRequest;
import com.hoderick.ici.user.api.mapper.UserApiMapper;
import com.hoderick.ici.user.application.service.InternalUserService;
import com.hoderick.ici.user.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController("users")
@RequiredArgsConstructor
public class UserController {

    private final InternalUserService userService;
    private final UserApiMapper userApiMapper;

    @PostMapping
    public ResponseEntity<HttpUserDto> createUser(@RequestBody CreateUserRequest request) {
        User user = userService.createUser(userApiMapper.fromCreateRequest(request));
        return ResponseEntity.ok().body(userApiMapper.toHttpDto(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<HttpUserDto> getUser(@PathVariable UUID id) {
        User user = userService.getUserEntityById(id);
        return ResponseEntity.ok().body(userApiMapper.toHttpDto(user));
    }

}
