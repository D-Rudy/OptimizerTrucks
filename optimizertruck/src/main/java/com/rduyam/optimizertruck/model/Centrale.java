package com.rduyam.optimizertruck.model;


public class Centrale {

    private Long idCentrale;

    private String nomCentrale;

    private String telCentrale;

    private String adresseCentrale;

    private String cpCentrale;

    private String villeCentrale;

    private String coordonneCentrale;

    private Integer capaciteProd;

    private Responsable responsable;

    public Long getIdCentrale() {
        return idCentrale;
    }

    public void setIdCentrale(Long idCentrale) {
        this.idCentrale = idCentrale;
    }

    public String getNomCentrale() {
        return nomCentrale;
    }

    public void setNomCentrale(String nomCentrale) {
        this.nomCentrale = nomCentrale;
    }

    public String getTelCentrale() {
        return telCentrale;
    }

    public void setTelCentrale(String telCentrale) {
        this.telCentrale = telCentrale;
    }

    public String getAdresseCentrale() {
        return adresseCentrale;
    }

    public void setAdresseCentrale(String adresseCentrale) {
        this.adresseCentrale = adresseCentrale;
    }

    public String getCpCentrale() {
        return cpCentrale;
    }

    public void setCpCentrale(String cpCentrale) {
        this.cpCentrale = cpCentrale;
    }

    public String getVilleCentrale() {
        return villeCentrale;
    }

    public void setVilleCentrale(String villeCentrale) {
        this.villeCentrale = villeCentrale;
    }

    public String getCoordonneCentrale() {
        return coordonneCentrale;
    }

    public void setCoordonneCentrale(String coordonneCentrale) {
        this.coordonneCentrale = coordonneCentrale;
    }

    public Integer getCapaciteProd() {
        return capaciteProd;
    }

    public void setCapaciteProd(Integer capaciteProd) {
        this.capaciteProd = capaciteProd;
    }

    public Responsable getResponsable() {
        return responsable;
    }

    public void setResponsable(Responsable responsable) {
        this.responsable = responsable;
    }
}
