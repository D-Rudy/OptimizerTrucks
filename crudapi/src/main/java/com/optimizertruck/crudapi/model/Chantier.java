package com.optimizertruck.crudapi.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "chantier")
public class Chantier {

    @Id
    @GeneratedValue
    @Column(name = "id_chantier", nullable = false)
    private Integer idChantier;

    @Column(name = "nom_chantier")
    private String nomChantier;

    @Column(name = "adresse_chantier")
    private String adresseChantier;

    @Column(name = "cp_chantier")
    private String cpChantier;

    @Column(name = "ville_chantier")
    private String villeChantier;

    @Column(name = "coordonnee_chantier")
    private String coordonneeChantier;

    @OneToMany
    private List<Contrat> contrats;

    @OneToMany
    private List<Livraison>livraisons;

    public Chantier() {
    }

    public Integer getIdChantier() {
        return idChantier;
    }

    public void setIdChantier(Integer idChantier) {
        this.idChantier = idChantier;
    }

    public String getNomChantier() {
        return nomChantier;
    }

    public void setNomChantier(String nomChantier) {
        this.nomChantier = nomChantier;
    }

    public String getAdresseChantier() {
        return adresseChantier;
    }

    public void setAdresseChantier(String adresseChantier) {
        this.adresseChantier = adresseChantier;
    }

    public String getCpChantier() {
        return cpChantier;
    }

    public void setCpChantier(String cpChantier) {
        this.cpChantier = cpChantier;
    }

    public String getVilleChantier() {
        return villeChantier;
    }

    public void setVilleChantier(String villeChantier) {
        this.villeChantier = villeChantier;
    }

    public String getCoordonneeChantier() {
        return coordonneeChantier;
    }

    public void setCoordonneeChantier(String coordonneeChantier) {
        this.coordonneeChantier = coordonneeChantier;
    }

    public List<Contrat> getContrats() {
        return contrats;
    }

    public void setContrats(List<Contrat> contrats) {
        this.contrats = contrats;
    }

    public List<Livraison> getLivraisons() {
        return livraisons;
    }

    public void setLivraisons(List<Livraison> livraisons) {
        this.livraisons = livraisons;
    }

    @Override
    public String toString() {
        return "Chantier{" +
                "idChantier=" + idChantier +
                ", nomChantier='" + nomChantier + '\'' +
                ", adresseChantier='" + adresseChantier + '\'' +
                ", cpChantier='" + cpChantier + '\'' +
                ", villeChantier='" + villeChantier + '\'' +
                ", coordonneeChantier='" + coordonneeChantier + '\'' +
                '}';
    }
}