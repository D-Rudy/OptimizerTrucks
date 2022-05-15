package com.optimizertruck.crudapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "logisticien")
public class Logisticien {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "nom")
    private String nom;
    @Column(name = "prenom")
    private String prenom;
    @Column(name = "tel")
    private String tel;
    @Column(name = "mail")
    private String mail;
    @Column(name = "passwd")
    private String passwd;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "responsableId", insertable = false, updatable = false)
    private Responsable responsable;

    private String responsableId;

    public Logisticien() {
    }

    public Responsable getResponsable() {
        return responsable;
    }

    public void setResponsable(Responsable responsable) {
        this.responsable = responsable;
    }

    public String getId() {
        return id;
    }

    public void setId(String matricule) {
        this.id = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getResponsableId() {
        return responsableId;
    }

    public void setResponsableId(String responsableId) {
        this.responsableId = responsableId;
    }

    @Override
    public String toString() {
        return "Logisticien{" +
                "Matricule='" + id + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", tel='" + tel + '\'' +
                ", mail='" + mail + '\'' +
                ", passwd='" + passwd + '\'' +
                ", responsable=" + responsable +
                '}';
    }
}
