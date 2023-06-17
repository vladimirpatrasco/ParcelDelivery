package com.example.parceldelivery.service;

import com.example.parceldelivery.domain.UserDomain;
import com.example.parceldelivery.entity.UserEntity;

import java.util.List;
import java.util.UUID;

public interface UserService {

    public UserDomain createUser(UserDomain user);
    public UserDomain updateUserById (UUID userId, UserDomain user);
    public List<UserDomain> getAllUsers();
    public UserDomain getUserById (UUID userId);
    public void deleteUserById(UUID userId);
}
