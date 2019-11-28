
package Modelo;

/**
 *
 * @author Alberto Betancourt
 */
public class Pila {
    
    private Nodo ultimoValorIngresado;
    private int tamano = 0;
    String lista = "";
   
    public Pila(){
        ultimoValorIngresado = null;
        tamano = 0;
    }
    
    public int getTamano(){
        return this.tamano;
    }
    
    public boolean isVacia(){
        return ultimoValorIngresado == null;
    }
   
    public void insertarNodo(String dato){
        Nodo nuevoNodo = new Nodo(dato);
        nuevoNodo.siguiente = ultimoValorIngresado;
        ultimoValorIngresado = nuevoNodo;
        tamano = tamano + 1;
    }
    public String eliminarNodo(){
        String nodoEliminado = ultimoValorIngresado.dato;
        ultimoValorIngresado = ultimoValorIngresado.siguiente;
        tamano = tamano - 1;
        return nodoEliminado;
    }
    public String getUltimoValorIngresado(){
        return ultimoValorIngresado.dato;
    }
 
    public void mostrarPila(){
        Nodo recorrido = ultimoValorIngresado;
        while(recorrido != null){
            lista = lista + recorrido.dato +"\n";
            recorrido = recorrido.siguiente;
        }
        System.out.println(lista);
        lista = "";
    }
}
