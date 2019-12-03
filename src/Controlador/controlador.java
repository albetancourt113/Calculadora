/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.InfijaAPosfija;
import Vista.vistaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author alber
 */
public class controlador implements ActionListener {
    private InfijaAPosfija modelo;
    private vistaPrincipal vista;

    public controlador(InfijaAPosfija modelo, vistaPrincipal vista) {
        this.modelo = modelo;
        this.vista = vista;
        this.vista.jButtonSalir.addActionListener(this);
        this.vista.jButtonLimpiar.addActionListener(this);
        this.vista.jButtonEvaluar.addActionListener(this);
    }
    
    public void iniciar() {
        vista.setTitle("Vista principal");
        vista.setLocationRelativeTo(null);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.jButtonEvaluar) {
            String posfija = modelo.infijaAPosfija(vista.jTextFieldExpresion.getText());
            String resultado = modelo.evaluarPosfija(posfija);
            vista.jTextFieldResultado.setText(resultado);
        }else if(e.getSource() == vista.jButtonLimpiar){
            vista.jTextFieldExpresion.setText(null);
            vista.jTextFieldResultado.setText("");
        }else if(e.getSource() == vista.jButtonSalir){
            vista.setVisible(false);
            vista.dispose();
        }
    }
}