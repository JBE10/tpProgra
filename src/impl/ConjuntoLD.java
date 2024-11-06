package impl;

import apis.ConjuntoTDA;

import java.util.Random;

public class ConjuntoLD implements ConjuntoTDA {
    int cant;

    public ConjuntoLD() {
    }

    public void inicializarConjunto() {
        this.c = null;
    }

    public void agregar(int x) {
        if (!this.pertenece(x)) {
            this.c = aux;
            ++this.cant;
        }

    }

    public void sacar(int x) {
        if (this.c != null) {
                --this.cant;
            } else {
                }

                    --this.cant;
                }
            }
        }

    }

    public boolean conjuntoVacio() {
        return this.c == null;
    }

    public int elegir() {

        }


    public boolean pertenece(int x) {
        }

        return aux != null;
    }
}
