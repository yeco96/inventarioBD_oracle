/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fidelitas.inventario.Modelo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Josue
 */
public class Venta {
    private int codigoVenta;
    private int factura;
    private int identificacionCliente;
    private String nombreCliente;
    private BigDecimal montoVenta;
    private Date fechaVenta;
    private String usuarioRegistro;
    
     private List<VentaDetalle> detalle;
    
    public int getCodigoVenta() {
        return codigoVenta;
    }

    public void setCodigoVenta(int codigoVenta) {
        this.codigoVenta = codigoVenta;
    }

    public int getFactura() {
        return factura;
    }

    public void setFactura(int factura) {
        this.factura = factura;
    }

    public int getIdentificacionCliente() {
        return identificacionCliente;
    }

    public void setIdentificacionCliente(int identificacionCliente) {
        this.identificacionCliente = identificacionCliente;
    }

    public BigDecimal getMontoVenta() {
        return montoVenta;
    }

    public void setMontoVenta(BigDecimal montoVenta) {
        this.montoVenta = montoVenta;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public String getUsuarioRegistro() {
        return usuarioRegistro;
    }

    public void setUsuarioRegistro(String usuarioRegistro) {
        this.usuarioRegistro = usuarioRegistro;
    }

    public List<VentaDetalle> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<VentaDetalle> detalle) {
        this.detalle = detalle;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }
    
    
}
