package com.optimizertruck.crudapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "camion")
public class Camion {
    @Id
    @Column(name = "id", nullable = false)
    private String id;
    @Column(name = "nettoyage")
    private Integer nettoyage;
    @Column(name = "vidange")
    private Integer vidange;
    @Column(name = "remplissage")
    private Integer remplissage;

    @JsonBackReference
    @OneToOne(mappedBy = "camion")
    @JoinColumn(name = "chauffeurId", insertable = false, updatable = false)
    private Chauffeur chauffeur;

    public Camion() {
    }

    public Chauffeur getChauffeur() {
        return chauffeur;
    }

    public void setChauffeur(Chauffeur chauffeur) {
        this.chauffeur = chauffeur;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getNettoyage() {
        return nettoyage;
    }

    public void setNettoyage(Integer nettoyage) {
        this.nettoyage = nettoyage;
    }

    public Integer getVidange() {
        return vidange;
    }

    public void setVidange(Integer vidange) {
        this.vidange = vidange;
    }

    public Integer getRemplissage() {
        return remplissage;
    }

    public void setRemplissage(Integer remplissage) {
        this.remplissage = remplissage;
    }

    @Override
    public String toString() {
        return "Camion{" +
                "immatriculation='" + id + '\'' +
                ", nettoyage=" + nettoyage + " min" +
                ", vidange=" + vidange + " min" +
                ", remplissage=" + remplissage + " min" +
                '}';
    }
}
