package com.simplon.maorocship.entity;

import jakarta.inject.Named;
import jakarta.persistence.*;
import java.io.Serializable;

/**
 * Admin entity
 */
@Entity
@Named
@Table(name = "admin" , schema = "public" , catalog = "maoroc_ship")
public class AdminEntity implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id" , nullable = false)
    private long id;

    @Column(name = "name" , nullable = false)
    private String name;

    @Column(name = "email" , nullable = false, unique = true)
    private String email;

    @Column(name = "password" , nullable = false)
    private String password;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
