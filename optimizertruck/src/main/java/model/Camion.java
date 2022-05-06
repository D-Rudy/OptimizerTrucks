package model;

public class Camion {

    private String immatriculation;
    private Integer tpsNettoyage;
    private Integer tpsVidange;
    private Integer tpsRemplissage;


    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public Integer getTpsNettoyage() {
        return tpsNettoyage;
    }

    public void setTpsNettoyage(Integer tpsNettoyage) {
        this.tpsNettoyage = tpsNettoyage;
    }

    public Integer getTpsVidange() {
        return tpsVidange;
    }

    public void setTpsVidange(Integer tpsVidange) {
        this.tpsVidange = tpsVidange;
    }

    public Integer getTpsRemplissage() {
        return tpsRemplissage;
    }

    public void setTpsRemplissage(Integer tpsRemplissage) {
        this.tpsRemplissage = tpsRemplissage;
    }
}
