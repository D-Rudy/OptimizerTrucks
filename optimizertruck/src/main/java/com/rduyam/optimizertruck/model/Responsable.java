package com.rduyam.optimizertruck.model;

import java.util.List;

public class Responsable extends Employe {

    private List<Logisticien> logisticienList;

    private Centrale centrale;

    private String centraleId;

    public Responsable() {
    }

    public List<Logisticien> getLogisticienList() {
        return logisticienList;
    }

    public void setLogisticienList(List<Logisticien> logisticienList) {
        this.logisticienList = logisticienList;
    }

    public Centrale getCentrale() {
        return centrale;
    }

    public void setCentrale(Centrale centrale) {
        this.centrale = centrale;
    }

    public String getCentraleId() {
        return centraleId;
    }

    public void setCentraleId(String centraleId) {
        this.centraleId = centraleId;
    }

    @Override
    public String toString() {
        return "Responsable{" + super.toString() +
                ", centraleId='" + centraleId + '\'' +
                "logisticienList=" + logisticienList +
                '}';
    }
}
