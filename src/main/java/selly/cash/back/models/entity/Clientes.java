package selly.cash.back.models.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="clientes", schema="sc")
public class Clientes {

    private static final String SQ_CLIENTE = "seq_cliente";
    @Id
    @GeneratedValue(generator=Clientes.SQ_CLIENTE, strategy=GenerationType.AUTO)
    @SequenceGenerator(schema="sc", name=Clientes.SQ_CLIENTE ,   sequenceName=Clientes.SQ_CLIENTE, initialValue=1, allocationSize=1)
    @Column(name="cli_id")
    private Long cliId;
    @Column(name="cli_nombre")
    private String cliNombre;

    @Column(name="cli_correo")
    private String cliCorreo;
    @Column(name="cli_cedula")
    private String cliCedula;
    @Column(name="cli_celular")
    private String cliCelular;
    @Column(name="cli_fecha")
    private Date cliFecha;
    @Column(name="cli_sexo")
    private String cliSexo;

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

    public String getCliCorreo() {
        return cliCorreo;
    }

    public void setCliCorreo(String cliCorreo) {
        this.cliCorreo = cliCorreo;
    }

    public String getCliCelular() {
        return cliCelular;
    }

    public void setCliCelular(String cliCelular) {
        this.cliCelular = cliCelular;
    }

    public String getCliCedula() {
        return cliCedula;
    }

    public void setCliCedula(String cliCedula) {
        this.cliCedula = cliCedula;
    }

    public Date getCliFecha() {
        return cliFecha;
    }

    public void setCliFecha(Date cliFecha) {
        this.cliFecha = cliFecha;
    }

    public String getCliSexo() {
        return cliSexo;
    }

    public void setCliSexo(String cliSexo) {
        this.cliSexo = cliSexo;
    }
}
