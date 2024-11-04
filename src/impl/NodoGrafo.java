package impl;

public class NodoGrafo {

    int nodo;
    boolean centro;
    NodoArista arista;
    NodoGrafo sigNodo;

    public boolean getCentro(){
        return this.centro;
    }
    public int getNodo(){
        return this.nodo;
    }


    NodoGrafo() {
    }


}
