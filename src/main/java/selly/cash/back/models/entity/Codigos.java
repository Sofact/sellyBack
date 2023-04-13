package selly.cash.back.models.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name="codigos", schema="sc")
public class Codigos {

    private static final String SQ_CODIGO = "seq_codigo";
    @Id
    @GeneratedValue(generator=Codigos.SQ_CODIGO, strategy= GenerationType.AUTO)
    @SequenceGenerator(schema="sc", name=Codigos.SQ_CODIGO ,   sequenceName=Codigos.SQ_CODIGO, initialValue=1, allocationSize=1)

    @Column(name="cod_id")
    private Long codId;

    @Column(name="cod_url")
    private String codUrl;
    @Column(name="cod_estado")
    private String codEstado;
    @Column(name="pro_id")
    private Long proId;
    @Column(name="cod_codigo")
    private String codCodigo;
    @Column(name="cod_fecha")
    private Date codFecha;

    @Column(name="usu_id")
    private Long usuId;


    public void setCodId(Long codId) {
        this.codId = codId;
    }

    public Long getCodId() {
        return codId;
    }

    public String getCodUrl() {
        return codUrl;
    }

    public void setCodUrl(String codUrl) {
        this.codUrl = codUrl;
    }

    public String getCodEstado() {
        return codEstado;
    }

    public void setCodEstado(String codEstado) {
        this.codEstado = codEstado;
    }

    public Long getProId() {
        return proId;
    }

    public void setProId(Long proId) {
        this.proId = proId;
    }

    public String getCodCodigo() {
        return codCodigo;
    }

    public void setCodCodigo(String codCodigo) {
        this.codCodigo = codCodigo;
    }

    public Date getCodFecha() {
        return codFecha;
    }

    public void setCodFecha(Date codFecha) {
        this.codFecha = codFecha;
    }

    public Long getUsuId() {
        return usuId;
    }

    public void setUsuId(Long usuId) {
        this.usuId = usuId;
    }
}
