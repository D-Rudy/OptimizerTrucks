package com.optimizertruck.crudapi.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "centrale")
public class Centrale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_centrale", nullable = false)
    private Long idCentrale;

    @Column(name = "nom_centrale")
    private String nomCentrale;

    @Column(name = "tel_centrale")
    private String telCentrale;

    @Column(name = "adresse_centrale")
    private String adresseCentrale;

    @Column(name = "cp_centrale")
    private String cpCentrale;

    @Column(name = "ville_centrale")
    private String villeCentrale;

    @Column(name = "coordonne_centrale")
    private String coordonneCentrale;

    @Column(name = "capacite_prod")
    private Integer capaciteProd;
/*
    @OneToMany
    private List<Responsable> responsables;*/

    public Centrale() {
    }

    public Long getIdCentrale() {
        return idCentrale;
    }

    public void setIdCentrale(Long idCentrale) {
        this.idCentrale = idCentrale;
    }

    public String getNomCentrale() {
        return nomCentrale;
    }

    public void setNomCentrale(String nomCentrale) {
        this.nomCentrale = nomCentrale;
    }

    public String getTelCentrale() {
        return telCentrale;
    }

    public void setTelCentrale(String telCentrale) {
        this.telCentrale = telCentrale;
    }

    public String getAdresseCentrale() {
        return adresseCentrale;
    }

    public void setAdresseCentrale(String adresseCentrale) {
        this.adresseCentrale = adresseCentrale;
    }

    public String getCpCentrale() {
        return cpCentrale;
    }

    public void setCpCentrale(String cpCentrale) {
        this.cpCentrale = cpCentrale;
    }

    public String getVilleCentrale() {
        return villeCentrale;
    }

    public void setVilleCentrale(String villeCentrale) {
        this.villeCentrale = villeCentrale;
    }

    public String getCoordonneCentrale() {
        return coordonneCentrale;
    }

    public void setCoordonneCentrale(String coordonneCentrale) {
        this.coordonneCentrale = coordonneCentrale;
    }

    public Integer getCapaciteProd() {
        return capaciteProd;
    }

    public void setCapaciteProd(Integer capaciteProd) {
        this.capaciteProd = capaciteProd;
    }

    /*public List<Responsable> getResponsables() {
        return responsables;
    }

    public void setResponsables(List<Responsable> responsables) {
        this.responsables = responsables;
    }

    */@Override
    public String toString() {
        return "Centrale{" +
                "idCentrale=" + idCentrale +
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