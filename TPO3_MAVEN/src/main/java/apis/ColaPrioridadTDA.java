package apis;

public interface ColaPrioridadTDA {
    void inicializarCola();

    void acolarPrioridad(int var1, int var2);

    void desacolar();

    boolean colaVacia();

    int primero();

    int prioridad();
}
