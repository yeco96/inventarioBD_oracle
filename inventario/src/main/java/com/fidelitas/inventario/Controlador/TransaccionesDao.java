/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fidelitas.inventario.Controlador;

import com.fidelitas.inventario.Acceso.BD;
import com.fidelitas.inventario.Acceso.staticStoredProcedure;
import com.fidelitas.inventario.Modelo.Compra;
import com.fidelitas.inventario.Modelo.CompraDetalle;
import com.fidelitas.inventario.Modelo.Venta;
import com.fidelitas.inventario.Modelo.VentaDetalle;
import java.math.BigDecimal;
import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author yeiso
 */
public class TransaccionesDao {

    public boolean insertarVenta(Venta venta, String[] callback) {
        try {

            BD bd = new BD();
            bd.validarEstado();
            CallableStatement storedProcedure = bd.storedProcedure(staticStoredProcedure.venta.crear);
            storedProcedure.setInt(1, venta.getIdentificacionCliente());
            storedProcedure.setString(2, venta.getNombreCliente());
            storedProcedure.setBigDecimal(3, venta.getMontoVenta());
            storedProcedure.setString(4, "gmena");

            storedProcedure.registerOutParameter(5, OracleTypes.VARCHAR);
            storedProcedure.executeQuery();

            String resultSet = storedProcedure.getString(5);
            if (resultSet != null && !resultSet.equals("")) {
                if (resultSet.contains("codigoSiguiente")) {
                    callback[0] = resultSet.replace("codigoSiguiente:", "");
                } else {
                    callback[0] = resultSet;
                    return false;
                }
            }

            venta.getDetalle().forEach(d -> {
                d.setCodigoVenta(Integer.valueOf(callback[0]));
            });

            boolean error = false;
            for (VentaDetalle d : venta.getDetalle()) {
                CallableStatement storedProcedureDetalle = bd.storedProcedure(staticStoredProcedure.venta.crearDetalle);
                try {
                    storedProcedureDetalle.setInt(1, d.getCodigoVenta());
                    storedProcedureDetalle.setInt(2, d.getCodigoArticulo());
                    storedProcedureDetalle.setBigDecimal(3, d.getCantidad());
                    storedProcedureDetalle.setBigDecimal(4, d.getPrecio());
                    storedProcedureDetalle.registerOutParameter(5, OracleTypes.VARCHAR);
                    storedProcedureDetalle.executeQuery();

                    String resultSetDetalle = storedProcedureDetalle.getString(5);

                    if (!resultSetDetalle.equals("Correcto")) {
                        error = true;
                        break;
                    }

                } catch (SQLException ex) {
                    error = true;
                    Logger.getLogger(TransaccionesDao.class.getName()).log(Level.SEVERE, null, ex);
                     break;
                }
            }

            if (error) {
                callback[0] = "Ocurrio un error";
                return false;
            }

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ArticuloDao.class.getName()).log(Level.SEVERE, null, ex);
            callback[0] = "Ocurrio un error";
            return false;
        }
    }

    public boolean insertarCompra(Compra compra, String[] callback) {
        try {
            BD bd = new BD();
            CallableStatement storedProcedure = bd.storedProcedure(staticStoredProcedure.compra.crear);
            storedProcedure.setInt(1, compra.getFactura());
            storedProcedure.setInt(2, compra.getCodigoProveedor());
            storedProcedure.setBigDecimal(3, compra.getMontoCompra());
            storedProcedure.setString(4, "gmena");

            storedProcedure.registerOutParameter(5, OracleTypes.VARCHAR);
            storedProcedure.executeQuery();

            String resultSet = storedProcedure.getString(5);
            if (resultSet != null && !resultSet.equals("")) {
                if (resultSet.contains("codigoSiguiente")) {
                    callback[0] = resultSet.replace("codigoSiguiente:", "");
                } else {
                    callback[0] = resultSet;
                    return false;
                }
            }
            
            compra.getDetalle().forEach(d -> {
                d.setCodigoCompra(Integer.valueOf(callback[0]));
            });

            boolean error = false;
            for (CompraDetalle d : compra.getDetalle()) {
                CallableStatement storedProcedureDetalle = bd.storedProcedure(staticStoredProcedure.venta.crearDetalle);
                try {
                    storedProcedureDetalle.setInt(1, d.getCodigoCompra());
                    storedProcedureDetalle.setInt(2, d.getCodigoArticulo());
                    storedProcedureDetalle.setBigDecimal(3, d.getCantidadCompra());
                    storedProcedureDetalle.setBigDecimal(4, d.getMontoCosto());
                    storedProcedureDetalle.setDate(5, (Date) d.getFechaVencimiento());
                    
                    storedProcedureDetalle.registerOutParameter(6, OracleTypes.VARCHAR);
                    storedProcedureDetalle.executeQuery();

                    String resultSetDetalle = storedProcedureDetalle.getString(6);

                    if (!resultSetDetalle.equals("Correcto")) {
                        error = true;
                        break;
                    }

                } catch (SQLException ex) {
                    error = true;
                    Logger.getLogger(TransaccionesDao.class.getName()).log(Level.SEVERE, null, ex);
                     break;
                }
            }

            if (error) {
                callback[0] = "Ocurrio un error";
                return false;
            }

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(TransaccionesDao.class.getName()).log(Level.SEVERE, null, ex);
            callback[0] = "Ocurrio un error";
            return false;
        }
    }

}
