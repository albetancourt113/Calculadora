/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author joni1
 */
public class AnalizadorLexico {
private String caracterInvalido;
private boolean secuencia=false;
public final static String DECIMAL = ".";
public final static int PRIMERCARACTER=1;


enum Tipos {
        NUMERO ("[0-9]+"),
        OPERADOR_BINARIO("[-|/|+|*|(|)|^| ]");

        public final String patron;
        Tipos(String s) {
            this.patron = s;
        }
    }
public boolean BuscarError(String input){
        String expresion = input;
        boolean caracterValido = false;
            for(int posicionCaracter=PRIMERCARACTER;posicionCaracter<expresion.length()+1;posicionCaracter++){
            caracterValido = false;
            for (Tipos tokenTipo : Tipos.values()) {
                Pattern patron = Pattern.compile(tokenTipo.patron);
                Matcher matcher = patron.matcher(expresion.substring((posicionCaracter-1),posicionCaracter));
                if(matcher.find()) {
                    caracterValido = true;
                }
            }
                if(!caracterValido){
                if(expresion.substring((posicionCaracter-1),posicionCaracter).equals(DECIMAL)){
                AnalizarSecuencia(expresion);
                secuencia = true;
                }else{
                    secuencia=false;
                    setCaracterInvalido(expresion.substring((posicionCaracter-1),posicionCaracter));
                }
                return caracterValido;
            }
            }
            return caracterValido;
    }
    public void setCaracterInvalido(String caracterInvalido) {
        this.caracterInvalido = caracterInvalido;
    }
    public void AnalizarSecuencia(String Expresion){
    final String regex = "[\\d.]+";
    final Pattern pattern = Pattern.compile(regex);
    final Matcher matcher = pattern.matcher(Expresion);

while (matcher.find()) {
    setCaracterInvalido(matcher.group());
    break;
}
}

    public String getCaracterInvalido() {
        return caracterInvalido;
    }

    public boolean isSecuencia() {
        return secuencia;
    }

    public void setSecuencia(boolean secuencia) {
        this.secuencia = secuencia;
    }
    
}
