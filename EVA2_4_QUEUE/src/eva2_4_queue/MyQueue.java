package eva2_4_queue;
/**
 *
 * @author 
 */
public class MyQueue {

    private Nodo inicio;
    private Nodo fin;
    private int cont;

    public MyQueue() {
        this.inicio = null; 
        this.fin = null;
        this.cont = 0;
    }

    //Lista esta vacía
    public boolean listaVacia() {
        if (inicio == null) {
            return true;
        } else {
            return false;
        }
    }

    public void imprimir() {
        if (listaVacia()) {
            System.out.print("Lista vacía ");
        } else {
            Nodo temp = inicio;
            //Mover temp hasta que llegue al nodo final
            while (temp != null) {
                System.out.print(temp.getValor() + " - ");
                temp = temp.getSiguiente();
            }
        }
        System.out.println("");
    }

    public int tamaLista() {
        return this.cont;
    }

    public void Limpiar() {
        inicio = null;
        fin = null;
        cont = 0;
    }

    public void Agregar(int valor) {
        Nodo nuevoNodo = new Nodo(valor);
        
        if (inicio == null) {
            inicio = nuevoNodo;
            fin = nuevoNodo;
        } else {
            fin.setSiguiente(nuevoNodo);
            nuevoNodo.setPrevio(fin);
            fin = nuevoNodo;
        }
        cont++;
    }

    public Integer peek() {

        if (listaVacia()) {
            return null;
        } else {
            return inicio.getValor();
        }
    }

    public Integer poll() throws Exception {

        if (listaVacia()) {
            return null;
        } else {
            int valor = inicio.getValor();
            //borrar el nodo
            BorrarEn(0);
            return valor;
        }
    }

    public void InsertarEn(int valor, int pos) throws Exception {  
        int cantNodos = tamaLista();
        if (pos < 0)
        {
            throw new Exception("No puede insertarse un nodo en una posicion negativa");
        } else if (pos >= cantNodos)
        {
            throw new Exception(pos + " No es una posicion valida en la lista");
        } else {
            Nodo nuevoNodo = new Nodo(valor);
            if (pos == 0) {//Insertar al inicio de la lista
                nuevoNodo.setSiguiente(inicio);
                inicio.setPrevio(nuevoNodo);
                inicio = nuevoNodo;
            } else {
                Nodo temp = inicio;
                int cont = 0;
                while (cont < pos) {
                    temp = temp.getSiguiente();
                    cont++;
                }
                nuevoNodo.setSiguiente(temp);
                nuevoNodo.setPrevio(temp.getPrevio());
                temp.getPrevio().setSiguiente(nuevoNodo);
                temp.setPrevio(nuevoNodo);
            }
            this.cont++;
        }
    }

    public void BorrarEn(int pos) throws Exception {
        int cantNodos = tamaLista();
        if (pos < 0){// posiciones negativas 
            throw new Exception("No se pueden eliminar nodos de porsiciones negativas");
        } else if (pos >= cantNodos) {//posiciones mayores a la cantidad  de elementos
            throw new Exception("Esa posicion no es válida en la lista");
        } else {
            if (cantNodos == 1) {
                Limpiar();
            } else {
                if (pos == 0) {
                    inicio = inicio.getSiguiente();
                } else {
                    Nodo temp = inicio;
                    int cont = 0;
                    while (cont < (pos)) {
                        temp = temp.getSiguiente();
                        cont++;
                    }
                    Nodo objPrev = temp.getPrevio();
                    Nodo objSig = temp.getSiguiente();
                    objPrev.setSiguiente(objSig);

                    if (pos == (cantNodos - 1)) {
                        fin = objPrev;
                    } else {
                        objSig.setPrevio(objPrev);
                    }
                }
                this.cont--;
            }
        }
    }

      public int ObtenrValorEn (int pos) throws Exception {

        int cantNodos = tamaLista();
        int Valor = 0;
        if (pos < 0)// posiciones negativas
        {
            throw new Exception("No puede insertarse un nodo en una posicion negativa");
        } else if (pos >= cantNodos)//posiciones mayores a la cantidad  de elementos
        {
            throw new Exception(pos + " no es una possicion valida en la lista");
        } else {
            Nodo temp = inicio;
            int cont = 0;
            while (cont < (pos)) {
                temp = temp.getSiguiente();
                cont++;

            }
            Valor = temp.getValor();

        }
        return Valor;
    } 
}