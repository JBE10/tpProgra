package impl;

import apis.ColaTDA;

public class ColaLD implements ColaTDA {
    Nodo inicio;
    Nodo fin;

    public ColaLD() {
    }

    public void inicializarCola() {
        this.inicio = null;
        this.fin = null;
    }

    public void acolar(int x) {
        Nodo nuevo = new Nodo();
        nuevo.info = x;
        if (this.inicio != null) {
            nuevo.sig = null;
            this.fin.sig = nuevo;
            this.fin = nuevo;
        } else {
            nuevo.sig = null;
            this.inicio = nuevo;
            this.fin = nuevo;
        }

    }

    public void desacolar() {
        this.inicio = this.inicio.sig;
        if (this.colaVacia()) {
            this.fin = null;
        }

    }

    public boolean colaVacia() {
        return this.inicio == null;
    }

    public int primero() {
        return this.inicio.info;
    }
}
