package impl;

import apis.ConjuntoTDA;

import java.util.Random;

public class ConjuntoTA implements ConjuntoTDA {
    int[] a;
    int cant;

    public ConjuntoTA() {
    }

    public void inicializarConjunto() {
        this.a = new int[100];
        this.cant = 0;
    }

    public void agregar(int x) {
        if (!this.pertenece(x)) {
            this.a[this.cant] = x;
            ++this.cant;
        }

    }

    public void sacar(int x) {
        int i;
        for(i = 0; i < this.cant && this.a[i] != x; ++i) {
        }

        if (i < this.cant) {
            this.a[i] = this.a[this.cant - 1];
            --this.cant;
        }

    }

    public boolean conjuntoVacio() {
        return this.cant == 0;
    }

    public int elegir() {
        Random rand = new Random();
        int x = rand.nextInt(this.cant);
        return this.a[x];
    }

    public boolean pertenece(int x) {
        int i;
        for(i = 0; i < this.cant && this.a[i] != x; ++i) {
        }

        return i < this.cant;
    }
}
