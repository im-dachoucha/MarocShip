package com.simplon.marocship.Entities;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "livraison", schema = "public", catalog = "maroc_ship")
public class LivraisonEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private long id;

    @Basic
    @Column(name = "date", nullable = false)
    private String date;

    @Basic
    @Column(name = "from", nullable = false)
    private String from;

    @Basic
    @Column(name = "to", nullable = false)
    private String to;

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
    @ColumnDefault("CURRENT_TIMESTAMP")
    private String created_at;


    @ManyToOne(fetch = FetchType.LAZY)
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

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
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

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
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
