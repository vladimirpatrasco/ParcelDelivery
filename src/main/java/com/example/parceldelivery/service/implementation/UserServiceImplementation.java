package com.example.parceldelivery.service.implementation;

import com.example.parceldelivery.converter.UserConverter;
import com.example.parceldelivery.domain.UserDomain;
import com.example.parceldelivery.entity.UserEntity;
import com.example.parceldelivery.repository.UserRepository;
import com.example.parceldelivery.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImplementation implements UserService {

    private final UserRepository userRepository;
    private final UserConverter userConverter;

    @Override
    public UserDomain createUser(UserDomain userDomain) {
        var userEntity = userConverter.convertUserDomainToUserEntity(userDomain);
        var userResultEntity = userRepository.save(userEntity);
        return userConverter.convertUserEntityToUserDomain(userResultEntity);
    }

    @Override
    public UserDomain updateUserById(UUID userId, UserDomain userDomain) {
        var userEntity = userConverter.convertUserDomainToUserEntity(userDomain);
        userEntity.setId(userId);
        userRepository.save(userEntity);
        return userConverter.convertUserEntityToUserDomain(userEntity);
    }

    @Override
    public List<UserDomain> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userConverter::convertUserEntityToUserDomain)
                .toList();
    }

    @Override
    public UserDomain getUserById(UUID userId) {
        return userRepository.findById(userId)
                .map(userConverter::convertUserEntityToUserDomain)
                .orElse(null);
    }

    @Override
    public void deleteUserById(UUID userId) {
        userRepository.deleteById(userId);
    }
}