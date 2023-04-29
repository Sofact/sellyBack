package selly.cash.back.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "view_codigos", schema="sc")
public class ViewCodigos {

    @Id
    @Column(name="cod_id")
    private Long codId;

    @Column(name="cod_codigo")
    private String codCodigo;

    @Column(name="cod_estado")
    private String codEstado;
    @Column(name="cod_fecha")
    private String codFecha;
    @Column(name="cod_url")
    private String codUrl;
    @Column(name="pro_id")
    private String proId;
    @Column(name="pro_descripcion")
    private String proDescripcion;
    @Column(name="usu_id")
    private String usuId;
    @Column(name="user_email")
    private String userEmail;

    public Long getCodId() {
        return codId;
    }

    public void setCodId(Long codId) {
        this.codId = codId;
    }

    public String getCodCodigo() {
        return codCodigo;
    }

    public void setCodCodigo(String codCodigo) {
        this.codCodigo = codCodigo;
    }

    public String getCodEstado() {
        return codEstado;
    }

    public void setCodEstado(String codEstado) {
        this.codEstado = codEstado;
    }

    public String getCodFecha() {
        return codFecha;
    }

    public void setCodFecha(String codFecha) {
        this.codFecha = codFecha;
    }

    public String getCodUrl() {
        return codUrl;
    }

    public void setCodUrl(String codUrl) {
        this.codUrl = codUrl;
    }

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId;
    }

    public String getProDescripcion() {
        return proDescripcion;
    }

    public void setProDescripcion(String proDescripcion) {
        this.proDescripcion = proDescripcion;
    }

    public String getUsuId() {
        return usuId;
    }

    public void setUsuId(String usuId) {
        this.usuId = usuId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
