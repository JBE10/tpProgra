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

    }

}
