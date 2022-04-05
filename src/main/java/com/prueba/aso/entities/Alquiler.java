package com.prueba.aso.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the alquiler database table.
 *
 */
@Entity
@Table(name="alquiler")
public class Alquiler implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Temporal(TemporalType.DATE)
    @Column(name="fecha_entrada")
    private Date fechaEntrada;

    @Temporal(TemporalType.DATE)
    @Column(name="fecha_salida")
    private Date fechaSalida;

    private String observacion;

    private double precio;

    //bi-directional many-to-one association to Cliente
    @ManyToOne
    @JoinColumn(name="id_cliente")
    private Cliente cliente;

    //bi-directional many-to-one association to Habitacion
    @ManyToOne
    @JoinColumn(name="id_habitacion")
    private Habitacion habitacion;

    //bi-directional many-to-one association to Vendedor
    @ManyToOne
    @JoinColumn(name="id_vendedor")
    private Vendedor vendedor;

    public Alquiler() {
    }

    public Date getFechaEntrada() {
        return this.fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Date getFechaSalida() {
        return this.fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getObservacion() {
        return this.observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public double getPrecio() {
        return this.precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Habitacion getHabitacion() {
        return this.habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public Vendedor getVendedor() {
        return this.vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

}