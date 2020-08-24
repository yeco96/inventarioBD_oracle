/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fidelitas.inventario.Modelo;

import java.util.Date;

/**
 *
 * @author yeiso
 */
public class Proveedor {

    private int codigoProveedor;
    private String nombre;
    private Date fechaIngreso;

    public void setALL(Integer codigoProveedor, String nombre, Date fechaIngreso) {
        this.codigoProveedor = codigoProveedor;
        this.nombre = nombre;
        this.fechaIngreso = fechaIngreso;
    }

    public Integer getCodigoProveedor() {
        return codigoProveedor;
    }

    public void setCodigoProveedor(Integer codigoProveedor) {
        this.codigoProveedor = codigoProveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

}
