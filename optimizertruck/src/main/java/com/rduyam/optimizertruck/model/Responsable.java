package com.rduyam.optimizertruck.model;

import java.util.List;

public class Responsable {

    private Long idResponsable;

    private String nomResponsable;

    private String prenomResponsable;

    private String telResponsable;

    private String mailResponsable;

    private String passwdResponsable;

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
