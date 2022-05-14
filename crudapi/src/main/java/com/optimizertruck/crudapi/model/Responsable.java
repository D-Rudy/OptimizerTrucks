package com.optimizertruck.crudapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "responsable")
public class Responsable {
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

    @OneToMany(mappedBy = "responsable")
    private List<Logisticien> logisticienList;
    @OneToOne
    @JoinColumn(name = "centraleId", insertable = false, updatable = false)
    private Centrale centrale;

    private String centraleId;

    public Responsable() {
    }

    public String getCentraleId() {
        return centraleId;
    }

    public void setCentraleId(String centraleId) {
        this.centraleId = centraleId;
    }

    public Centrale getCentrale() {
        return centrale;
    }

    public void setCentrale(Centrale centrale) {
        this.centrale = centrale;
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

    public List<Logisticien> getLogisticienList() {
        return logisticienList;
    }

    public void setLogisticienList(List<Logisticien> logisticienList) {
        this.logisticienList = logisticienList;
    }

    @Override
    public String toString() {
        return "Responsable{" +
                "id='" + id + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", tel='" + tel + '\'' +
                ", mail='" + mail + '\'' +
                ", passwd='" + passwd + '\'' +
                ", logisticienList=" + logisticienList +
                ", centrale=" + centrale +
                '}';
    }
}
