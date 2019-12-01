
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
    
    public boolean isEmpty(){
        return ultimoValorIngresado == null;
    }
   
    public void push(String dato){
        Nodo nuevoNodo = new Nodo(dato);
        nuevoNodo.siguiente = ultimoValorIngresado;
        ultimoValorIngresado = nuevoNodo;
        tamano = tamano + 1;
    }
    public String pop(){
        String nodoEliminado = ultimoValorIngresado.dato;
        ultimoValorIngresado = ultimoValorIngresado.siguiente;
        tamano = tamano - 1;
        return nodoEliminado;
    }
    public String peek(){
        return ultimoValorIngresado.dato;
    }
    
    public void vaciarPila(){
        while(!isEmpty()){
            pop();
        }
    }
 
    public void mostrarPila(){
        Nodo recorrido = ultimoValorIngresado;
        while(recorrido != null){
            lista = lista + recorrido.dato +" ";
            recorrido = recorrido.siguiente;
        }
        System.out.println(lista);
        lista = "";
    }
}
