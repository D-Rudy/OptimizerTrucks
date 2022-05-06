package model;

public class Livrer {
    private Integer idChantier;
    private String immatriculation;
    private Double qteLivree;
    private Integer nbTour;

    public Integer getIdChantier() {
        return idChantier;
    }

    public void setIdChantier(Integer idChantier) {
        this.idChantier = idChantier;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
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
}
