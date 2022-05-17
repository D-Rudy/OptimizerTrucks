package com.optimizertruck.crudapi.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "logisticien")
public class Logisticien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_logisticien", nullable = false)
    private Long idLogisticien;

    @Column(name = "nom_logisticien")
    private String nomLogisticien;

    @Column(name = "prenom_logisticien")
    private String prenomLogisticien;

    @Column(name = "tel_logisticien")
    private String telLogisticien;

    @Column(name = "mail_logisticien")
    private String mailLogisticien;

    @Column(name = "passwd_logisticien")
    private String passwdLogisticien;

    @ManyToOne
    @JoinColumn(name="idResponsable", nullable=false)
    private Responsable responsable;

    public Logisticien() {
    }

    public Long getIdLogisticien() {
        return idLogisticien;
    }

    public void setIdLogisticien(Long idLogisticien) {
        this.idLogisticien = idLogisticien;
    }

    public String getNomLogisticien() {
        return nomLogisticien;
    }

    public void setNomLogisticien(String nomLogisticien) {
        this.nomLogisticien = nomLogisticien;
    }

    public String getPrenomLogisticien() {
        return prenomLogisticien;
    }

    public void setPrenomLogisticien(String prenomLogisticien) {
        this.prenomLogisticien = prenomLogisticien;
    }

    public String getTelLogisticien() {
        return telLogisticien;
    }

    public void setTelLogisticien(String telLogisticien) {
        this.telLogisticien = telLogisticien;
    }

    public String getMailLogisticien() {
        return mailLogisticien;
    }

    public void setMailLogisticien(String mailLogisticien) {
        this.mailLogisticien = mailLogisticien;
    }

    public String getPasswdLogisticien() {
        return passwdLogisticien;
    }

    public void setPasswdLogisticien(String passwdLogisticien) {
        this.passwdLogisticien = passwdLogisticien;
    }

    public Responsable getResponsable() {
        return responsable;
    }

    public void setResponsable(Responsable responsable) {
        this.responsable = responsable;
    }


    @Override
    public String toString() {
        return "Logisticien{" +
                "idLogisticien=" + idLogisticien +
                ", nomLogisticien='" + nomLogisticien + '\'' +
                ", prenomLogisticien='" + prenomLogisticien + '\'' +
                ", telLogisticien='" + telLogisticien + '\'' +
                ", mailLogisticien='" + mailLogisticien + '\'' +
                ", passwdLogisticien='" + passwdLogisticien + '\'' +
                ", responsable=" + responsable +
                '}';
    }
}