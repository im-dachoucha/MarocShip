package com.simplon.maorocship.Entities;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "vehicule", schema = "public", catalog = "maoroc_ship")
public class VehiculeEntity implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private long id;

    @Basic
    @Column(name = "type", nullable = false)
    private String type;

    @OneToOne(mappedBy = "vehicule")
    private ChauffeurEntity chauffeur;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ChauffeurEntity getChauffeur() {
        return chauffeur;
    }

    public void setChauffeur(ChauffeurEntity chauffeur) {
        this.chauffeur = chauffeur;
    }
}
