package model;

public class Contrat {
    private String numContrat;
    private String dateDebutContrat;
    private String dateFinContrat;
    private Double qteALivrer;
    private String idClient;
    private Integer idChantier;


    public String getNumContrat() {
        return numContrat;
    }

    public void setNumContrat(String numContrat) {
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

    public Double getQteALivrer() {
        return qteALivrer;
    }

    public void setQteALivrer(Double qteALivrer) {
        this.qteALivrer = qteALivrer;
    }

    public String getIdClient() {
        return idClient;
    }

    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }

    public Integer getIdChantier() {
        return idChantier;
    }

    public void setIdChantier(Integer idChantier) {
        this.idChantier = idChantier;
    }
}
