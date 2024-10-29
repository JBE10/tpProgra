package impl;
import apis.*;

public class DicMultipleSV  implements DiccionarioSVTDA {
    class NodoClave {
        int clave;
        NodoValor valores;
        NodoClave sigClave;
    }

    class NodoValor {
        String valor;
        NodoValor sigValor;
    }

    private NodoClave origen;

    public void inicializarDiccionario() {
        origen = null;
    }

    public void agregar(int clave, String valor) {
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

    public NodoClave Clave2NodoClave(int clave) {
        NodoClave aux = origen;
        while (aux != null && aux.clave != clave) {
            aux = aux.sigClave;
        }
        return aux;
    }

    public void eliminarValor(int clave, String valor) {
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

    private void EliminarValorEnNodo(NodoClave nodo, String valor) {
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

    public void eliminar(int clave) {
        if (origen != null) {
            if (origen.clave == clave) {
                origen = origen.sigClave;
            } else {
                NodoClave aux = origen;
                while (aux.sigClave != null && aux.sigClave.clave != clave) {
                    aux = aux.sigClave;
                }
                if (aux.sigClave != null) {
                    aux.sigClave = aux.sigClave.sigClave;
                }
            }
        }
    }

    public ConjuntoSTDA recuperar(int clave) {
        NodoClave nc = Clave2NodoClave(clave);
        ConjuntoSTDA c = new ConjuntoSD();
        c.inicializarConjunto();
        if (nc != null) {
            NodoValor aux = nc.valores;
            while (aux != null) {
                c.agregar(aux.valor);
                aux = aux.sigValor;
            }
        }
        return c;
    }

    public ConjuntoTDA claves() {
        ConjuntoTDA c = new ConjuntoLD();
        c.inicializarConjunto();
        NodoClave aux = origen;
        while (aux != null) {
            c.agregar(aux.clave);
            aux = aux.sigClave;
        }
        return c;
    }
}

