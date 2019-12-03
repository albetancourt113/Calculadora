/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.AnalizadorLexico;
import Modelo.AnalizadorSintactico;
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
    private AnalizadorLexico analizadorLexico = new AnalizadorLexico();
    private AnalizadorSintactico analizadorSintactico = new AnalizadorSintactico();

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.jButtonEvaluar) {
            if (analizadorLexico.ValidarLexico(vista.jTextFieldExpresion.getText())) {
                if (analizadorSintactico.ValidarParentesis(vista.jTextFieldExpresion.getText())) {
                    String posfija = modelo.infijaAPosfija(vista.jTextFieldExpresion.getText());
                    if (analizadorSintactico.validarExpresion(posfija)) {
                        String resultado = modelo.evaluarPosfija(posfija);
                        vista.jTextFieldResultado.setText(resultado);
                        vista.jTextFieldObservaciones.setText("");
                    } else {
                        vista.jTextFieldResultado.setText("Error sintactico");
                        vista.jTextFieldObservaciones.setText(analizadorSintactico.getError());
                    }

                } else {
                    vista.jTextFieldResultado.setText("Error sintactico");
                    vista.jTextFieldObservaciones.setText(analizadorSintactico.getError());
                }
            } else {
                vista.jTextFieldResultado.setText("Error lexico");
                vista.jTextFieldObservaciones.setText(analizadorLexico.getCaracterInvalido());

            }

        } else if (e.getSource() == vista.jButtonLimpiar) {
            vista.jTextFieldExpresion.setText(null);
            vista.jTextFieldResultado.setText("");
            vista.jTextFieldObservaciones.setText("");
        } else if (e.getSource() == vista.jButtonSalir) {
            vista.setVisible(false);
            vista.dispose();
        }
    }
}
