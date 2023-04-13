package selly.cash.back.models.entity;

import jakarta.persistence.*;

@Entity
@Table(name="usuario", schema="sc")
public class Usuario {

    private static final String SQ_USUARIO = "seq_usuario";
    @Id
    @GeneratedValue(generator=Usuario.SQ_USUARIO, strategy= GenerationType.AUTO)
    @SequenceGenerator(schema="sc", name=Usuario.SQ_USUARIO ,   sequenceName=Usuario.SQ_USUARIO, initialValue=1, allocationSize=1)
    @Column(name="usu_id")
    private Long usuId;

    @Column(name="usu_nombre")

    private String usuNombre;

    @Column(name="usu_correo")
    private String usuCorreo;

    @Column(name="cov_id")
    private Long covId;

    @Column(name="mun_id")
    private Long munId;

    @Column(name="cli_banco")
    private String cliBanco;

    @Column(name="cli_tipo_cuenta")
    private String cliTipoCuenta;

    @Column(name="cli_num_cuenta")
    private String cliNumCuenta;

    @Column(name="cli_password")
    private String cliPassword;

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

    public String getCliBanco() {
        return cliBanco;
    }

    public void setCliBanco(String cliBanco) {
        this.cliBanco = cliBanco;
    }

    public String getCliTipoCuenta() {
        return cliTipoCuenta;
    }

    public void setCliTipoCuenta(String cliTipoCuenta) {
        this.cliTipoCuenta = cliTipoCuenta;
    }

    public String getCliNumCuenta() {
        return cliNumCuenta;
    }

    public void setCliNumCuenta(String cliNumCuenta) {
        this.cliNumCuenta = cliNumCuenta;
    }

    public String getCliPassword() {
        return cliPassword;
    }

    public void setCliPassword(String cliPassword) {
        this.cliPassword = cliPassword;
    }
}
