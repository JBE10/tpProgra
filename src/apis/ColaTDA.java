package apis;

public interface ColaTDA {
    void inicializarCola();

    void acolar(int var1);

    void desacolar();

    boolean colaVacia();

    int primero();
}
