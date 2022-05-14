package com.optimizertruck.crudapi.model;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "chantier")
public class Chantier implements Serializable {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    private String nom;

    private String adresse;

    private String cp;

    private String ville;

    private String coordonnee;

    @OneToMany(mappedBy = "chantier")
    @JsonBackReference
    private List<Livrer> livrerList;

    public Chantier() {
    }


    public List<Livrer> getLivrerList() {
        return livrerList;
    }

    public void setLivrerList(List<Livrer> livrerList) {
        this.livrerList = livrerList;
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

    @Override
    public String toString() {
        return "Chantier{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", cp='" + cp + '\'' +
                ", ville='" + ville + '\'' +
                ", coordonnee='" + coordonnee + '\'' +
                '}';
    }
}
