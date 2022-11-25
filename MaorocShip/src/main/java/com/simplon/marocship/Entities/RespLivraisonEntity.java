package com.simplon.marocship.Entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "resp_livraison", schema = "public", catalog = "maroc_ship")
public class RespLivraisonEntity implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private long id;

    @Basic
    @Column(name = "name", nullable = false)
    private String name;
    @Basic
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Basic
    @Column(name = "password", nullable = false)
    private String password;

    @OneToMany(mappedBy = "respLivraison", fetch = FetchType.LAZY)
    private Set<ChauffeurEntity> chauffeur;

    @OneToMany(mappedBy = "respLivraison",fetch = FetchType.LAZY)
    private Set<LivraisonEntity> livraisons;

    public Set<LivraisonEntity> getLivraisons() {
        return livraisons;
    }

    public void setLivraisons(Set<LivraisonEntity> livraisons) {
        this.livraisons = livraisons;
    }

    public Set<ChauffeurEntity> getChauffeur() {
        return this.chauffeur;
    }

    public void setChauffeur(Set<ChauffeurEntity> chauffeur) {
        this.chauffeur = chauffeur;
    }

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
