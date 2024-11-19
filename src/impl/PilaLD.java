package impl;

import apis.PilaTDA;

public class PilaLD implements PilaTDA {
    Nodo inicio;

    public PilaLD() {
    }

    public void inicializarPila() {
        this.inicio = null;
    }

    public void apilar(int x) {
        Nodo nuevo = new Nodo();
        nuevo.info = x;
        if (this.pilaVacia()) {
            nuevo.sig = null;
            this.inicio = nuevo;
        } else {
            nuevo.sig = this.inicio;
            this.inicio = nuevo;
        }

    }

    public void desapilar() {
        this.inicio = this.inicio.sig;
    }

    public boolean pilaVacia() {
        return this.inicio == null;
    }

    public int tope() {
        return this.inicio.info;
    }
}
