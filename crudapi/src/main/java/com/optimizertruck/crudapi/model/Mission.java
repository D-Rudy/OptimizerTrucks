package com.optimizertruck.crudapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "mission")
public class Mission {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "date_heure")
    private String dateHeure;

    @Column(name = "qte_a_transporter")
    private Double qteATransporter;

    @Column(name = "accepter_mission")
    private Integer accepterMission;

    @ManyToOne
    @JoinColumn(name = "logisticienId", insertable = false, updatable = false)
    private Logisticien logisticien;
    @ManyToOne
    @JoinColumn(name = "chauffeurId", insertable = false, updatable = false)
    private Chauffeur chauffeur;

    private String chauffeurId;

    private String logisticienId;


    public Mission() {
    }


    public String getLogisticienId() {
        return logisticienId;
    }

    public void setLogisticienId(String logisticienId) {
        this.logisticienId = logisticienId;
    }

    public String getChauffeurId() {
        return chauffeurId;
    }

    public void setChauffeurId(String chauffeurId) {
        this.chauffeurId = chauffeurId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDateHeure() {
        return dateHeure;
    }

    public void setDateHeure(String dateHeure) {
        this.dateHeure = dateHeure;
    }

    public Double getQteATransporter() {
        return qteATransporter;
    }

    public void setQteATransporter(Double qteATransporter) {
        this.qteATransporter = qteATransporter;
    }

    public Integer getAccepterMission() {
        return accepterMission;
    }

    public void setAccepterMission(Integer accepterMission) {
        this.accepterMission = accepterMission;
    }

    public Logisticien getLogisticien() {
        return logisticien;
    }

    public void setLogisticien(Logisticien logisticien) {
        this.logisticien = logisticien;
    }

    public Chauffeur getChauffeur() {
        return chauffeur;
    }

    public void setChauffeur(Chauffeur chauffeur) {
        this.chauffeur = chauffeur;
    }

    @Override
    public String toString() {
        return "Mission{" +
                "id=" + id +
                ", date et heure='" + dateHeure + '\'' +
                ", qteATransporter=" + qteATransporter +
                ", accepterMission=" + accepterMission +
                ", logisticien=" + logisticien +
                ", chauffeur=" + chauffeur +
                '}';
    }
}
