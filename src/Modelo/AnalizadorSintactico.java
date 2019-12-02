/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import static Modelo.AnalizadorLexico.PRIMERCARACTER;

/**
 *
 * @author joni1
 */
public class AnalizadorSintactico {
    private String error;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
    
    public boolean ValidarParentesis(String input) {
        Pila pila = new Pila();
        String expresion = input;
        int posicionParentecisAbierto=-1;
       for(int posicionCaracter=PRIMERCARACTER;posicionCaracter<expresion.length()+1;posicionCaracter++){
            if (expresion.substring(posicionCaracter-1,posicionCaracter).equals("(") ) {
                pila.push(expresion.substring(posicionCaracter-1,posicionCaracter));
                posicionParentecisAbierto=posicionCaracter;
            } else {
                if(expresion.substring(posicionCaracter-1,posicionCaracter).equals(")")){
                    if(posicionCaracter==posicionParentecisAbierto+1){
                        setError("error en la secuencia ()");
                        return false;
                    }else {
                        if(pila.isEmpty()){
                            setError("error falta apertura de parentesis (");
                            return false;
                        }else{
                            pila.pop();
                        }
                    }
                }
            }
            }
       if(!pila.isEmpty()){
           setError("error cierre parentesis )");
       }
       return pila.isEmpty();
    }
    
   public boolean validarExpresion(String expresionPosfija){
       System.out.println(expresionPosfija);
       
    String[] arrayPosfija = expresionPosfija.split(" ");
        Pila pilaEntrada = new Pila();
        Pila pilaOperandos = new Pila();
        Pila pilaOperadores = new Pila();
        Pila pilaOperadorSinUso = new Pila();
        for (int i = arrayPosfija.length - 1; i >= 1; i--) {
            pilaEntrada.push(arrayPosfija[i]);
        }
        
        String operadores = "^*/+-";
        while (!pilaEntrada.isEmpty()) {
            if (operadores.contains("" + pilaEntrada.peek())) {
                if(pilaOperadorSinUso.isEmpty()){
                   pilaOperadorSinUso.push(pilaEntrada.peek());
                  pilaOperadores.push(pilaEntrada.pop());
                  if(pilaOperandos.isEmpty()){
                      setError("error sintactico en "+pilaOperadores.pop());
                      return false;
                  }else{
                      pilaOperandos.pop();
                      if(!pilaOperandos.isEmpty()){
                         pilaOperadorSinUso.pop();
                      }
                      
                  }
                }else{
                   setError("error sintactico en "+pilaOperadores.pop()+pilaEntrada.pop());
                   return false;
                }
            } else {
                pilaOperandos.push(pilaEntrada.pop());
            }
            
            
        }
    if(pilaOperadorSinUso.isEmpty()){
    return true;
   }
    setError("error en la secuencia "+pilaOperadores.pop());
        return false;
     
}
}
