package com.optimizertruck.crudapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "centrale")
public class Centrale {


    @Id
    private String id;
    private String nom;
    private String tel;
    private String adresse;
    private String cp;
    private String ville;
    private String coordonne;
    private int capaciteProd;


/*    @JsonBackReference
    @OneToOne(mappedBy = "centrale")
    private Responsable responsable;*/


    public Centrale() {

    }

    public String getIdCentrale() {
        return id;
    }

    public void setIdCentrale(String idCentrale) {
        this.id = idCentrale;
    }
/*
    public void setCapaciteProd(int capaciteProd) {
        this.capaciteProd = capaciteProd;
    }*/

    @Column(name = "nom", nullable = false)
    public String getNomCentrale() {
        return nom;
    }

    public void setNomCentrale(String nomCentrale) {
        this.nom = nomCentrale;
    }
    @Column(name = "tel")
    public String getTelCentrale() {
        return tel;
    }

    public void setTelCentrale(String telCentrale) {
        this.tel = telCentrale;
    }
    @Column(name = "adresse", nullable = false)
    public String getAdresseCentrale() {
        return adresse;
    }

    public void setAdresseCentrale(String adresseCentrale) {
        this.adresse = adresseCentrale;
    }
    @Column(name = "cp", nullable = false)
    public String getCpCentrale() {
        return cp;
    }

    public void setCpCentrale(String cpCentrale) {
        this.cp = cpCentrale;
    }
    @Column(name = "ville", nullable = false)
    public String getVilleCentrale() {
        return ville;
    }

    public void setVilleCentrale(String villeCentrale) {
        this.ville = villeCentrale;
    }
    @Column(name = "coordonne", nullable = false)
    public String getCoordonneCentrale() {
        return coordonne;
    }

    public void setCoordonneCentrale(String coordonneCentrale) {
        this.coordonne = coordonneCentrale;
    }
    @Column(name = "capacite-prod")
    public Integer getCapaciteProd() {
        return capaciteProd;
    }

    public void setCapaciteProd(Integer capaciteProd) {
        this.capaciteProd = capaciteProd;
    }


    @Override
    public String toString() {
        return "Centrale{" +
                "id='" + id + '\'' +
                ", nomCentrale='" + nom + '\'' +
                ", telCentrale='" + tel + '\'' +
                ", adresseCentrale='" + adresse + '\'' +
                ", cpCentrale='" + cp + '\'' +
                ", villeCentrale='" + ville + '\'' +
                ", coordonneCentrale='" + coordonne + '\'' +
                ", capaciteProd=" + capaciteProd +
                '}';
    }
}