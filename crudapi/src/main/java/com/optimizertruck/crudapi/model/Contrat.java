package com.optimizertruck.crudapi.model;

import javax.persistence.*;

@Entity
@Table(name = "contrat")
public class Contrat {
    @Id
    @GeneratedValue
    @Column(name = "num_contrat", nullable = false)
    private Integer numContrat;

    @Column(name = "date_debut_contrat")
    private String dateDebutContrat;

    @Column(name = "date_fin_contrat")
    private String dateFinContrat;

    @Column(name = "qte_a_livrer_contrat")
    private Double qteALivrerContrat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_client", nullable = false)
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_chantier", nullable = false)
    private Chantier chantier;

    public Contrat() {
    }

    public Integer getNumContrat() {
        return numContrat;
    }

    public void setNumContrat(Integer numContrat) {
        this.numContrat = numContrat;
    }

    public String getDateDebutContrat() {
        return dateDebutContrat;
    }

    public void setDateDebutContrat(String dateDebutContrat) {
        this.dateDebutContrat = dateDebutContrat;
    }

    public String getDateFinContrat() {
        return dateFinContrat;
    }

    public void setDateFinContrat(String dateFinContrat) {
        this.dateFinContrat = dateFinContrat;
    }

    public Double getQteALivrerContrat() {
        return qteALivrerContrat;
    }

    public void setQteALivrerContrat(Double qteALivrerContrat) {
        this.qteALivrerContrat = qteALivrerContrat;
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
        return "ContratDao{" +
                "numContrat=" + numContrat +
                ", dateDebutContrat='" + dateDebutContrat + '\'' +
                ", dateFinContrat='" + dateFinContrat + '\'' +
                ", qteALivrerContrat=" + qteALivrerContrat +
                ", client=" + client +
                ", chantier=" + chantier +
                '}';
    }
}