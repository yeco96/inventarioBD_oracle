/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fidelitas.inventario.Modelo;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author yeiso
 */
public class Articulo {
    
    private int codigoArticulo;
    private String descripcion;
    private BigDecimal cantidadMinima;
    private Date fechaCreacion;
    
    private Precio precio;
    private Existencia existencia;

    public Integer getCodigoArticulo() {
        return codigoArticulo;
    }

    public void setCodigoArticulo(int codigoArticulo) {
        this.codigoArticulo = codigoArticulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getCantidadMinima() {
        return cantidadMinima;
    }

    public void setCantidadMinima(BigDecimal cantidadMinima) {
        this.cantidadMinima = cantidadMinima;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }



    public Precio getPrecio() {
        return precio;
    }

    public void setPrecio(Precio precio) {
        this.precio = precio;
    }

    public Existencia getExistencia() {
        return existencia;
    }

    public void setExistencia(Existencia existencia) {
        this.existencia = existencia;
    }
    
    

    public void setALL(int codigoArticulo, String descripcion, BigDecimal cantidadMinima, Date fechaCreacion) {
        this.codigoArticulo = codigoArticulo;
        this.descripcion = descripcion;
        this.cantidadMinima = cantidadMinima;
        this.fechaCreacion = fechaCreacion;
    }
 
    
}
