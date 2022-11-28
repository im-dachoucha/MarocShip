package com.simplon.marocship.Beans;

import com.simplon.marocship.Entities.AdminEntity;
import com.simplon.marocship.Entities.ChauffeurEntity;
import com.simplon.marocship.Entities.RespLivraisonEntity;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class UserBean implements Serializable {

    private String name;
    private String email;
    private String password;
    private String msg = "";

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    private RespLivraisonEntity respLivraisonEntity;
    private AdminEntity adminEntity;

    public RespLivraisonEntity getRespLivraisonEntity() {
        return respLivraisonEntity;
    }

    public void setRespLivraisonEntity(RespLivraisonEntity respLivraisonEntity) {
        this.respLivraisonEntity = respLivraisonEntity;
    }

    public AdminEntity getAdminEntity() {
        return adminEntity;
    }

    public void setAdminEntity(AdminEntity adminEntity) {
        this.adminEntity = adminEntity;
    }

    public ChauffeurEntity getChauffeurEntity() {
        return chauffeurEntity;
    }

    public void setChauffeurEntity(ChauffeurEntity chauffeurEntity) {
        this.chauffeurEntity = chauffeurEntity;
    }

    private ChauffeurEntity chauffeurEntity;
    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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
