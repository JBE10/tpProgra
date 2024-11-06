package test;

import apis.GrafoTDA;
import impl.GrafoLA;

import java.util.Arrays;

public class TestGrafo {
    public static void main(String[] args) {
        GrafoTDA grafo = new GrafoLA();
        grafo.inicializarGrafo();


        grafo = lectura.CargarGrafo.cargarUsuarios();
        lectura.CargarGrafo.cargarAristas(grafo);


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
