package selly.cash.back.models.entity;

import jakarta.persistence.*;

@Entity
@Table(name="marcas", schema="sc")
public class Marcas {

    private static final String SQ_MARCA = "seq_marca";
    @Id
    @GeneratedValue(generator=Marcas.SQ_MARCA, strategy= GenerationType.AUTO)
    @SequenceGenerator(schema="sc", name=Marcas.SQ_MARCA ,   sequenceName=Marcas.SQ_MARCA, initialValue=1, allocationSize=1)
    @Column(name="mar_id")
    private Long marId;

    @Column(name="mar_descripcion")
    private String marDescripcion;

    @Column(name="mar_estado")
    private String marEstado;

    public void setmarId(Long marId) {
        this.marId = marId;
    }

    public Long getmarId() {
        return marId;
    }

    public String getMarDescripcion() {
        return marDescripcion;
    }

    public void setMarDescripcion(String marDescripcion) {
        this.marDescripcion = marDescripcion;
    }

    public String getMarEstado() {
        return marEstado;
    }

    public void setMarEstado(String marEstado) {
        this.marEstado = marEstado;
    }
}
