package com.rduyam.optimizertruck.model;

public class Camion {
    private String id;

    private Integer nettoyage;

    private Integer vidange;

    private Integer remplissage;

    private Chauffeur chauffeur;

    public Camion() {
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

    public Chauffeur getChauffeur() {
        return chauffeur;
    }

    public void setChauffeur(Chauffeur chauffeur) {
        this.chauffeur = chauffeur;
    }

    @Override
    public String toString() {
        return "Camion{" +
                "id='" + id + '\'' +
                ", nettoyage=" + nettoyage +
                ", vidange=" + vidange +
                ", remplissage=" + remplissage +
                ", chauffeur=" + chauffeur +
                '}';
    }
}
