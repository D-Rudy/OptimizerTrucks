package com.optimizertruck.crudapi.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "responsable")
public class Responsable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_responsable", nullable = false)
    private Long idResponsable;

    @Column(name = "nom_responsable")
    private String nomResponsable;

    @Column(name = "prenom_responsable")
    private String prenomResponsable;

    @Column(name = "tel_responsable")
    private String telResponsable;

    @Column(name = "mail_responsable")
    private String mailResponsable;

    @Column(name = "passwd_responsable")
    private String passwdResponsable;


    private Long idCentrale;

    @ManyToOne
    @JoinColumn( name="",referencedColumnName = "id_centrale")
    private Centrale centrale;


    public Responsable() {
    }

    public Long getIdResponsable() {
        return idResponsable;
    }

    public void setIdResponsable(Long idResponsable) {
        this.idResponsable = idResponsable;
    }

    public String getNomResponsable() {
        return nomResponsable;
    }

    public void setNomResponsable(String nomResponsable) {
        this.nomResponsable = nomResponsable;
    }

    public String getPrenomResponsable() {
        return prenomResponsable;
    }

    public void setPrenomResponsable(String prenomResponsable) {
        this.prenomResponsable = prenomResponsable;
    }

    public String getTelResponsable() {
        return telResponsable;
    }

    public void setTelResponsable(String telResponsable) {
        this.telResponsable = telResponsable;
    }

    public String getMailResponsable() {
        return mailResponsable;
    }

    public void setMailResponsable(String mailResponsable) {
        this.mailResponsable = mailResponsable;
    }

    public String getPasswdResponsable() {
        return passwdResponsable;
    }

    public void setPasswdResponsable(String passwdResponsable) {
        this.passwdResponsable = passwdResponsable;
    }

    public Centrale getCentrale() {
        return centrale;
    }

    public void setCentrale(Centrale centrale) {
        this.centrale = centrale;
    }

    public Long getIdCentrale() {
        return idCentrale;
    }

    public void setIdCentrale(Long idCentrale) {
        this.idCentrale = idCentrale;
    }

    @Override
    public String toString() {
        return "Responsable{" +
                "idResponsable=" + idResponsable +
                ", nomResponsable='" + nomResponsable + '\'' +
                ", prenomResponsable='" + prenomResponsable + '\'' +
                ", telResponsable='" + telResponsable + '\'' +
                ", mailResponsable='" + mailResponsable + '\'' +
                ", passwdResponsable='" + passwdResponsable + '\'' +
                ", centrale=" + centrale +
                '}';
    }
}