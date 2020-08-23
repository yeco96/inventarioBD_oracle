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
    public boolean insertar(Proveedor proveedor) {
        try {
            BD bd = new BD();
            CallableStatement storedProcedure = bd.storedProcedure(staticStoredProcedure.proveedor.insertar);
            storedProcedure.setString(1, proveedor.getNombre());
            storedProcedure.executeQuery();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ArticuloDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean actualizar(Proveedor proveedor) {
        try {
            BD bd = new BD();
            CallableStatement storedProcedure = bd.storedProcedure(staticStoredProcedure.proveedor.actualizar);
            storedProcedure.setString(1, proveedor.getNombre());
            storedProcedure.executeQuery();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ArticuloDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean eliminar(Proveedor proveedor) {
        try {
            BD bd = new BD();
            CallableStatement storedProcedure = bd.storedProcedure(staticStoredProcedure.proveedor.eliminar);
            storedProcedure.setString(1, proveedor.getNombre());
            storedProcedure.executeQuery();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ArticuloDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public List<Proveedor> leer() {
        try {
            BD bd = new BD();
            CallableStatement storedProcedure = bd.storedProcedure(staticStoredProcedure.proveedor.leer);
            storedProcedure.setString(1, "1");
            storedProcedure.registerOutParameter(2, OracleTypes.CURSOR);
            storedProcedure.executeQuery();

            // List<Proveedor> resultSet = (List<Proveedor>) storedProcedure.getObject(2);
            ResultSet rs = (ResultSet) storedProcedure.getObject(2);

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
