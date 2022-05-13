package com.optimizertruck.crudapi.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "centrale")
public class Centrale {


    private String idCentrale;
    private String nomCentrale;
    private String telCentrale;
    private String adresseCentrale;
    private String cpCentrale;
    private String villeCentrale;
    private String coordonneCentrale;
    private int capaciteProd;





    public Centrale() {

    }

    @Id
    public String getId() {
        return idCentrale;
    }

    public void setId(String id) {
        this.idCentrale = id;
    }

    @Column(name = "nom_centrale", nullable = false)
    public String getNomCentrale() {
        return nomCentrale;
    }

    public void setNomCentrale(String nomCentrale) {
        this.nomCentrale = nomCentrale;
    }
    @Column(name = "tel_centrale")
    public String getTelCentrale() {
        return telCentrale;
    }

    public void setTelCentrale(String telCentrale) {
        this.telCentrale = telCentrale;
    }
    @Column(name = "adresse_centrale", nullable = false)
    public String getAdresseCentrale() {
        return adresseCentrale;
    }

    public void setAdresseCentrale(String adresseCentrale) {
        this.adresseCentrale = adresseCentrale;
    }
    @Column(name = "cp_centrale", nullable = false)
    public String getCpCentrale() {
        return cpCentrale;
    }

    public void setCpCentrale(String cpCentrale) {
        this.cpCentrale = cpCentrale;
    }
    @Column(name = "ville_centrale", nullable = false)
    public String getVilleCentrale() {
        return villeCentrale;
    }

    public void setVilleCentrale(String villeCentrale) {
        this.villeCentrale = villeCentrale;
    }
    @Column(name = "coordonne_centrale", nullable = false)
    public String getCoordonneCentrale() {
        return coordonneCentrale;
    }

    public void setCoordonneCentrale(String coordonneCentrale) {
        this.coordonneCentrale = coordonneCentrale;
    }
    @Column(name = "capacite_centrale")
    public Integer getCapaciteProd() {
        return capaciteProd;
    }

    public void setCapaciteProd(Integer capaciteProd) {
        this.capaciteProd = capaciteProd;
    }


    @Override
    public String toString() {
        return "Centrale{" +
                "id='" + idCentrale + '\'' +
                ", nomCentrale='" + nomCentrale + '\'' +
                ", telCentrale='" + telCentrale + '\'' +
                ", adresseCentrale='" + adresseCentrale + '\'' +
                ", cpCentrale='" + cpCentrale + '\'' +
                ", villeCentrale='" + villeCentrale + '\'' +
                ", coordonneCentrale='" + coordonneCentrale + '\'' +
                ", capaciteProd=" + capaciteProd +
                '}';
    }
}