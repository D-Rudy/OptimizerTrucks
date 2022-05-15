package com.rduyam.optimizertruck.model;

import org.springframework.beans.factory.annotation.Autowired;

public class Livrer {

    @Autowired
    private LivrerId livrerId = new LivrerId();


    private Camion camion;

    private Chantier chantier;


    private Double qteLivree;

    private Integer nbTour;

    public Livrer() {
    }

    public LivrerId getLivrerId() {
        return livrerId;
    }

    public void setLivrerId(LivrerId livrerId) {
        this.livrerId = livrerId;
    }

    public Camion getCamion() {
        return camion;
    }

    public void setCamion(Camion camion) {
        this.camion = camion;
    }

    public Chantier getChantier() {
        return chantier;
    }

    public void setChantier(Chantier chantier) {
        this.chantier = chantier;
    }

    public Double getQteLivree() {
        return qteLivree;
    }

    public void setQteLivree(Double qteLivree) {
        this.qteLivree = qteLivree;
    }

    public Integer getNbTour() {
        return nbTour;
    }

    public void setNbTour(Integer nbTour) {
        this.nbTour = nbTour;
    }

    @Override
    public String toString() {
        return "Livrer{" +
                "livrerId=" + livrerId +
                ", camion=" + camion +
                ", chantier=" + chantier +
                ", qteLivree=" + qteLivree +
                ", nbTour=" + nbTour +
                '}';
    }
}
