/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fidelitas.inventario.Controlador;

import com.fidelitas.inventario.Acceso.BD;
import com.fidelitas.inventario.Acceso.staticStoredProcedure;
import com.fidelitas.inventario.Modelo.Interfaces.CRUD;
import com.fidelitas.inventario.Modelo.Articulo;
import com.fidelitas.inventario.Modelo.Existencia;
import com.fidelitas.inventario.Modelo.Precio;
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
public class ArticuloDao implements CRUD<Articulo> {

    @Override
    public boolean insertar(Articulo articulo, String[] callback) {
        try {

            if (articulo.getCantidadMinima() == null) {
                callback[0] = "Debe indicar una cantidad minima valida";
                return false;
            }
            if (articulo.getDescripcion() == null || articulo.getDescripcion().equals("")) {
                callback[0] = "Debe indicar una descripcion valida";
                return false;
            }
            BD bd = new BD();
            CallableStatement storedProcedure = bd.storedProcedure(staticStoredProcedure.articulo.insertar);
            storedProcedure.setString(1, articulo.getDescripcion());
            storedProcedure.setBigDecimal(2, articulo.getCantidadMinima());
            storedProcedure.registerOutParameter(3, OracleTypes.VARCHAR);
            storedProcedure.executeQuery();

            String resultSet = storedProcedure.getString(2);
            if (resultSet != null && !resultSet.equals("")) {
                callback[0] = resultSet;
            }

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ArticuloDao.class.getName()).log(Level.SEVERE, null, ex);
            callback[0] = "Ocurrio un error";
            return false;
        }
    }

    @Override
    public boolean eliminar(Articulo articulo, String[] callback) {
        try {
            if (articulo.getCodigoArticulo() == null) {
                callback[0] = "Debe indicar un codigo valido";
                return false;
            }
            BD bd = new BD();
            CallableStatement storedProcedure = bd.storedProcedure(staticStoredProcedure.articulo.eliminar);
            storedProcedure.setInt(1, articulo.getCodigoArticulo());
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
    public boolean actualizar(Articulo articulo, String[] callback) {
        try {

            if (articulo.getCodigoArticulo()== null) {
                callback[0] = "Debe indicar un codigo valido";
                return false;
            }

            if (articulo.getCantidadMinima() == null) {
                callback[0] = "Debe indicar una cantidad minima valida";
                return false;
            }

            if (articulo.getDescripcion() == null || articulo.getDescripcion().equals("")) {
                callback[0] = "Debe indicar una descripcion valida";
                return false;
            }

            BD bd = new BD();
            CallableStatement storedProcedure = bd.storedProcedure(staticStoredProcedure.articulo.actualizar);
            storedProcedure.setInt(1, articulo.getCodigoArticulo());
            storedProcedure.setString(2, articulo.getDescripcion());
            storedProcedure.setBigDecimal(3, articulo.getCantidadMinima());
            storedProcedure.registerOutParameter(4, OracleTypes.VARCHAR);

            storedProcedure.executeQuery();

            String resultSet = storedProcedure.getString(4);
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
    public List<Articulo> leer(Integer codigo, String[] callback) {
        try {
            BD bd = new BD();
            CallableStatement storedProcedure = bd.storedProcedure(staticStoredProcedure.articulo.leer);
            if (codigo == null) {
                storedProcedure.setInt(1, 0);
            } else {
                storedProcedure.setInt(1, codigo);
            }
            storedProcedure.registerOutParameter(2, OracleTypes.CURSOR);
            storedProcedure.registerOutParameter(3, OracleTypes.VARCHAR);

            storedProcedure.executeQuery();

            String resultSet = storedProcedure.getString(3);
            if (resultSet != null && !resultSet.equals("")) {
                callback[0] = resultSet;
            }

            // List<Proveedor> resultSet = (List<Proveedor>) storedProcedure.getObject(2);
            ResultSet rs = (ResultSet) storedProcedure.getObject(2);

            List<Articulo> listaArticulo = new ArrayList<>();
            while (rs.next()) {
                Articulo a = new Articulo();
                a.setALL(rs.getInt("codigoArticulo"), rs.getString("descripcion"), rs.getBigDecimal("cantMinima"), rs.getDate("fechaCreacion"));

                Precio precio = new Precio();
                precio.setALL(rs.getInt("codigoArticulo"), rs.getBigDecimal("precio"), rs.getBigDecimal("tarifaImpuesto"), rs.getBigDecimal("porcentajeUtilidad"), rs.getBigDecimal("montoCosto"));

                Existencia existencia = new Existencia();
                existencia.setALL(rs.getInt("codigoArticulo"), rs.getBigDecimal("existencia"));

                a.setPrecio(precio);
                a.setExistencia(existencia);

                //Articulo a = new Articulo();
                //a.setALL(rs.getInt("codigoArticulo"), rs.getString("descripcion"), rs.getBigDecimal("cantMinima"), rs.getDate("fechaCreacion"));
                listaArticulo.add(a);
            }

            return listaArticulo;
        } catch (SQLException ex) {
            Logger.getLogger(ArticuloDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
