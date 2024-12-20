package apis.apis;

import apis.ConjuntoTDA;
import impl.NodoGrafo;

public interface GrafoTDA {

    void inicializarGrafo();

    void agregarVertice(int var1,boolean centro,int costoUnitarioEnviarMercaderia,int costoFijoAnualCentroDeDistribucion,int volumenDeProduccion);

    void eliminarVertice(int var1);

    ConjuntoTDA vertices();

    void agregarArista(int var1, int var2, int var3);

    void eliminarArista(int var1, int var2);

    boolean existeArista(int var1, int var2);

    int pesoArista(int var1, int var2);

    NodoGrafo vert2Nodo(int vertice);
}
