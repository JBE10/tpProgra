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
            Nodo aux = new Nodo();
            aux.info = x;
            aux.sig = this.c;
            this.c = aux;
            ++this.cant;
        }

    }

    public void sacar(int x) {
        if (this.c != null) {
            if (this.c.info == x) {
                this.c = this.c.sig;
                --this.cant;
            } else {
                Nodo aux;
                for(aux = this.c; aux.sig != null && aux.sig.info != x; aux = aux.sig) {
                }

                if (aux.sig != null) {
                    aux.sig = aux.sig.sig;
                    --this.cant;
                }
            }
        }

    }

    public boolean conjuntoVacio() {
        return this.c == null;
    }

    public int elegir() {
        Random rand = new Random();
        int x = rand.nextInt(this.cant);
        Nodo aux = this.c;

        for(int i = 0; i < x; ++i) {
            aux = aux.sig;
        }

        return aux.info;
    }

    public boolean pertenece(int x) {
        Nodo aux;
        for(aux = this.c; aux != null && aux.info != x; aux = aux.sig) {
        }

        return aux != null;
    }

    @Override
    public int cardinal() {
        return this.cant;
    }

}
