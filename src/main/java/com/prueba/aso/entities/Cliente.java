package com.prueba.aso.entities;
import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the cliente database table.
 *
 */
@Entity
@Table(name="cliente")
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String documento;
    private String nombre;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;

    @Column(name = "lugar_nacimiento")
    private String lugarNacimiento;

    //bi-directional many-to-one association to Alquiler
    @OneToMany(mappedBy = "cliente")
    private List<Alquiler> alquilers;

    public Cliente() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDocumento() {
        return this.documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Date getFechaNacimiento() {
        return this.fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getLugarNacimiento() {
        return this.lugarNacimiento;
    }

    public void setLugarNacimiento(String lugarNacimiento) {
        this.lugarNacimiento = lugarNacimiento;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Alquiler> getAlquilers() {
        return this.alquilers;
    }

    public void setAlquilers(List<Alquiler> alquilers) {
        this.alquilers = alquilers;
    }

    public Alquiler addAlquiler(Alquiler alquiler) {
        getAlquilers().add(alquiler);
        alquiler.setCliente(this);

        return alquiler;
    }

    public Alquiler removeAlquiler(Alquiler alquiler) {
        getAlquilers().remove(alquiler);
        alquiler.setCliente(null);

        return alquiler;
    }

}