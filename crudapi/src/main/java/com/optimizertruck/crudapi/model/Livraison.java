package com.optimizertruck.crudapi.model;


import javax.persistence.*;

@Entity
@Table(name = "livraison")
public class Livraison {

    @Id
    @GeneratedValue
    @Column(name = "id_livraison", nullable = false)
    private Integer id;

    @Column(name = "qte_livree")
    private Double qteLivree;

    @Column(name = "nb_tour")
    private Integer nbTour;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_chantier", nullable = false)
    private Chantier chantier;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_camion", nullable = false)
    private Camion camion;

    public Livraison() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Chantier getChantier() {
        return chantier;
    }

    public void setChantier(Chantier chantier) {
        this.chantier = chantier;
    }

    public Camion getCamion() {
        return camion;
    }

    public void setCamion(Camion camion) {
        this.camion = camion;
    }

    @Override
    public String toString() {
        return "Livraison{" +
                "id=" + id +
                ", qteLivree=" + qteLivree +
                ", nbTour=" + nbTour +
                ", chantier=" + chantier +
                ", camion=" + camion +
                '}';
    }
}