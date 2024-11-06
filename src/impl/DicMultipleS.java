package impl;
import apis.ConjuntoSTDA;
import apis.ConjuntoTDA;
import apis.DiccionarioSTDA;

public class DicMultipleS  implements DiccionarioSTDA {
    private class NodoClave {
        String clave;
        NodoValor valores;
        NodoClave sigClave;
    }

    private class NodoValor {
        int valor;
        NodoValor sigValor;
    }

    private NodoClave origen;

    public void inicializarDiccionario() {
        origen = null;
    }

    public void agregar(String clave, int valor) {
        NodoClave nc = Clave2NodoClave(clave);
        if (nc == null) {
            nc = new NodoClave();
            nc.clave = clave;
            nc.sigClave = origen;
            origen = nc;
        }
        NodoValor aux = nc.valores;
        while (aux != null && aux.valor != valor) {
            aux = aux.sigValor;
        }
        if (aux == null) {
            NodoValor nv = new NodoValor();
            nv.valor = valor;
            nv.sigValor = nc.valores;
            nc.valores = nv;
        }
    }

    private NodoClave Clave2NodoClave(String clave) {
        NodoClave aux = origen;
        while (aux != null && aux.clave != clave) {
            aux = aux.sigClave;
        }
        return aux;
    }

    public void eliminarValor(String clave, int valor) {
        if (origen != null) {
            if (origen.clave == clave) {
                EliminarValorEnNodo(origen, valor);
                if (origen.valores == null) {
                    origen = origen.sigClave;
                }
            } else {
                NodoClave aux = origen;
                while (aux.sigClave != null && aux.sigClave.clave != clave) {
                    aux = aux.sigClave;
                }
                if (aux.sigClave != null) {
                    EliminarValorEnNodo(aux.sigClave, valor);
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
                NodoValor aux = nodo.valores;
                while (aux.sigValor != null && aux.sigValor.valor != valor) {
                    aux = aux.sigValor;
                }
                if (aux.sigValor != null) {
                    aux.sigValor = aux.sigValor.sigValor;
                }
            }
        }
    }

    public void eliminar(String clave) {
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

    public ConjuntoTDA recuperar(String clave) {
        NodoClave nc = Clave2NodoClave(clave);
        ConjuntoTDA c = new ConjuntoLD();
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

    public ConjuntoSTDA claves() {
        ConjuntoSTDA c = new ConjuntoSD();
        c.inicializarConjunto();
        NodoClave aux = origen;
        while (aux != null) {
            c.agregar(aux.clave);
            aux = aux.sigClave;
        }
        return c;
    }
}

