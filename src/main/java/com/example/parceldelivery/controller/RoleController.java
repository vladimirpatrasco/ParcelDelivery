package com.example.parceldelivery.controller;

import com.example.parceldelivery.converter.RoleConverter;
import com.example.parceldelivery.domain.RoleDomain;
import com.example.parceldelivery.entity.RoleEntity;
import com.example.parceldelivery.request.RoleRequest;
import com.example.parceldelivery.response.RoleResponse;
import com.example.parceldelivery.service.implementation.RoleServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class RoleController {

    private final RoleServiceImplementation roleServiceImplementation;
    private final RoleConverter roleConverter;


    @PostMapping("/roles") // Создание роли
    public RoleResponse createRole(@RequestBody RoleRequest roleRequest) {
        var roleDomain = roleServiceImplementation.createRole(
                roleConverter.convertRoleRequestToRoleDomain(roleRequest)
        );
        return roleConverter.convertRoleDomainToRoleResponse(roleDomain);
    }

    @PatchMapping("/roles/{id}") // Редактирование роли
    public RoleResponse updateRoleById(@PathVariable("id") UUID roleId, @RequestBody RoleRequest roleRequest) {
        var roleDomain = roleServiceImplementation.updateRoleById(
                roleId,
                roleConverter.convertRoleRequestToRoleDomain(roleRequest));
        return roleConverter.convertRoleDomainToRoleResponse(roleDomain);
    }

    @GetMapping("/roles")  // Вывод всех ролей
    public List<RoleResponse> getAllRoles() {
        return roleServiceImplementation.getAllRoles()
                .stream()
                .map(roleConverter::convertRoleDomainToRoleResponse)
                .toList();
    }

    @GetMapping("/roles/{id}") // Вывод роли по ID
    public RoleResponse getRoleById(@PathVariable("id") UUID roleId) {
        return roleConverter.convertRoleDomainToRoleResponse(
                roleServiceImplementation.getRoleById(roleId)
        );
    }

    @DeleteMapping("/roles/{id}")
    public void deleteRole(@PathVariable("id") UUID roleId) {
        roleServiceImplementation.deleteRoleById(roleId);
    }
}
