package com.simplon.maorocship.Entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "chauffeur", schema = "public", catalog = "maoroc_ship")
public class ChauffeurEntity {

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resp_livraison")
    private RespLivraisonEntity respLivraison;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicule")
    private Vehicule vehicule;

    @OneToMany(mappedBy = "chauffeur", fetch = FetchType.LAZY)
    private Set<LivraisonEntity> livraisons;

    public Set<LivraisonEntity> getLivraisons() {
        return livraisons;
    }

    public void setLivraisons(Set<LivraisonEntity> livraisons) {
        this.livraisons = livraisons;
    }

    public Vehicule getVehicule() {
        return vehicule;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
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

    public RespLivraisonEntity getRespLivraison() {
        return respLivraison;
    }

    public void setRespLivraison(RespLivraisonEntity respLivraison) {
        this.respLivraison = respLivraison;
    }
}
