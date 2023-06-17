package com.example.parceldelivery.domain;

import com.example.parceldelivery.response.RoleResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDomain {

    private UUID id;
    private String name;
    private String surName;
    private UUID role;

}
