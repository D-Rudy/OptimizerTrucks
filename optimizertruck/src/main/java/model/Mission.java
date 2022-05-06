package model;

public class Mission {
    private Integer numMission;
    private String dateHeureMission;
    private Double qteATransporter;
    private Integer accepterMission;
    private String matriculeLogisticien;
    private String matriculeChauffeur;


    public Integer getNumMission() {
        return numMission;
    }

    public void setNumMission(Integer numMission) {
        this.numMission = numMission;
    }

    public String getDateHeureMission() {
        return dateHeureMission;
    }

    public void setDateHeureMission(String dateHeureMission) {
        this.dateHeureMission = dateHeureMission;
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

    public String getMatriculeLogisticien() {
        return matriculeLogisticien;
    }

    public void setMatriculeLogisticien(String matriculeLogisticien) {
        this.matriculeLogisticien = matriculeLogisticien;
    }

    public String getMatriculeChauffeur() {
        return matriculeChauffeur;
    }

    public void setMatriculeChauffeur(String matriculeChauffeur) {
        this.matriculeChauffeur = matriculeChauffeur;
    }
}
