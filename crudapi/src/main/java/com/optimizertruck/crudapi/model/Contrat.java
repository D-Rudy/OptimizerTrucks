package com.optimizertruck.crudapi.model;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "contrat")
public class Contrat {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "date_debut")
    private String dateDebut;

    @Column(name = "date_fin")
    private String dateFin;

    @Column(name = "qte_a_livrer")
    private Double qteALivrer;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "clientId", insertable = false, updatable = false)
    private Client client;

    @OneToOne
    @JoinColumn(name = "chantierId", insertable = false, updatable = false)
    private Chantier chantier;

    private String ClientId;

    private Integer chantierId;



    public Contrat() {
    }

    public String getClientId() {
        return ClientId;
    }

    public void setClientId(String clientId) {
        ClientId = clientId;
    }

    public Integer getChantierId() {
        return chantierId;
    }

    public void setChantierId(Integer chantierId) {
        this.chantierId = chantierId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public Double getQteALivrer() {
        return qteALivrer;
    }

    public void setQteALivrer(Double qteALivrer) {
        this.qteALivrer = qteALivrer;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Chantier getChantier() {
        return chantier;
    }

    public void setChantier(Chantier chantier) {
        this.chantier = chantier;
    }

    @Override
    public String toString() {
        return "Contrat{" +
                "id=" + id +
                ", dateDebut='" + dateDebut + '\'' +
                ", dateFin='" + dateFin + '\'' +
                ", qteALivrer=" + qteALivrer +
                ", client=" + client +
                ", chantier=" + chantier +
                '}';
    }
}
