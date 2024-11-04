package impl;

import apis.ConjuntoTDA;

import java.util.Random;

public class ConjuntoLD implements ConjuntoTDA {
    Nodo c;
    int cant;

    public ConjuntoLD() {
    }

    public void inicializarConjunto() {
        this.c = null;
    }

    public void agregar(int x) {
        if (!this.pertenece(x)) {
            NodoGrafo aux = new NodoGrafo();
            aux.nodo = x;
            aux.sigNodo = this.c;
            this.c = aux;
            ++this.cant;
        }

    }

    public void sacar(int x) {
        if (this.c != null) {
            if (this.c.nodo == x) {
                this.c = this.c.sigNodo;
                --this.cant;
            } else {
                NodoGrafo aux;
                for(aux = this.c; aux.sigNodo != null && aux.sigNodo.nodo != x; aux = aux.sigNodo) {
                }

                if (aux.sigNodo != null) {
                    aux.sigNodo = aux.sigNodo.sigNodo;
                    --this.cant;
                }
            }
        }

    }

    public boolean conjuntoVacio() {
        return this.c == null;
    }

    public int elegir() {
        return this.c.nodo;
    }

    public NodoGrafo elegir1() {
        return this.c;

    }


    public boolean pertenece(int x) {
        NodoGrafo aux;
        for(aux = this.c; aux != null && aux.nodo != x; aux = aux.sigNodo) {
        }

        return aux != null;
    }

    @Override
    public int cardinal() {
        return this.cant;
    }

}