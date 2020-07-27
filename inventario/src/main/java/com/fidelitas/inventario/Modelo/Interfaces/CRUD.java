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
    public boolean insertar(T objeto);
    public boolean eliminar(T objeto);
    public boolean actualizar(T objeto);
    public List<T> leer();
}
