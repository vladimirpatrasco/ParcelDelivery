package com.example.parceldelivery.service.implementation;

import com.example.parceldelivery.converter.RoleConverter;
import com.example.parceldelivery.converter.UserConverter;
import com.example.parceldelivery.domain.RoleDomain;
import com.example.parceldelivery.entity.RoleEntity;
import com.example.parceldelivery.repository.RoleRepository;
import com.example.parceldelivery.service.RoleService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RoleServiceImplementation implements RoleService {

    private final RoleRepository roleRepository;
    private final RoleConverter roleConverter;

    @Override
    public RoleDomain createRole(RoleDomain roleDomain) {
        var roleEntity = roleConverter.convertRoleDomainToRoleEntity(roleDomain);
        roleRepository.save(roleEntity);
        return roleConverter.convertRoleEntityToRoleDomain(roleEntity);
    }

    @Override
    public RoleDomain updateRoleById(UUID roleId, RoleDomain roleDomain) {
        var roleEntity = roleConverter.convertRoleDomainToRoleEntity(roleDomain);
        roleEntity.setId(roleId);
        roleRepository.save(roleEntity);
        return roleConverter.convertRoleEntityToRoleDomain(roleEntity);
    }

    @Override
    public List<RoleDomain> getAllRoles() {
        return roleRepository.findAll()
                .stream()
                .map(roleConverter::convertRoleEntityToRoleDomain)
                .toList();
    }

    @Override
    public RoleDomain getRoleById(UUID roleId) {
        return roleRepository.findById(roleId)
                .map(roleConverter::convertRoleEntityToRoleDomain)
                .orElse(null);
    }

    @Override
    public void deleteRoleById(UUID roleId) {
        roleRepository.deleteById(roleId);
    }
}
