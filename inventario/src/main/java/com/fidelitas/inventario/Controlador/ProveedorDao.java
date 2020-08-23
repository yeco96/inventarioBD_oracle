/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fidelitas.inventario.Controlador;

import com.fidelitas.inventario.Acceso.BD;
import com.fidelitas.inventario.Acceso.staticStoredProcedure;
import com.fidelitas.inventario.Modelo.Interfaces.CRUD;
import com.fidelitas.inventario.Modelo.Proveedor;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author yeiso
 */
public class ProveedorDao implements CRUD<Proveedor> {

    @Override
    public boolean insertar(Proveedor proveedor, String[] callback) {
        try {
            BD bd = new BD();
            CallableStatement storedProcedure = bd.storedProcedure(staticStoredProcedure.proveedor.insertar);
            storedProcedure.setString(1, proveedor.getNombre());
            storedProcedure.registerOutParameter(2, OracleTypes.VARCHAR);
            storedProcedure.executeQuery();
            


            String resultSet = storedProcedure.getString(2);
            if (resultSet != null && !resultSet.equals("")) {
                callback[0] = resultSet;
            }
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ArticuloDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean actualizar(Proveedor proveedor, String[] callback) {
        try {
            BD bd = new BD();
            CallableStatement storedProcedure = bd.storedProcedure(staticStoredProcedure.proveedor.actualizar);
            storedProcedure.setString(1, proveedor.getNombre());
            storedProcedure.registerOutParameter(2, OracleTypes.VARCHAR);
            
            storedProcedure.executeQuery();
            
            String resultSet = storedProcedure.getString(2);
            if (resultSet != null && !resultSet.equals("")) {
                callback[0] = resultSet;
            }
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ArticuloDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean eliminar(Proveedor proveedor, String[] callback) {
        try {
            BD bd = new BD();
            CallableStatement storedProcedure = bd.storedProcedure(staticStoredProcedure.proveedor.eliminar);
            storedProcedure.setInt(1, proveedor.getCodigoProveedor());
            storedProcedure.registerOutParameter(2, OracleTypes.VARCHAR);
            
            storedProcedure.executeQuery();
            
            String resultSet = storedProcedure.getString(2);
            if (resultSet != null && !resultSet.equals("")) {
                callback[0] = resultSet;
            }
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ArticuloDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public List<Proveedor> leer(String[] callback) {
        try {
            BD bd = new BD();
            CallableStatement storedProcedure = bd.storedProcedure(staticStoredProcedure.proveedor.leer);
            storedProcedure.registerOutParameter(1, OracleTypes.CURSOR);
            storedProcedure.registerOutParameter(2, OracleTypes.VARCHAR);
            
            storedProcedure.executeQuery();
            
            String resultSet = storedProcedure.getString(2);
            if (resultSet != null && !resultSet.equals("")) {
                callback[0] = resultSet;
            }

            // List<Proveedor> resultSet = (List<Proveedor>) storedProcedure.getObject(2);
            ResultSet rs = (ResultSet) storedProcedure.getObject(1);

            List<Proveedor> listaProveedor = new ArrayList<>();
            while (rs.next()) {
                Proveedor p = new Proveedor();
                p.setALL(rs.getInt("codigoProveedor"), rs.getString("nombre"), rs.getDate("fechaIngreso"));
                listaProveedor.add(p);
            }
            
            return listaProveedor;
        } catch (SQLException ex) {
            Logger.getLogger(ArticuloDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
