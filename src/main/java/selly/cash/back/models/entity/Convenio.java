package selly.cash.back.models.entity;

import jakarta.persistence.*;

@Entity
@Table(name="convenio", schema="sc")
public class Convenio {

    private static final String SQ_CONVENIO = "seq_convenio";
    @Id
    @GeneratedValue(generator=Convenio.SQ_CONVENIO, strategy= GenerationType.AUTO)
    @SequenceGenerator(schema="sc", name=Convenio.SQ_CONVENIO ,   sequenceName=Convenio.SQ_CONVENIO, initialValue=1, allocationSize=1)
    @Column(name="conv_id")
    private Long covId;

    @Column(name="cov_nombre")
    private String covNombre;

    @Column(name="cov_estado")
    private String cov_estado;

    public Long getCovId() {
        return covId;
    }

    public void setCovId(Long covId) {
        this.covId = covId;
    }

    public String getCovNombre() {
        return covNombre;
    }

    public void setCovNombre(String covNombre) {
        this.covNombre = covNombre;
    }

    public String getCov_estado() {
        return cov_estado;
    }

    public void setCov_estado(String cov_estado) {
        this.cov_estado = cov_estado;
    }
}
