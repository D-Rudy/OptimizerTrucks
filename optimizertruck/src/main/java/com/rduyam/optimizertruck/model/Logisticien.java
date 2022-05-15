package com.rduyam.optimizertruck.model;

public class Logisticien extends Employe {

    private Responsable responsable;

    private String responsableId;

    public Logisticien() {
    }

    public Responsable getResponsable() {
        return responsable;
    }

    public void setResponsable(Responsable responsable) {
        this.responsable = responsable;
    }

    public String getResponsableId() {
        return responsableId;
    }

    public void setResponsableId(String responsableId) {
        this.responsableId = responsableId;
    }

    @Override
    public String toString() {
        return "Logisticien{" + super.toString()+
                ", responsableId='" + responsableId + '\'' +
                '}';
    }
}
