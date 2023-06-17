package com.example.parceldelivery.service;

import com.example.parceldelivery.domain.RoleDomain;
import com.example.parceldelivery.entity.RoleEntity;

import java.util.List;
import java.util.UUID;

public interface RoleService {

    public RoleDomain createRole(RoleDomain role);
    public RoleDomain updateRoleById (UUID roleId, RoleDomain role);
    public List<RoleDomain> getAllRoles();
    public RoleDomain getRoleById (UUID roleId);
    public void deleteRoleById(UUID roleId);


}
