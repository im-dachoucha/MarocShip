package com.simplon.marocship.Entities;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "livraison", schema = "public", catalog = "maroc_ship")
public class LivraisonEntity implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private long id;

    @Basic
    @Column(name = "date", nullable = false)
    private String date;

    @Basic
    @Column(name = "beginning", nullable = false)
    private String beginning;

    @Basic
    @Column(name = "destination", nullable = false)
    private String destination;

    @Basic
    @Column(name = "weight", nullable = false)
    private String weight;

    @Basic
    @Column(name = "status", nullable = false)
    private String status;

    @Basic
    @Column(name = "zone", nullable = false)
    private String zone;


    @Basic
    @Column(name = "created_at", nullable = false)
    private LocalDate created_at = LocalDate.now();


    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_resp_livraison")
    private RespLivraisonEntity respLivraison;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_chauffeur", nullable = true)
    private ChauffeurEntity chauffeur;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBeginning() {
        return beginning;
    }

    public void setBeginning(String beginning) {
        this.beginning = LivraisonEntity.this.beginning;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = LivraisonEntity.this.destination;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public LocalDate getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDate created_at) {
        this.created_at = created_at;
    }

    public RespLivraisonEntity getRespLivraison() {
        return respLivraison;
    }

    public void setRespLivraison(RespLivraisonEntity respLivraison) {
        this.respLivraison = respLivraison;
    }

    public ChauffeurEntity getChauffeur() {
        return chauffeur;
    }

    public void setChauffeur(ChauffeurEntity chauffeur) {
        this.chauffeur = chauffeur;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }
}
