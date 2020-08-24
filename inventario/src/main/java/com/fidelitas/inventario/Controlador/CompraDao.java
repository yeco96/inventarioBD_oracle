/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fidelitas.inventario.Controlador;

import com.fidelitas.inventario.Acceso.BD;
import com.fidelitas.inventario.Acceso.staticStoredProcedure;
import com.fidelitas.inventario.Modelo.Compra;
import com.fidelitas.inventario.Modelo.Interfaces.CRUD;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Josue
 */
public class CompraDao implements CRUD<Compra>{
    
    @Override
    public boolean insertar(Compra compra, String[] callback) {
        try {
            BD bd = new BD();
            CallableStatement storedProcedure = bd.storedProcedure(staticStoredProcedure.compra.insertar);
            storedProcedure.setInt(1, compra.getFactura());
            storedProcedure.setInt(2, compra.getCodigoProveedor());
            storedProcedure.setBigDecimal(2, compra.getMontoCompra());
            storedProcedure.registerOutParameter(3, OracleTypes.VARCHAR);
            storedProcedure.executeQuery();
            
            String resultSet = storedProcedure.getString(2);
            if (resultSet != null && !resultSet.equals("")) {
                callback[0] = resultSet;
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CompraDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean eliminar(Compra objeto, String[] callback) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizar(Compra objeto, String[] callback) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Compra> leer(Integer codigo, String[] callback) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
