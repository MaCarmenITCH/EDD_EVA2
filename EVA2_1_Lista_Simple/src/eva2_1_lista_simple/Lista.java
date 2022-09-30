/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eva2_1_lista_simple;

/**
 *
 * @author moviles
 */
public class Lista {

    private Nodo inicio;
    private Nodo fin;

    //POR DEFAULT LA LISTA ESTA VACIA
    public Lista() {
        this.inicio = null;//NO HAY NODOS EN LA LISTA
        this.fin = null;
    }

    //AGREGAR UN NODO AL FINAL DE LA LISTA
    public void imprimir() {
        Nodo temp = inicio;
        //COMO MUEVO TEMP?
        while (temp != null) {
            System.out.print(temp.getValor() + " - ");
            temp = temp.getSiguiente();
        }
        
    }

    public void agregar(int valor) {
        Nodo newNodo = new Nodo(valor);

        //VERIFICAR SI HAY NODOS EN LA LISTA
        if (inicio == null) {//no hay nodo en la lista
            inicio = newNodo;
            fin = newNodo;
        } else {//Hay nodos en la lista
            //HAY QUE MOVERNOS POR LA LISTA
            //USANDO UN NODO TEMPORAL
            //HASTA LLEGAR AL ULTIMO NODO DE LA LISTA
            /*Nodo temp = inicio;
             //COMO MUEVO TEMP?
             while(temp.getSiguiente()!= null){
             temp = temp.getSiguiente();
                
             }

             temp.setSiguiente(newNodo);*/
            fin.setSiguiente(newNodo);
            fin = newNodo;
        }
    }

    public int tamLista() {
        int cont = 0;
        Nodo temp = inicio;
        while (temp != null) {
            cont++;
            temp = temp.getSiguiente();
        }
        return cont;   // this fire is out of control im gonna burn this city burn this ity
    }

    public void InsertarEn(int valor, int pos) throws Exception {
        int cantNodos = tamLista();
        //que debemos validar
        //*Insertar algo en una posicion no valida
        //*Posiciones mayores a  la cantidad de elementos
        //*Posiciones negativas
        if (pos < 0) {
            throw new Exception(" No puede haber una posicion negativa");
        } else if (pos >= cantNodos) {
            throw new Exception(pos + " No es una posicion valida en la lista");
        }else{
            Nodo nuevoNodo= new Nodo(valor);
            if(pos ==0){//insertar al inicio de la lista
                nuevoNodo.setSiguiente(inicio);
                inicio = nuevoNodo;
            
            }else{
              Nodo temp= inicio;
              int cont = 0;
              while(cont< (pos-1)){
                  temp = temp.getSiguiente();
                  cont++;
              }
                System.out.print(temp.getValor()+ " - ");
            }
        }

    }
}
