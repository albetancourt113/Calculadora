
package Modelo;

/**
 *declaración de la clase pila
 * @author Alberto Betancourt
 */
public class Pila {
    
    private Nodo ultimoValorIngresado;
    private int tamano = 0;
    String lista = "";
   /**
    * constructor de la clase
    */
    public Pila(){
        ultimoValorIngresado = null;
        tamano = 0;
    }
    /**
     * método que devuelve el tamaño de la pila
     * @return tamano
     */
    public int getTamano(){
        return this.tamano;
    }
    /**
     * método que devuelve true si está vacía la pila
     * @return ultimoValorIngresado = null
     */
    public boolean isEmpty(){
        return ultimoValorIngresado == null;
    }
   /**
    * método que inserta un elemento en la pila
    * @param dato 
    */
    public void push(String dato){
        Nodo nuevoNodo = new Nodo(dato);
        nuevoNodo.siguiente = ultimoValorIngresado;
        ultimoValorIngresado = nuevoNodo;
        tamano = tamano + 1;
    }
    /**
     * método que elimina un elemento de la pila
     * @return 
     */
    public String pop(){
        String nodoEliminado = ultimoValorIngresado.dato;
        ultimoValorIngresado = ultimoValorIngresado.siguiente;
        tamano = tamano - 1;
        return nodoEliminado;
    }
    /**
     * método que devuelve el último elemento ingresado
     * @return ultimoValorIngresado.dato
     */
    public String peek(){
        return ultimoValorIngresado.dato;
    }
    /**
     * método que vacía la pila
     */
    public void vaciarPila(){
        while(!isEmpty()){
            pop();
        }
    }
    /**
     * método que muestra la pila
     */
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
