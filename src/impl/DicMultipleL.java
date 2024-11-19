package main.java.impl;

import apis.ConjuntoTDA;
import apis.DiccionarioMultipleTDA;

public class DicMultipleL implements DiccionarioMultipleTDA {
    NodoClave origen;

    public DicMultipleL() {
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

        NodoValor aux;
        for(aux = nc.valores; aux != null && aux.valor != valor; aux = aux.sigValor) {
        }

        if (aux == null) {
            NodoValor nv = new NodoValor();
            nv.valor = valor;
            nv.sigValor = nc.valores;
            nc.valores = nv;
        }


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

    public void eliminarValor(int clave, int valor) {
        if (this.origen != null) {
            if (this.origen.clave == clave) {
                this.EliminarValorEnNodo(this.origen, valor);
                if (this.origen.valores == null) {
                    this.origen = this.origen.sigClave;
                }
            } else {
                NodoClave aux;
                for(aux = this.origen; aux.sigClave != null && aux.sigClave.clave != clave; aux = aux.sigClave) {
                }

                if (aux.sigClave != null) {
                    this.EliminarValorEnNodo(aux.sigClave, valor);
                    if (aux.sigClave.valores == null) {
                        aux.sigClave = aux.sigClave.sigClave;
                    }
                }
            }
        }

    }

    private void EliminarValorEnNodo(NodoClave nodo, int valor) {
        if (nodo.valores != null) {
            if (nodo.valores.valor == valor) {
                nodo.valores = nodo.valores.sigValor;
            } else {
                NodoValor aux;
                for(aux = nodo.valores; aux.sigValor != null && aux.sigValor.valor != valor; aux = aux.sigValor) {
                }

                if (aux.sigValor != null) {
                    aux.sigValor = aux.sigValor.sigValor;
                }
            }
        }

    }

    public ConjuntoTDA recuperar(int clave) {
        NodoClave n = this.Clave2NodoClave(clave);
        ConjuntoTDA c = new ConjuntoLD();
        c.inicializarConjunto();
        if (n != null) {
            for(NodoValor aux = n.valores; aux != null; aux = aux.sigValor) {
                c.agregar(aux.valor);
            }
        }

        return c;
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

    static class NodoClave {
        int clave;
        NodoValor valores;
        NodoClave sigClave;

        NodoClave() {
        }
    }

    class NodoValor {
        int valor;
        NodoValor sigValor;

        NodoValor() {
        }
    }
}
