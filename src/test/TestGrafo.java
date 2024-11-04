package test;
import apis.ConjuntoTDA;
import apis.GrafoTDA;
import impl.ConjuntoLD;
import impl.GrafoLA;
import org.junit.Test;
public class TestGrafo {
    @Test
    public void test1() {
        GrafoTDA grafo=new GrafoLA();
        grafo.inicializarGrafo();
        grafo= lectura.CargarGrafo.cargarUsuarios();
        lectura.CargarGrafo.cargarAristas(grafo);
        ConjuntoTDA conjunto=new ConjuntoLD();
        conjunto=metodos.Ejercicios.AdyacentesDobles(grafo,52);
        metodos.Ejercicios.Mostrar(conjunto);
        GrafoTDA grafoPrueba=new GrafoLA();
        grafoPrueba.inicializarGrafo();

        grafoPrueba.agregarVertice(1,true);
        grafoPrueba.agregarVertice(2,false);
        grafoPrueba.agregarVertice(3,false);
        grafoPrueba.agregarVertice(4,true);
        grafoPrueba.agregarVertice(5,false);
        grafoPrueba.agregarVertice(6,false);


        grafoPrueba.agregarArista(1,2,4);
        grafoPrueba.agregarArista(2,1,4);
        grafoPrueba.agregarArista(1,3,2);
        grafoPrueba.agregarArista(3,1,2);
        grafoPrueba.agregarArista(2,3,1);
        grafoPrueba.agregarArista(3,2,1);
        grafoPrueba.agregarArista(2,4,5);
        grafoPrueba.agregarArista(4,2,5);
        grafoPrueba.agregarArista(3,4,8);
        grafoPrueba.agregarArista(4,3,8);
        grafoPrueba.agregarArista(3,5,10);
        grafoPrueba.agregarArista(5,3,10);
        grafoPrueba.agregarArista(4,5,2);
        grafoPrueba.agregarArista(5,4,2);
        grafoPrueba.agregarArista(5,6,2);
        grafoPrueba.agregarArista(6,5,2);
        grafoPrueba.agregarArista(4,6,6);
        grafoPrueba.agregarArista(6,4,6);

        GrafoTDA resultado=lectura.CargarGrafo.dijkstra(grafoPrueba,1);

        System.out.println(resultado.pesoArista(1,5));

        int[][] matriz=lectura.Matriz.crearMatrizDistanciasMinimas(grafo);
        lectura.Matriz.imprimirMatriz(matriz);

    }


}
