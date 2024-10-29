package apis;

public interface ABBTDA {
    int raiz();

    ABBTDA hijoIzq();

    ABBTDA hijoDer();

    boolean arbolVacio();

    void inicializarArbol();

    void agregarElem(int var1);

    void eliminarElem(int var1);
}
