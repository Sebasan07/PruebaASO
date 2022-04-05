package com.prueba.aso.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_habitacion database table.
 *
 */
@Entity
@Table(name="tipo_habitacion")
public class TipoHabitacion implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private String nombre;

    //bi-directional many-to-one association to Habitacion
    @OneToMany(mappedBy="tipoHabitacionBean")
    private List<Habitacion> habitacions;

    public TipoHabitacion() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Habitacion> getHabitacions() {
        return this.habitacions;
    }

    public void setHabitacions(List<Habitacion> habitacions) {
        this.habitacions = habitacions;
    }

    public Habitacion addHabitacion(Habitacion habitacion) {
        getHabitacions().add(habitacion);
        habitacion.setTipoHabitacionBean(this);

        return habitacion;
    }

    public Habitacion removeHabitacion(Habitacion habitacion) {
        getHabitacions().remove(habitacion);
        habitacion.setTipoHabitacionBean(null);

        return habitacion;
    }

}