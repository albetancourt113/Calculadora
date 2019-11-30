/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Scanner;

/**
 *
 * @author alber
 */
public class InfijaAPosfija {

    public static void main(String[] args) {

        System.out.println("Escribe una expresión: ");
        Scanner leer = new Scanner(System.in);
        String expresion = leer.nextLine();
        System.out.println("Posfija: "+infijaAPosfija(expresion));
    }
    
    private static String infijaAPosfija(String expresion){
        String expresionDepurada = depurar(expresion);
        String[] arrayInfija = expresionDepurada.split(" ");

        Pila E = new Pila();
        Pila P = new Pila();
        Pila S = new Pila();
        Pila posfija = new Pila();
        for (int i = arrayInfija.length - 1; i >= 0; i--) {
            E.push(arrayInfija[i]);
        }

        try {
            //Algoritmo Infijo a Postfijo
            while (!E.isEmpty()) {
                switch (preferencia(E.peek())) {
                    case 1:
                        P.push(E.pop());
                        break;
                    case 2:
                        while (!P.peek().equals("(")) {
                            S.push(P.pop());
                        }
                        P.pop();
                        E.pop();
                        break;
                    case 3:
                        compararPreferencias(E, P, S);
                        break;
                    case 4:
                        compararPreferencias(E, P, S);
                        break;
                    case 5:
                        compararPreferencias(E, P, S);
                        break;
                    default:
                        S.push(E.pop());
                }
            }
            //Eliminacion de impurezas en la expresiones algebraicas
            String infix = expresion.replace(" ", "");
            String guardaPosfija = "";
            int tamaño = S.getTamano();
            for (int i = tamaño - 1; i >= 0; i--) {
                posfija.push(S.pop());
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

    private static void compararPreferencias(Pila E, Pila P, Pila S) {
        while (preferencia(P.peek()) >= preferencia(E.peek())) {
            S.push(P.pop());
        }
        P.push(E.pop());
    }

    private static String depurar(String depurarString) {
        //depurarString = depurarString.replaceAll("\\s+", ""); //Elimina espacios en blanco
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

    //Jerarquia de los operadores
    private static int preferencia(String op) {
        int valorPreferencia = 99;
        if (op.equals("^")) {
            valorPreferencia = 5;
        }
        if (op.equals("*") || op.equals("/")) {
            valorPreferencia = 4;
        }
        if (op.equals("+") || op.equals("-")) {
            valorPreferencia = 3;
        }
        if (op.equals(")")) {
            valorPreferencia = 2;
        }
        if (op.equals("(")) {
            valorPreferencia = 1;
        }
        return valorPreferencia;
    }

}
