package com.rduyam.optimizertruck.model;


public class LivrerId {

    private Integer chantierId;

    private String camionId;

    public LivrerId() {
    }

    public Integer getChantierId() {
        return chantierId;
    }

    public void setChantierId(Integer chantierId) {
        this.chantierId = chantierId;
    }

    public String getCamionId() {
        return camionId;
    }

    public void setCamionId(String camionId) {
        this.camionId = camionId;
    }

    @Override
    public String toString() {
        return "LivrerId{" +
                "chantierId=" + chantierId +
                ", camionId='" + camionId + '\'' +
                '}';
    }
}
