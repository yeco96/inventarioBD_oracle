/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fidelitas.inventario.Acceso;

/**
 *
 * @author yeiso
 */
public class staticStoredProcedure {

    public static class articulo {
        public static final String insertar  = "{call usp_insertArticulo(?,?)}";
    }
    
     public static class usuario {
        public static final String loggin  = "{call usp_insertArticulo(?,?)}";
    }

}
