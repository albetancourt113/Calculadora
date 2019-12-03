/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CorrerPrograma;

import Controlador.controlador;
import Modelo.InfijaAPosfija;
import Vista.vistaPrincipal;

/**
 *
 * @author alber
 */
public class correrPrograma {
    public static void main(String[] args){
        InfijaAPosfija modelo = new InfijaAPosfija();
        vistaPrincipal vista = new vistaPrincipal();
        controlador ctrl = new controlador(modelo, vista);
        ctrl.iniciar();
        vista.setVisible(true);
    }
}
