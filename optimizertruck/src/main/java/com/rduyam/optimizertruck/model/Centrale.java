package com.rduyam.optimizertruck.model;


import lombok.Data;
import org.springframework.context.annotation.Bean;

@Data
public class Centrale {

    private String id;

    private String nom;

    private String tel;

    private String adresse;

    private String cp;

    private String ville;

    private String coordonne;

/*    private int capaciteProd;*/



    public Centrale() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
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

    public String getCoordonne() {
        return coordonne;
    }

    public void setCoordonne(String coordonne) {
        this.coordonne = coordonne;
    }

/*    public int getCapaciteProd() {
        return capaciteProd;
    }

    public void setCapaciteProd(int capaciteProd) {
        this.capaciteProd = capaciteProd;
    }*/

/*    public Responsable getResponsable() {
        return responsable;
    }

    public void setResponsable(Responsable responsable) {
        this.responsable = responsable;
    }*/

    @Override
    public String toString() {
        return "Centrale{" +
                "id='" + id + '\'' +
                ", nom='" + nom + '\'' +
                ", tel='" + tel + '\'' +
                ", adresse='" + adresse + '\'' +
                ", cp='" + cp + '\'' +
                ", ville='" + ville + '\'' +
                ", coordonne='" + coordonne + '\'' +
                /*", capaciteProd=" + capaciteProd +*/
                /*", responsable=" + responsable +*/
                '}';
    }
}
