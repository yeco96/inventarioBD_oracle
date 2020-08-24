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
public class Precio {
    private int codigoArticulo;
    private BigDecimal precio;
    private BigDecimal tarifaImpuesto;
    private BigDecimal porcentajeUtilidad;
    private BigDecimal montoCosto;

    public int getCodigoArticulo() {
        return codigoArticulo;
    }

    public void setCodigoArticulo(int codigoArticulo) {
        this.codigoArticulo = codigoArticulo;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public BigDecimal getTarifaImpuesto() {
        return tarifaImpuesto;
    }

    public void setTarifaImpuesto(BigDecimal tarifaImpuesto) {
        this.tarifaImpuesto = tarifaImpuesto;
    }

    public BigDecimal getPorcentajeUtilidad() {
        return porcentajeUtilidad;
    }

    public void setPorcentajeUtilidad(BigDecimal porcentajeUtilidad) {
        this.porcentajeUtilidad = porcentajeUtilidad;
    }

    public BigDecimal getMontoCosto() {
        return montoCosto;
    }

    public void setMontoCosto(BigDecimal montoCosto) {
        this.montoCosto = montoCosto;
    }

    public void setALL(int codigoArticulo, BigDecimal precio, BigDecimal tarifaImpuesto, BigDecimal porcentajeUtilidad, BigDecimal montoCosto) {
        this.codigoArticulo = codigoArticulo;
        this.precio = precio;
        this.tarifaImpuesto = tarifaImpuesto;
        this.porcentajeUtilidad = porcentajeUtilidad;
        this.montoCosto = montoCosto;
    }

        
    
}
