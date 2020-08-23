/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fidelitas.inventario.Modelo.Interfaces;

import java.util.List;

/**
 *
 * @author yeiso
 */
public interface CRUD<T> {
    public boolean insertar(T objeto, String[] callback);
    public boolean eliminar(T objeto, String[] callback);
    public boolean actualizar(T objeto, String[] callback);
    public List<T> leer(String[] callback);
}
