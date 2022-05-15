package com.rduyam.optimizertruck.model;

public class Contrat {

        private Integer id;

        private String dateDebut;

        private String dateFin;

        private Double qteALivrer;

        private Client client;

        private Chantier chantier;

        private String ClientId;

        private Integer chantierId;

    public Contrat() {
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

    @Override
    public String toString() {
        return "Contrat{" +
                "id=" + id +
                ", dateDebut='" + dateDebut + '\'' +
                ", dateFin='" + dateFin + '\'' +
                ", qteALivrer=" + qteALivrer +
                ", ClientId='" + ClientId + '\'' +
                ", chantierId=" + chantierId +
                '}';
    }
}
