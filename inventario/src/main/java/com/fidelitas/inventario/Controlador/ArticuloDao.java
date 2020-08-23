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
import java.sql.CallableStatement;
import java.sql.SQLException;
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
    public  boolean insertar(Articulo articulo, String[] callback) {
        try {
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
            
            //storedProcedure.registerOutParameter(2, OracleTypes.CURSOR);
           /* storedProcedure.executeQuery();
            ResultSet resultSet = (ResultSet) storedProcedure.getObject(1);
            */
            /*List<Integer> result = new ArrayList<Integer>();
            while (resultSet.next()) {
                result.add(resultSet.getInt(STUDENT_ID));
            }*/
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ArticuloDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    @Override
    public boolean eliminar(Articulo articulo, String[] callback) {
        try {
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
    public boolean actualizar(Articulo objeto, String[] callback) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Articulo> leer(String[] callback) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
