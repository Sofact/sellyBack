package selly.cash.back.models.entity;

import jakarta.persistence.*;

@Entity
@Table(name="producto", schema="sc")
public class Producto {

    private static final String SQ_PRODUCTO = "seq_producto";
    @Id
    @GeneratedValue(generator=Producto.SQ_PRODUCTO, strategy=GenerationType.AUTO)
    @SequenceGenerator(schema="sc", name=Producto.SQ_PRODUCTO ,   sequenceName=Producto.SQ_PRODUCTO, initialValue=1, allocationSize=1)
    @Column(name="pro_id")
    private Long proId;
    @Column(name="pro_descripcion")
    private String proDescripcion;
    @Column(name="pro_referencia")
    private String proReferencia;
    @Column(name="pro_valor")
    private float proValor;
    @Column(name="mar_id")
    private Long marId;
    @Column(name="lin_id")
    private Long linId;

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

    public String getProReferencia() {
        return proReferencia;
    }

    public void setProReferencia(String proReferencia) {
        this.proReferencia = proReferencia;
    }

    public float getProValor() {
        return proValor;
    }

    public void setProValor(float proValor) {
        this.proValor = proValor;
    }

    public Long getMarId() {
        return marId;
    }

    public void setMarId(Long marId) {
        this.marId = marId;
    }

    public Long getLinId() {
        return linId;
    }

    public void setLinId(Long linId) {
        this.linId = linId;
    }
}
