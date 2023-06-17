package com.example.parceldelivery.converter;

import com.example.parceldelivery.domain.RoleDomain;
import com.example.parceldelivery.entity.RoleEntity;
import com.example.parceldelivery.request.RoleRequest;
import com.example.parceldelivery.response.RoleResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel =  "spring")
public interface RoleConverter {

    RoleDomain convertRoleRequestToRoleDomain(RoleRequest request);
    RoleEntity convertRoleDomainToRoleEntity(RoleDomain domain);
    RoleDomain convertRoleEntityToRoleDomain(RoleEntity entity);
    RoleResponse convertRoleDomainToRoleResponse(RoleDomain domain);
}
