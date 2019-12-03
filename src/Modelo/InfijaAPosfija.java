/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Scanner;

/**
 *declaracion de la clase InfijaAPosfija
 * @author alber
 */
public class InfijaAPosfija {
    /**
     *método que convierte una expresión infija a posfija 
     * @param expresion
     * @return expresión posfija
     */
    public String infijaAPosfija(String expresion) {
        String expresionDepurada = depurar(expresion);
        String[] arrayInfija = expresionDepurada.split(" ");

        Pila pilaEntrada = new Pila();
        Pila pilaTemporal = new Pila();
        Pila pilaSalida = new Pila();
        Pila posfija = new Pila();
        for (int i = arrayInfija.length - 1; i >= 0; i--) {
            pilaEntrada.push(arrayInfija[i]);
        }

        try {
            //Algoritmo Infijo a Postfijo
            while (!pilaEntrada.isEmpty()) {
                switch (preferencia(pilaEntrada.peek())) {
                    case 1:
                        pilaTemporal.push(pilaEntrada.pop());
                        break;
                    case 2:
                        while (!pilaTemporal.peek().equals("(")) {
                            pilaSalida.push(pilaTemporal.pop());
                        }
                        pilaTemporal.pop();
                        pilaEntrada.pop();
                        break;
                    case 3:
                        compararPreferencias(pilaEntrada, pilaTemporal, pilaSalida);
                        break;
                    case 4:
                        compararPreferencias(pilaEntrada, pilaTemporal, pilaSalida);
                        break;
                    case 5:
                        compararPreferencias(pilaEntrada, pilaTemporal, pilaSalida);
                        break;
                    default:
                        pilaSalida.push(pilaEntrada.pop());
                }
            }
            String guardaPosfija = "";
            int tamaño = pilaSalida.getTamano();
            for (int i = tamaño - 1; i >= 0; i--) {
                posfija.push(pilaSalida.pop());
            }
            for (int i = tamaño - 1; i >= 0; i--) {
                guardaPosfija = guardaPosfija + " " + posfija.pop();
            }
            return guardaPosfija;
        } catch (Exception ex) {
            System.out.println("Error en la expresión algebraica");
            System.err.println(ex);
        }
        return "Error";
    }
    /**
     *método que compara la preferencia de 2 operadores
     * @param 3 pilas
     */
    private static void compararPreferencias(Pila E, Pila P, Pila S) {
        while (preferencia(P.peek()) >= preferencia(E.peek())) {
            S.push(P.pop());
        }
        P.push(E.pop());
    }
    /**
     * método que limpia una cadena
     * @param depurarString
     * @return string depurado
     */
    private static String depurar(String depurarString) {
        depurarString = depurarString.replaceAll("\\s+", ""); //Elimina espacios en blanco
        depurarString = "(" + depurarString + ")";
        String simbols = "^+-*/()";
        String stringDepurado = "";

        //Deja espacios entre operadores
        for (int i = 0; i < depurarString.length(); i++) {
            if (simbols.contains("" + depurarString.charAt(i))) {
                stringDepurado = stringDepurado + " " + depurarString.charAt(i) + " ";
            } else {
                stringDepurado = stringDepurado + depurarString.charAt(i);
            }
        }
        return stringDepurado.replaceAll("\\s+", " ").trim();
    }

    /**
     * método que devuelve la preferencia de un operador
     * @param operador
     * @return valorPreferencia
     */
    private static int preferencia(String operador) {
        int valorPreferencia = 99;
        if (operador.equals("^")) {
            valorPreferencia = 5;
        }
        if (operador.equals("*") || operador.equals("/")) {
            valorPreferencia = 4;
        }
        if (operador.equals("+") || operador.equals("-")) {
            valorPreferencia = 3;
        }
        if (operador.equals(")")) {
            valorPreferencia = 2;
        }
        if (operador.equals("(")) {
            valorPreferencia = 1;
        }
        return valorPreferencia;
    }
    /**
     *método que evalua una expresión posfija y devuelve su resultado
     * @param expresionPosfija
     * @return resultado
     */
    public String evaluarPosfija(String expresionPosfija) {
        String[] arrayPosfija = expresionPosfija.split(" ");
        Pila pilaEntrada = new Pila();
        Pila pilaOperandos = new Pila();
        for (int i = arrayPosfija.length - 1; i >= 1; i--) {
            pilaEntrada.push(arrayPosfija[i]);
        }
        String operadores = "^*/+-";
        while (!pilaEntrada.isEmpty()) {
            if (operadores.contains("" + pilaEntrada.peek())) {
                pilaOperandos.push(hacerOperacion(pilaEntrada.pop(), pilaOperandos.pop(), pilaOperandos.pop()) + "");
            } else {
                pilaOperandos.push(pilaEntrada.pop());
            }
        }
        String resultado = pilaOperandos.peek();
        return resultado;
    }
    /**
     * método que efectua una operación entre 2 operandos
     * @param operador
     * @param operandoB
     * @param operandoA
     * @return resultado
     */
    private static int hacerOperacion(String operador, String operandoB, String operandoA) {
        int numA = Integer.parseInt(operandoA);
        int numB = Integer.parseInt(operandoB);

        if (operador.equals("^")) {
            int potencia = numA ^ numB;
            return potencia;
        }
        if (operador.equals("*")) {
            int multiplicacion = numA * numB;
            return multiplicacion;
        }
        if (operador.equals("/")) {
            int division = numA / numB;
            return division;
        }
        if (operador.equals("+")) {
            int suma = numA + numB;
            return suma;
        }
        if (operador.equals("-")) {
            int resta = numA - numB;
            return resta;
        }
        return 0;
    }

}
