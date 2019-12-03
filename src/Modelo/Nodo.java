/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author alber
 */
public class Nodo {
    String dato;
    Nodo siguiente;
    
    public Nodo(String dato){
        this.dato = dato;
        siguiente = null;
    }
    
}
