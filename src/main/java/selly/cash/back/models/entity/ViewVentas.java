package selly.cash.back.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.Immutable;

import java.util.Date;

@Entity
@Table(name="view_ventas", schema="sc")
public class ViewVentas {

    @Id
    @Column(name="com_id")
    private Long comId;

    @Column(name="com_fecha")
    private Date comFecha;

    @Column(name="com_valor")
    private float comValor;

    @Column(name="user_id")
    private Long usuId;

    @Column(name="user_email")
    private String usuNombre;

    @Column(name="cli_id")
    private Long cliId;

    @Column(name="cli_nombre")
    private String cliNombre;

    @Column(name="mun_descripcion")
    private String munDescripcion;

    @Column(name="cov_nombre")
    private String covNombre;

    public Long getComId() {
        return comId;
    }

    public void setComId(Long comId) {
        this.comId = comId;
    }

    public Date getComFecha() {
        return comFecha;
    }

    public void setComFecha(Date comFecha) {
        this.comFecha = comFecha;
    }

    public float getComValor() {
        return comValor;
    }

    public void setComValor(float comValor) {
        this.comValor = comValor;
    }

    public Long getUsuId() {
        return usuId;
    }

    public void setUsuId(Long usuId) {
        this.usuId = usuId;
    }

    public String getUsuNombre() {
        return usuNombre;
    }

    public void setUsuNombre(String usuNombre) {
        this.usuNombre = usuNombre;
    }

    public Long getCliId() {
        return cliId;
    }

    public void setCliId(Long cliId) {
        this.cliId = cliId;
    }

    public String getCliNombre() {
        return cliNombre;
    }

    public void setCliNombre(String cliNombre) {
        this.cliNombre = cliNombre;
    }

    public String getMunDescripcion() {
        return munDescripcion;
    }

    public void setMunDescripcion(String munDescripcion) {
        this.munDescripcion = munDescripcion;
    }

    public String getCovNombre() {
        return covNombre;
    }

    public void setCovNombre(String covNombre) {
        this.covNombre = covNombre;
    }
}
