/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fidelitas.inventario;


import com.fidelitas.inventario.Vista.inicio;
import com.fidelitas.inventario.Acceso.BD;
/**
 *
 * @author yeiso
 */
public class Inventario {
    
    public static void main(String[] args) {
       
        inicio start = new inicio();
        start.setVisible(true);
        
        BD bd = new BD();
        bd.conect();
        
    
    }
    
}
