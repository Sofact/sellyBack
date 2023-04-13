package selly.cash.back.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.Immutable;

@Entity
@Table(name="view_pagos_grouped", schema="sc")
public class ViewPagosGrouped {

    @Id
    @Column(name="usu_id")
    private Long usuId;

    @Column(name="com_estado")
    private String convEstado;

    @Column(name="usu_correo")
    private String usuCorreo;

    @Column(name="usu_nombre")
    private String usuNombre;

    @Column(name="cli_banco")
    private String cliBanco;

    @Column(name="cli_num_cuenta")
    private String cliNumCuenta;

    @Column(name="cli_tipo_cuenta")
    private String cliTipoCuenta;

    @Column(name="cov_nombre")
    private String covNombre;

    @Column(name="cov_id")
    private String covId;


    @Column(name="sum")
    private String sumValor;

    public Long getUsuId() {
        return usuId;
    }

    public void setUsuId(Long usuId) {
        this.usuId = usuId;
    }

    public String getConvEstado() {
        return convEstado;
    }

    public void setConvEstado(String convEstado) {
        this.convEstado = convEstado;
    }

    public String getUsuCorreo() {
        return usuCorreo;
    }

    public void setUsuCorreo(String usuCorreo) {
        this.usuCorreo = usuCorreo;
    }

    public String getUsuNombre() {
        return usuNombre;
    }

    public void setUsuNombre(String usuNombre) {
        this.usuNombre = usuNombre;
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

    public String getCovNombre() {
        return covNombre;
    }

    public void setCovNombre(String covNombre) {
        this.covNombre = covNombre;
    }

    public String getCovId() {
        return covId;
    }

    public void setCovId(String covId) {
        this.covId = covId;
    }

    public String getSumValor() {
        return sumValor;
    }

    public void setSumValor(String sumValor) {
        this.sumValor = sumValor;
    }
}
