/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fidelitas.inventario.Controlador;

import com.fidelitas.inventario.Acceso.BD;
import com.fidelitas.inventario.Acceso.staticStoredProcedure;
import com.fidelitas.inventario.Modelo.Usuario;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author yeiso
 */
public class UsuarioDao {

    public static boolean loggin(Usuario usuario, String[] callback) {
        try {
            BD bd = new BD();
            CallableStatement storedProcedure = bd.storedProcedure(staticStoredProcedure.usuario.loggin);
            storedProcedure.setString(1, usuario.getUsuario());
            storedProcedure.setString(2, usuario.getContrasena());
            //salida
            storedProcedure.registerOutParameter(3, OracleTypes.VARCHAR);

            storedProcedure.executeQuery();

            String resultSet = storedProcedure.getString(3);
            if (resultSet != null && !resultSet.equals("")) {
                callback[0] = resultSet;
                return false;
            }

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
}
