package test;

import apis.GrafoTDA;
import impl.GrafoLA;

import java.util.Arrays;

public class TestGrafo {
    public static void main(String[] args) {
        /*Utilizo un grafo para cargar todos los datos*/
        GrafoTDA grafo = new GrafoLA();
        grafo.inicializarGrafo();

        /*Cargamos los nodos:
         * Centros
         * Clientes
         * en el grafo que creamos*/
        grafo = lectura.CargarGrafo.cargarUsuarios();

        /* Cargamos las aristas:
         * en el grafo que creamos*/

        lectura.CargarGrafo.cargarAristas(grafo);


        /*
        * Creamos una matriz matrizCost(CantCentros x CantClientes)
        * En donde en cada celda se encuentra el costo asociado cliente->centro
        * Siendo el costoClienteCentro = Costo envio al centro + Costo envio puerto
        *
        * */

        int[][] matrizCostos = lectura.Matriz.crearMatrizDistanciasMinimas(grafo);

        matrizCostos = lectura.Matriz.actualizarMatriz(matrizCostos, grafo);


        int[] mejorCombinacion = lectura.MatrizV2.encontrarMejorCombinacion(matrizCostos, grafo);
        System.out.println("Mejor combinación de centros activos: " + Arrays.toString(mejorCombinacion));


        int[] asignaciones = lectura.MatrizV2.asignarClientesACentrosActivos(matrizCostos, mejorCombinacion, grafo);


        System.out.println("Asignación de clientes a centros:");
        for (int i = 0; i < asignaciones.length; i++) {
            System.out.println("Cliente " + i + " -> Centro " + asignaciones[i]);
        }
    }
}
