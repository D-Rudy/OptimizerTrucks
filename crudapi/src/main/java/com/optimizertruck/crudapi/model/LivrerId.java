package com.optimizertruck.crudapi.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;
@Embeddable
public class LivrerId implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "chantier",insertable = false, updatable = false)
    private Integer chantierId;
    @Column(name = "camion",insertable = false, updatable = false)
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LivrerId)) return false;
        LivrerId livrerId = (LivrerId) o;
        return Objects.equals(chantierId, livrerId.chantierId) && Objects.equals(camionId, livrerId.camionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chantierId, camionId);
    }

    @Override
    public String toString() {
        return "LivrerId{" +
                "chantierId=" + chantierId +
                ", camionId='" + camionId + '\'' +
                '}';
    }
}
