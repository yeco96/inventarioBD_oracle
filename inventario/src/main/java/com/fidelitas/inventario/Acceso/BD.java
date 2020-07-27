/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fidelitas.inventario.Acceso;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yeiso
 */
public class BD {

    public void conect() {

        Properties appProps = obtenerConfig();
        String prod = appProps.getProperty("prod");
        String connection = appProps.getProperty("connection");
        String user = appProps.getProperty("user");
        String pass = appProps.getProperty("pass");
        if (!prod.equals("true")) {
            Properties appDevs = obtenerConfigDev();

            if (appDevs != null) {
                connection = appDevs.getProperty("connection");
                user = appDevs.getProperty("user");
                pass = appDevs.getProperty("pass");
            }

        }

        try (Connection conn = DriverManager.getConnection(connection, user, pass)) {

            if (conn != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to make connection!");
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Properties obtenerConfig() {
        try {
            String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
            String appConfigPath = rootPath + "config.properties";

            Properties appProps = new Properties();
            appProps.load(new FileInputStream(appConfigPath));
            return appProps;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private Properties obtenerConfigDev() {
        try {
            String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
            String appConfigPath = rootPath + "dev.properties";

            Properties appProps = new Properties();
            appProps.load(new FileInputStream(appConfigPath));
            return appProps;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
