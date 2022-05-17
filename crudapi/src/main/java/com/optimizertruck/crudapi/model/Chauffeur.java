package com.optimizertruck.crudapi.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "chauffeur")
public class Chauffeur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_chauffeur", nullable = false)
    private Long idChauffeur;

    @Column(name = "nom_chauffeur")
    private String nomChauffeur;

    @Column(name = "prenom_chauffeur")
    private String prenomChauffeur;

    @Column(name = "tel_chauffeur")
    private String telChauffeur;

    @Column(name = "mail_chauffeur")
    private String mailChauffeur;

    @Column(name = "passwd_chauffeur")
    private String passwdChauffeur;

/*    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_camion", nullable = false)
    private Camion camion;*/

    @OneToMany
    private List<Mission> missions;

    public Chauffeur() {
    }

    public Long getIdChauffeur() {
        return idChauffeur;
    }

    public void setIdChauffeur(Long idChauffeur) {
        this.idChauffeur = idChauffeur;
    }

    public String getNomChauffeur() {
        return nomChauffeur;
    }

    public void setNomChauffeur(String nomChauffeur) {
        this.nomChauffeur = nomChauffeur;
    }

    public String getPrenomChauffeur() {
        return prenomChauffeur;
    }

    public void setPrenomChauffeur(String prenomChauffeur) {
        this.prenomChauffeur = prenomChauffeur;
    }

    public String getTelChauffeur() {
        return telChauffeur;
    }

    public void setTelChauffeur(String telChauffeur) {
        this.telChauffeur = telChauffeur;
    }

    public String getMailChauffeur() {
        return mailChauffeur;
    }

    public void setMailChauffeur(String mailChauffeur) {
        this.mailChauffeur = mailChauffeur;
    }

    public String getPasswdChauffeur() {
        return passwdChauffeur;
    }

    public void setPasswdChauffeur(String passwdChauffeur) {
        this.passwdChauffeur = passwdChauffeur;
    }

/*    public Camion getCamion() {
        return camion;
    }

    public void setCamion(Camion camion) {
        this.camion = camion;
    }*/

    public List<Mission> getMissions() {
        return missions;
    }

    public void setMissions(List<Mission> missions) {
        this.missions = missions;
    }

    @Override
    public String toString() {
        return "Chauffeur{" +
                "idChauffeur=" + idChauffeur +
                ", nomChauffeur='" + nomChauffeur + '\'' +
                ", prenomChauffeur='" + prenomChauffeur + '\'' +
                ", telChauffeur='" + telChauffeur + '\'' +
                ", mailChauffeur='" + mailChauffeur + '\'' +
                ", passwdChauffeur='" + passwdChauffeur + '\'' /*+
                ", camion=" + camion */+
                '}';
    }
}