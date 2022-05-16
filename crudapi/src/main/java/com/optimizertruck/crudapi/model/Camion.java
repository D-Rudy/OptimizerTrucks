package com.optimizertruck.crudapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "camion")
public class Camion {

    @Id
    @GeneratedValue
    @Column(name = "id_camion", nullable = false)
    private Integer idCamion;

    @Column(name = "immatriculation_camion)")
    private String immatriculation;

    @Column(name = "nettoyage_camion")
    private Integer nettoyage;

    @Column(name = "vidange_camion")
    private Integer vidange;

    @Column(name = "remplissage_camion")
    private Integer remplissage;

    @OneToMany
    private List<Chauffeur> chauffeurs;

    @OneToMany
    private List<Livraison> livraisons;

    /*
    CONSTRUCTEUR
     */
    public Camion() {
    }

    /*
    GETTER/SETTER
     */

    public Integer getIdCamion() {
        return idCamion;
    }

    public void setIdCamion(Integer idCamion) {
        this.idCamion = idCamion;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
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

    public List<Chauffeur> getChauffeurs() {
        return chauffeurs;
    }

    public void setChauffeurs(List<Chauffeur> chauffeurs) {
        this.chauffeurs = chauffeurs;
    }

    public List<Livraison> getLivraisons() {
        return livraisons;
    }
}