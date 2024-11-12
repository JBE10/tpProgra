package impl;

import apis.ConjuntoTDA;
import apis.DiccionarioSimpleTDA;

public class DicSimpleL implements DiccionarioSimpleTDA {
    NodoClave origen;

    public DicSimpleL() {
    }

    public void inicializarDiccionario() {
        this.origen = null;
    }

    public void agregar(int clave, int valor) {
        NodoClave nc = this.Clave2NodoClave(clave);
        if (nc == null) {
            nc = new NodoClave();
            nc.clave = clave;
            nc.sigClave = this.origen;
            this.origen = nc;
        }

        nc.valor = valor;
    }

    public void eliminar(int clave) {
        if (this.origen != null) {
            if (this.origen.clave == clave) {
                this.origen = this.origen.sigClave;
            } else {
                NodoClave aux;
                for(aux = this.origen; aux.sigClave != null && aux.sigClave.clave != clave; aux = aux.sigClave) {
                }

                if (aux.sigClave != null) {
                    aux.sigClave = aux.sigClave.sigClave;
                }
            }
        }

    }

    public int recuperar(int clave) {
        NodoClave n = this.Clave2NodoClave(clave);
        return n.valor;
    }

    public ConjuntoTDA claves() {
        ConjuntoTDA c = new ConjuntoLD();
        c.inicializarConjunto();

        for(NodoClave aux = this.origen; aux != null; aux = aux.sigClave) {
            c.agregar(aux.clave);
        }

        return c;
    }

    private NodoClave Clave2NodoClave(int clave) {
        NodoClave aux;
        for(aux = this.origen; aux != null && aux.clave != clave; aux = aux.sigClave) {
        }

        return aux;
    }

    class NodoClave {
        int clave;
        int valor;
        NodoClave sigClave;

        NodoClave() {
        }
    }
}
