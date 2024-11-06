package apis;

public interface GrafoTDA {

    void inicializarGrafo();


    void eliminarVertice(int var1);

    ConjuntoTDA vertices();

    void agregarArista(int var1, int var2, int var3);

    void eliminarArista(int var1, int var2);

    boolean existeArista(int var1, int var2);

    int pesoArista(int var1, int var2);
}
