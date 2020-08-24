/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fidelitas.inventario.Modelo;

import java.math.BigDecimal;

/**
 *
 * @author yeiso
 */
public class Existencia {
    private int codigoArticulo;
    private BigDecimal EXISTENCIA;

    public int getCodigoArticulo() {
        return codigoArticulo;
    }

    public void setCodigoArticulo(int codigoArticulo) {
        this.codigoArticulo = codigoArticulo;
    }

    public BigDecimal getEXISTENCIA() {
        return EXISTENCIA;
    }

    public void setEXISTENCIA(BigDecimal EXISTENCIA) {
        this.EXISTENCIA = EXISTENCIA;
    }

    public void setALL(int codigoArticulo, BigDecimal EXISTENCIA) {
        this.codigoArticulo = codigoArticulo;
        this.EXISTENCIA = EXISTENCIA;
    }
    
    
}
