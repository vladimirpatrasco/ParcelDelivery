package com.example.parceldelivery.controller;

import com.example.parceldelivery.converter.UserConverter;
import com.example.parceldelivery.domain.UserDomain;
import com.example.parceldelivery.entity.UserEntity;
import com.example.parceldelivery.request.UserRequest;
import com.example.parceldelivery.response.UserResponse;
import com.example.parceldelivery.service.implementation.UserServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImplementation userServiceImplementation;
    private final UserConverter userConverter;

    @PostMapping("/users") // Создание пользователя
    public UserResponse createUser (@RequestBody UserRequest userRequest) {
        var user = userServiceImplementation.createUser(
                userConverter.convertUserRequestToUserDomain(userRequest)
        );
        return userConverter.convertUserDomainToUserResponse(user);
    }

    @PatchMapping("/users/{id}") // Редактирование пользователя
    public UserResponse updateUserById (@PathVariable ("id") UUID userId, @RequestBody UserRequest userRequest) {
        var userDomain = userServiceImplementation.updateUserById(
                userId,
                userConverter.convertUserRequestToUserDomain(userRequest)
        );
        return userConverter.convertUserDomainToUserResponse(userDomain);
    }

    @GetMapping("/users")  // Вывод всех пользователей
    public List<UserResponse> getAllUsers() {
        return userServiceImplementation.getAllUsers()
                .stream()
                .map(userConverter::convertUserDomainToUserResponse)
                .toList();
    }

    @GetMapping("/users/{id}") // Выпод пользователя по ID
    public UserResponse getUserById (@PathVariable ("id") UUID userId) {
        return userConverter.convertUserDomainToUserResponse(
                userServiceImplementation.getUserById(userId)
        );
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser (@PathVariable ("id") UUID userId) {
        userServiceImplementation.deleteUserById(userId);
    }
}
