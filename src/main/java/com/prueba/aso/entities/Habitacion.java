package com.prueba.aso.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the habitacion database table.
 *
 */
@Entity
@Table(name="habitacion")
public class Habitacion implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private String descripcion;

    private int numero;

    @Column(name="numero_camas")
    private int numeroCamas;

    //bi-directional many-to-one association to Alquiler
    @OneToMany(mappedBy="habitacion")
    private List<Alquiler> alquilers;

    //bi-directional many-to-one association to TipoHabitacion
    @ManyToOne
    @JoinColumn(name="tipo_habitacion")
    private TipoHabitacion tipoHabitacionBean;

    public Habitacion() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getNumeroCamas() {
        return this.numeroCamas;
    }

    public void setNumeroCamas(int numeroCamas) {
        this.numeroCamas = numeroCamas;
    }

    public List<Alquiler> getAlquilers() {
        return this.alquilers;
    }

    public void setAlquilers(List<Alquiler> alquilers) {
        this.alquilers = alquilers;
    }

    public Alquiler addAlquiler(Alquiler alquiler) {
        getAlquilers().add(alquiler);
        alquiler.setHabitacion(this);

        return alquiler;
    }

    public Alquiler removeAlquiler(Alquiler alquiler) {
        getAlquilers().remove(alquiler);
        alquiler.setHabitacion(null);

        return alquiler;
    }

    public TipoHabitacion getTipoHabitacionBean() {
        return this.tipoHabitacionBean;
    }

    public void setTipoHabitacionBean(TipoHabitacion tipoHabitacionBean) {
        this.tipoHabitacionBean = tipoHabitacionBean;
    }

}