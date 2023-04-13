package selly.cash.back.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.Immutable;

import java.util.Date;

@Entity
@Table(name="view_pagos", schema="sc")
public class ViewPagos {

    @Id
    @Column(name="pag_id")
    private Long pagId;

    @Column(name="pag_fecha")
    private Date pagFecha;

    @Column(name="pag_valor")
    private float pagValor;

    @Column(name="usu_id")
    private Long usuId;

    @Column(name="usu_nombre")
    private String usuNombre;

    @Column(name="usu_correo")
    private String usuCorreo;

    @Column(name="cli_banco")
    private String cliBanco;

    @Column(name="cli_num_cuenta")
    private String cliNumCuenta;

    @Column(name="cli_tipo_cuenta")
    private String cliTipoCuenta;

    public Long getPagId() {
        return pagId;
    }

    public void setPagId(Long pagId) {
        this.pagId = pagId;
    }

    public Date getPagFecha() {
        return pagFecha;
    }

    public void setPagFecha(Date pagFecha) {
        this.pagFecha = pagFecha;
    }

    public float getPagValor() {
        return pagValor;
    }

    public void setPagValor(float pagValor) {
        this.pagValor = pagValor;
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

    public String getUsuCorreo() {
        return usuCorreo;
    }

    public void setUsuCorreo(String usuCorreo) {
        this.usuCorreo = usuCorreo;
    }

    public String getCliBanco() {
        return cliBanco;
    }

    public void setCliBanco(String cliBanco) {
        this.cliBanco = cliBanco;
    }

    public String getCliNumCuenta() {
        return cliNumCuenta;
    }

    public void setCliNumCuenta(String cliNumCuenta) {
        this.cliNumCuenta = cliNumCuenta;
    }

    public String getCliTipoCuenta() {
        return cliTipoCuenta;
    }

    public void setCliTipoCuenta(String cliTipoCuenta) {
        this.cliTipoCuenta = cliTipoCuenta;
    }
}
