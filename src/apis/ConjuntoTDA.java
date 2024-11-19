package apis;

import impl.NodoGrafo;

public interface ConjuntoTDA {
    void inicializarConjunto();

    void agregar(int var1);

    void sacar(int var1);

    boolean conjuntoVacio();

    int elegir();
    NodoGrafo elegir1();

    boolean pertenece(int var1);

    int cardinal();

}
