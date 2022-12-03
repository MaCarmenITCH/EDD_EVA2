

package eva2_1_lista_simple;

/**
 *s
 * @author 
 */
public class Nodo {
    private int valor;
    private Nodo siguiente;
    
  
    public Nodo() {
        this.siguiente = null;
    }

    public Nodo(int valor) {
        this.valor = valor;
        this.siguiente = null;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}
