package selly.cash.back.models.entity;

import jakarta.persistence.*;

@Entity
@Table(name="municipio", schema="sc")
public class Municipio {

    private static final String SQ_MUNICIPIO = "seq_municipio";
    @Id
    @GeneratedValue(generator=Municipio.SQ_MUNICIPIO, strategy= GenerationType.AUTO)
    @SequenceGenerator(schema="sc", name=Municipio.SQ_MUNICIPIO ,   sequenceName=Municipio.SQ_MUNICIPIO, initialValue=1, allocationSize=1)
    @Column(name="mun_id")
    private Long munId;

    @Column(name="mun_descripcion")
    private String munDescripcion;

    @Column(name="mun_codigo")
    private String munCodigo;

    @Column(name="mun_departamento")
    private String munDepartamento;

    public Long getMunId() {
        return munId;
    }

    public void setMunId(Long munId) {
        this.munId = munId;
    }

    public String getMunDescripcion() {
        return munDescripcion;
    }

    public void setMunDescripcion(String munDescripcion) {
        this.munDescripcion = munDescripcion;
    }

    public String getMunCodigo() {
        return munCodigo;
    }

    public void setMunCodigo(String munCodigo) {
        this.munCodigo = munCodigo;
    }

    public String getMunDepartamento() {
        return munDepartamento;
    }

    public void setMunDepartamento(String munDepartamento) {
        this.munDepartamento = munDepartamento;
    }
}
