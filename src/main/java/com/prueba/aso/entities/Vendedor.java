package com.prueba.aso.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the vendedor database table.
 *
 */
@Entity
@Table(name="vendedor")
public class Vendedor implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private String direccion;

    private String nombre;

    private String observacion;

    private String telefono;

    //bi-directional many-to-one association to Alquiler
    @OneToMany(mappedBy="vendedor")
    private List<Alquiler> alquilers;

    public Vendedor() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getObservacion() {
        return this.observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Alquiler> getAlquilers() {
        return this.alquilers;
    }

    public void setAlquilers(List<Alquiler> alquilers) {
        this.alquilers = alquilers;
    }

    public Alquiler addAlquiler(Alquiler alquiler) {
        getAlquilers().add(alquiler);
        alquiler.setVendedor(this);

        return alquiler;
    }

    public Alquiler removeAlquiler(Alquiler alquiler) {
        getAlquilers().remove(alquiler);
        alquiler.setVendedor(null);

        return alquiler;
    }

}
