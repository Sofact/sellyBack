package selly.cash.back.models.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="pagos", schema="sc")
public class Pagos {

    private static final String SQ_PAGOS = "seq_pagos";
    @Id
    @GeneratedValue(generator=Pagos.SQ_PAGOS, strategy= GenerationType.AUTO)
    @SequenceGenerator(schema="sc", name=Pagos.SQ_PAGOS ,   sequenceName=Pagos.SQ_PAGOS, initialValue=1, allocationSize=1)
    @Column(name="pag_id")
    private Long pagId;

    @Column(name="pag_valor")
    private float pagValor;

    @Column(name="pag_fecha")
    private Date pagFecha;

    @Column(name="usu_id")
    private Long usuId;

    public Long getPagId() {
        return pagId;
    }

    public void setPagId(Long pagId) {
        this.pagId = pagId;
    }

    public float getPagValor() {
        return pagValor;
    }

    public void setPagValor(float pagValor) {
        this.pagValor = pagValor;
    }

    public Date getPagFecha() {
        return pagFecha;
    }

    public void setPagFecha(Date pagFecha) {
        this.pagFecha = pagFecha;
    }

    public Long getUsuId() {
        return usuId;
    }

    public void setUsuId(Long usuId) {
        this.usuId = usuId;
    }
}
