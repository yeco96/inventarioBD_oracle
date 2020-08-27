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

        public static final String insertar = "{call articulo_insert(?,?,?)}";
        public static final String eliminar = "{call articulo_delete(?,?)}";
        public static final String actualizar = "{call articulo_update(?,?,?,?)}";
        public static final String leer = "{call articulo_Read(?,?, ?)}";
    }

    public static class usuario {

        public static final String loggin = "{call usuario_loggin(?,?,?)}";
    }
    
     public static class venta {

        public static final String crear = "{call venta_insert(?, ?, ?, ?, ?)}";
        public static final String crearDetalle = "{call ventaDetalle_insert(?, ?, ?, ?, ?)}";
    }

    public static class proveedor {

        public static final String insertar = "{call proveedor_insert(?, ?)}";
        public static final String eliminar = "{call proveedor_delete(?, ?)}";
        public static final String actualizar = "{call proveedor_update(?, ?, ?)}";
        public static final String leer = "{call proveedor_Read(?, ?, ?)}";
    }
    public static class compra {

        public static final String crear = "{call compra_insert( ?, ?, ?, ?, ?)}";
        public static final String crearDetalle = "{call compraDetalle_insert(?, ?, ?, ?, ?, ?)}";
        
    }

}
