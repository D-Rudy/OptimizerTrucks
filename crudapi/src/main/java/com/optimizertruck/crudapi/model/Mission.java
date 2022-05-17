package com.optimizertruck.crudapi.model;

import javax.persistence.*;

@Entity
@Table(name = "mission")
public class Mission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mission", nullable = false)
    private Long idMission;

    @Column(name = "date_heure_mission")
    private String dateHeureMission;

    @Column(name = "qte_a_transporter_mission")
    private Double qteATransporterMission;

    @Column(name = "accepter_mission")
    private Integer accepterMission;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_logisticien", nullable = false)
    private Logisticien logisticien;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_chauffeur", nullable = false)
    private Chauffeur chauffeur;


    public Mission() {
    }

    public Long getIdMission() {
        return idMission;
    }

    public void setIdMission(Long idMission) {
        this.idMission = idMission;
    }

    public String getDateHeureMission() {
        return dateHeureMission;
    }

    public void setDateHeureMission(String dateHeureMission) {
        this.dateHeureMission = dateHeureMission;
    }

    public Double getQteATransporterMission() {
        return qteATransporterMission;
    }

    public void setQteATransporterMission(Double qteATransporterMission) {
        this.qteATransporterMission = qteATransporterMission;
    }

    public Integer getAccepterMission() {
        return accepterMission;
    }

    public void setAccepterMission(Integer accepterMissionMission) {
        this.accepterMission = accepterMissionMission;
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
                "idMission=" + idMission +
                ", dateHeureMission='" + dateHeureMission + '\'' +
                ", qteATransporterMission=" + qteATransporterMission +
                ", accepterMissionMission=" + accepterMission +
                ", logisticien=" + logisticien +
                ", chauffeur=" + chauffeur +
                '}';
    }
}