package com.rduyam.optimizertruck.model;

import java.util.List;

public class Chantier {

    private Integer id;

    private String nom;

    private String adresse;

    private String cp;

    private String ville;

    private String coordonnee;

    private List<Livrer> livrerList;

    public Chantier() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCoordonnee() {
        return coordonnee;
    }

    public void setCoordonnee(String coordonnee) {
        this.coordonnee = coordonnee;
    }

    public List<Livrer> getLivrerList() {
        return livrerList;
    }

    public void setLivrerList(List<Livrer> livrerList) {
        this.livrerList = livrerList;
    }

    @Override
    public String toString() {
        return "Chantier{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", cp='" + cp + '\'' +
                ", ville='" + ville + '\'' +
                ", coordonnee='" + coordonnee + '\'' +
                ", livrerList=" + livrerList +
                '}';
    }
}
