
package Modelo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *@author jonsthan chi cuevas   
 * clase que analiza y valida los caractes de la expresion 
 */
public class AnalizadorLexico {

    private String Error;
    public final static String DECIMAL = ".";
    public final static int PRIMERCARACTER = 1;

    
    enum Tipos {
        NUMERO("[0-9]+"),
        OPERADOR_BINARIO("[-|/|+|*|(|)|^| ]");

        public final String patron;

        Tipos(String s) {
            this.patron = s;
        }
    }
    /**
     * Metodo que valida los caracteres de una expresion 
     * @param input expresion a validar
     * @return parametros validos o invalidos
     */

    public boolean ValidarLexico(String input) {
        String expresion = input;
        boolean caracterValido = false;
        for (int posicionCaracter = PRIMERCARACTER; posicionCaracter < expresion.length() + 1; posicionCaracter++) {
            caracterValido = false;
            for (Tipos tokenTipo : Tipos.values()) {
                Pattern patron = Pattern.compile(tokenTipo.patron);
                Matcher matcher = patron.matcher(expresion.substring((posicionCaracter - 1), posicionCaracter));
                if (matcher.find()) {
                    caracterValido = true;
                }
            }
            if (!caracterValido) {
                if (expresion.substring((posicionCaracter - 1), posicionCaracter).equals(DECIMAL)) {
                    AnalizarSecuencia(expresion);
                } else {
                    setCaracterInvalido("Error en el caracter " + expresion.substring((posicionCaracter - 1), posicionCaracter));
                }
                return caracterValido;
            }
        }
        return caracterValido;
    }

    public void setCaracterInvalido(String caracterInvalido) {
        this.Error = caracterInvalido;
    }
    /**
     * Metodo que busca el error lexico en secuencia
     * @param Expresion valor que contiene una secuencia lexica no valida
     */
    public void AnalizarSecuencia(String Expresion) {
        final String regex = "[\\d.]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(Expresion);

        while (matcher.find()) {
            setCaracterInvalido("Error en la secuencia " + matcher.group());
            break;
        }
    }

    public String getCaracterInvalido() {
        return Error;
    }

}
