package selly.cash.back.models.entity;

import jakarta.persistence.*;

@Entity
@Table(name="parametros", schema="sc")
public class Parametros {

    private static final String SQ_PARAMETRO = "seq_parametro";
    @Id
    @GeneratedValue(generator=Parametros.SQ_PARAMETRO, strategy=GenerationType.AUTO)
    @SequenceGenerator(schema="sc", name=Parametros.SQ_PARAMETRO ,   sequenceName=Parametros.SQ_PARAMETRO, initialValue=1, allocationSize=1)
    @Column(name="par_id")
    private Long parId;

    @Column(name="par_descripcion")
    private String parDescripcion;

    @Column(name="par_valor")
    private Float parValor;

    public Long getParId() {
        return parId;
    }

    public void setParId(Long parId) {
        this.parId = parId;
    }

    public String getparDescripcion() {
        return parDescripcion;
    }

    public void setparDescripcion(String parDescripcion) {
        this.parDescripcion = parDescripcion;
    }

    public Float getParValor() {
        return parValor;
    }

    public void setParValor(Float parValor) {
        this.parValor = parValor;
    }
}
