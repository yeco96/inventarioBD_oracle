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
 * @author Josue
 */
public class CompraDetalle {
    private int codigoCompra;
    private int codigoArticulo;
    private BigDecimal cantidadCompra;
    private BigDecimal montoCosto;
    private Date fechaVencimiento;

    public int getCodigoCompra() {
        return codigoCompra;
    }

    public void setCodigoCompra(int codigoCompra) {
        this.codigoCompra = codigoCompra;
    }

    public int getCodigoArticulo() {
        return codigoArticulo;
    }

    public void setCodigoArticulo(int codigoArticulo) {
        this.codigoArticulo = codigoArticulo;
    }

    public BigDecimal getCantidadCompra() {
        return cantidadCompra;
    }

    public void setCantidadCompra(BigDecimal cantidadCompra) {
        this.cantidadCompra = cantidadCompra;
    }

    public BigDecimal getMontoCosto() {
        return montoCosto;
    }

    public void setMontoCosto(BigDecimal montoCosto) {
        this.montoCosto = montoCosto;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
    
    
    
}
