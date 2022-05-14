package com.optimizertruck.crudapi.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity

@Table(name = "livrer")
public class Livrer {
    @EmbeddedId
    private LivrerId livrerId = new LivrerId();

    @ManyToOne
    @MapsId("camionId")
    @JsonIgnore
    private Camion camion;

    @ManyToOne
    @MapsId("chantierId")
    @JsonIgnore
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
                "Identifiant livraison=" + livrerId +
                ", camion=" + camion +
                ", chantier=" + chantier +
                ", qteLivree=" + qteLivree +
                ", nbTour=" + nbTour +
                '}';
    }
}
