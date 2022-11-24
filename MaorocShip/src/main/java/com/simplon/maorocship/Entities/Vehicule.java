package com.simplon.maorocship.Entities;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "vehicule", schema = "public", catalog = "maoroc_ship")
public class Vehicule implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private long id;

    @Basic
    @Column(name = "type", nullable = false)
    private String type;

    @OneToOne(mappedBy = "vehicule")
    private Vehicule vehicule;

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

    public Vehicule getVehicule() {
        return vehicule;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }
}
