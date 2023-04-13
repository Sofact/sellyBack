package selly.cash.back.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.Immutable;

@Entity
@Table(name="view_perfil", schema="sc")
public class ViewPerfil {

    @Id
    @Column(name="usu_id")
    private Long usuId;

    @Column(name="cov_id")
    private Long covId;

    @Column(name="mun_id")
    private Long munId;

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

    @Column(name="mun_descripcion")
    private String munDescripcion;

    public Long getusuId() {
        return usuId;
    }

    public void setusuId(Long usuId) {
        this.usuId = usuId;
    }

    public Long getCovId() {
        return covId;
    }

    public void setCovId(Long covId) {
        this.covId = covId;
    }

    public Long getMunId() {
        return munId;
    }

    public void setMunId(Long munId) {
        this.munId = munId;
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

    public String getcovNombre() {
        return covNombre;
    }

    public void setcovNombre(String covNombre) {
        this.covNombre = covNombre;
    }

    public String getMunDescripcion() {
        return munDescripcion;
    }

    public void setmunDescripcion(String munDescripcion) {
        this.munDescripcion = munDescripcion;
    }
}
