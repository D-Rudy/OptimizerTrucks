package com.optimizertruck.crudapi.model;

import javax.persistence.*;


@Entity
@Table(name = "responsable")
public class Responsable {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "nom_responsable")
    private String nom;
    @Column(name = "prenom_responsable")
    private String prenom;
    @Column(name = "tel_responsable")
    private String tel;
    @Column(name = "mail_responsable")
    private String mail;
    @Column(name = "passwd_responsable")
    private String passwd;


    @Id
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

    @Override
    public String toString() {
        return
                "matricule='" + id + '\'' +
                        ", nom='" + nom + '\'' +
                        ", prenom='" + prenom + '\'' +
                        ", tel='" + tel + '\'' +
                        ", mail='" + mail + '\'' +
                        ", passwd='" + passwd + '\'' +
                        '}';
    }

}
