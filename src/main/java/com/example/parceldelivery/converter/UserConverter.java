package com.example.parceldelivery.converter;

import com.example.parceldelivery.domain.UserDomain;
import com.example.parceldelivery.entity.UserEntity;
import com.example.parceldelivery.request.UserRequest;
import com.example.parceldelivery.response.UserResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserConverter {

    UserDomain convertUserRequestToUserDomain(UserRequest request);
    UserEntity convertUserDomainToUserEntity(UserDomain domain);
    UserDomain convertUserEntityToUserDomain(UserEntity entity);
    UserResponse convertUserDomainToUserResponse(UserDomain domain);
}
