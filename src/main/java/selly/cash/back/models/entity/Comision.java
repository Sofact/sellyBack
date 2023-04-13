package selly.cash.back.models.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="comision", schema="sc")
public class Comision {

    private static final String SQ_COMISION = "seq_comision";
    @Id
    @GeneratedValue(generator=Comision.SQ_COMISION, strategy= GenerationType.AUTO)
    @SequenceGenerator(schema="sc", name=Comision.SQ_COMISION ,   sequenceName=Comision.SQ_COMISION, initialValue=1, allocationSize=1)

    @Column(name="com_id")
    private Long comId;
    @Column(name="com_fecha")
    private Date comFecha;
    @Column(name="com_fecha_pago")
    private Date comFechaPago;
    @Column(name="pro_id")
    private Long proId;
    @Column(name="com_valor")
    private float comValor;
    @Column(name="com_estado")
    private String comEstado;
    @Column(name="usu_id")
    private Long usuId;

    @Column(name="cli_id")
    private Long cliId;



    public Long getComId() {
        return comId;
    }

    public void setComId(Long comId) {
        this.comId = comId;
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

    public Long getProId() {
        return proId;
    }

    public void setProId(Long proId) {
        this.proId = proId;
    }

    public float getComValor() {
        return comValor;
    }

    public void setComValor(float comValor) {
        this.comValor = comValor;
    }

    public String getComEstado() {
        return comEstado;
    }

    public void setComEstado(String comEstado) {
        this.comEstado = comEstado;
    }

    public Long getUsuId() {
        return usuId;
    }

    public void setUsuId(Long usuId) {
        this.usuId = usuId;
    }

    public Long getCliId() {
        return cliId;
    }

    public void setCliId(Long cliId) {
        this.cliId = cliId;
    }
}
