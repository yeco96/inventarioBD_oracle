/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fidelitas.inventario.Controlador;

import com.fidelitas.inventario.Acceso.BD;
import com.fidelitas.inventario.Acceso.staticStoredProcedure;
import com.fidelitas.inventario.Modelo.Venta;
import java.sql.Array;
import java.sql.CallableStatement;
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
            storedProcedure.setString(4, "yeco");

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

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ArticuloDao.class.getName()).log(Level.SEVERE, null, ex);
            callback[0] = "Ocurrio un error";
            return false;
        }
    }

}
