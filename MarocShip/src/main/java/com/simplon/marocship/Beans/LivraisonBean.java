package com.simplon.marocship.Beans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class LivraisonBean {

    private long id;

    public long getChauffeurId() {
        return chauffeurId;
    }

    public void setChauffeurId(long chauffeurId) {
        this.chauffeurId = chauffeurId;
    }

    private long chauffeurId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private String lieuxDepart;

    private String lieuxArrive;

    private Long poids;

    private String date;

    private String zone;

    private String status;


    public String getLieuxDepart() {
        return lieuxDepart;
    }

    public void setLieuxDepart(String lieuxDepart) {
        this.lieuxDepart = lieuxDepart;
    }

    public String getLieuxArrive() {
        return lieuxArrive;
    }

    public void setLieuxArrive(String lieuxArrive) {
        this.lieuxArrive = lieuxArrive;
    }

    public Long getPoids() {
        return poids;
    }

    public void setPoids(Long poids) {
        this.poids = poids;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
