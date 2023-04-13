package selly.cash.back.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.Immutable;

import java.util.Date;

@Entity
@Table(name = "view_comision", schema="sc")
public class ViewComision {
    @Id
    @Column(name="com_id")
    private Long comId;
    @Column(name="com_estado")
    private String comEstado;
    @Column(name="com_fecha")
    private Date comFecha;
    @Column(name="com_fecha_pago")
    private Date comFechaPago;
    @Column(name="com_valor")
    private float comValor;
    @Column(name="pro_id")
    private Long proId;
    @Column(name="pro_descripcion")
    private String proDescripcion;
    @Column(name="usu_id")
    private Long usuId;

    public void setComId(Long comId) {
        this.comId = comId;
    }

    public Long getComId() {
        return comId;
    }

    public String getComEstado() {
        return comEstado;
    }

    public void setComEstado(String comEstado) {
        this.comEstado = comEstado;
    }

    public Date getComFecha() {
        return comFecha;
    }

    public void setComFecha(Date comFecha) {
        this.comFecha = comFecha;
    }

    public Date getComFechaPago() {
        return comFechaPago;
    }

    public void setComFechaPago(Date comFechaPago) {
        this.comFechaPago = comFechaPago;
    }

    public float getComValor() {
        return comValor;
    }

    public void setComValor(float comValor) {
        this.comValor = comValor;
    }

    public Long getProId() {
        return proId;
    }

    public void setProId(Long proId) {
        this.proId = proId;
    }

    public String getProDescripcion() {
        return proDescripcion;
    }

    public void setProDescripcion(String proDescripcion) {
        this.proDescripcion = proDescripcion;
    }

    public Long getUsuId() {
        return usuId;
    }

    public void setUsuId(Long usuId) {
        this.usuId = usuId;
    }
}
