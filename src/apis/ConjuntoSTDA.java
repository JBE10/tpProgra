package apis;

public interface ConjuntoSTDA {
    void inicializarConjunto();

    void agregar(String var1);

    void sacar(String var1);

    boolean conjuntoVacio();

    String elegir();

    boolean pertenece(String var1);


}
