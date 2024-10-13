package com.example.thecoffeehouse.data.entities.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    private String userId;

    @Column(name = "firstName")

}
