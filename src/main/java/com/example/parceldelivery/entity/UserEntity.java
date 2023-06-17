package com.example.parceldelivery.entity;

import com.example.parceldelivery.response.RoleResponse;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nonapi.io.github.classgraph.json.JSONUtils;

import javax.management.relation.Role;
import java.util.UUID;

@Entity
@Table(name = "Users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue
    private UUID id;
/*    @ManyToOne
    @JoinColumn(name = "role_id")
    private RoleEntity role;*/
    private UUID role;
    private String name;
    private String surName;

    @Override
    public String toString() {
        return "\nUser: " + "\n" +
                "Id: " + id + "\n" +
                "Name: " + name + "\n" +
                "Surname: " + surName + "\n" +
                "Role: " + role + "\n";
    }
}

