package apis;

public interface ConjuntoTDA {
    void inicializarConjunto();

    void agregar(int var1);

    void sacar(int var1);

    boolean conjuntoVacio();

    int elegir();

    boolean pertenece(int var1);
}
