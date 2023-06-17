package com.example.parceldelivery.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "Roles")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoleEntity {

    @Id
    @GeneratedValue
    @Column(name="id")
    private UUID id;
    private String name;

    @Override
    public String toString() {
        return "Role " + id + " - " + name;
    }


}
