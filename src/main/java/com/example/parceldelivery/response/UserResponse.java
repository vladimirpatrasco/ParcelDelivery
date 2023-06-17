package com.example.parceldelivery.response;

import com.example.parceldelivery.domain.RoleDomain;
import com.example.parceldelivery.repository.RoleRepository;
import com.example.parceldelivery.request.RoleRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.management.relation.Role;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    private UUID id;
    private String name;
    private String surName;
    private UUID role;
}
