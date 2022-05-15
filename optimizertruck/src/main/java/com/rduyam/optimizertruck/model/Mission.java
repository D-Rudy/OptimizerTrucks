package com.rduyam.optimizertruck.model;

public class Mission {

    private Integer id;

    private String dateHeure;

    private Double qteATransporter;

    private Integer accepterMission;

    private Logisticien logisticien;

    private Chauffeur chauffeur;

    private String chauffeurId;

    private String logisticienId;

    public Mission() {
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

    public String getChauffeurId() {
        return chauffeurId;
    }

    public void setChauffeurId(String chauffeurId) {
        this.chauffeurId = chauffeurId;
    }

    public String getLogisticienId() {
        return logisticienId;
    }

    public void setLogisticienId(String logisticienId) {
        this.logisticienId = logisticienId;
    }

    @Override
    public String toString() {
        return "Mission{" +
                "id=" + id +
                ", dateHeure='" + dateHeure + '\'' +
                ", qteATransporter=" + qteATransporter +
                ", accepterMission=" + accepterMission +
                ", chauffeurId='" + chauffeurId + '\'' +
                ", logisticienId='" + logisticienId + '\'' +
                '}';
    }
}
