package com.rduyam.optimizertruck.model;

public class Chauffeur extends Employe {

    private Camion camion;

    private String camionId;

    public Chauffeur() {
    }

    public Camion getCamion() {
        return camion;
    }

    public void setCamion(Camion camion) {
        this.camion = camion;
    }

    public String getCamionId() {
        return camionId;
    }

    public void setCamionId(String camionId) {
        this.camionId = camionId;
    }

    @Override
    public String toString() {
        return "Chauffeur{" + super.toString() +
                ", camionId='" + camionId + '\'' +
                '}';
    }
}
