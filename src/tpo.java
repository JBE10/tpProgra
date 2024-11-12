import apis.GrafoTDA;
import impl.GrafoLA;
import core.costos;

import java.util.Arrays;

public class tpo {
    public static void main(String[] args) {

        boolean poda = false;
        if(args.length == 1)
            poda = args[0].equals("poda");

        GrafoTDA grafo = new GrafoLA();
        grafo.inicializarGrafo();

        grafo = lectura.CargarGrafo.cargarUsuarios();
        lectura.CargarGrafo.cargarAristas(grafo);

        int[][] matrizCostos = lectura.Matriz.crearMatrizDistanciasMinimas(grafo);
        matrizCostos = lectura.Matriz.actualizarMatriz(matrizCostos, grafo);



        int[] mejorCombinacion = costos.encontrarMejorCombinacion(matrizCostos, grafo, poda);
        System.out.println("Mejor combinación de centros activos: " + Arrays.toString(mejorCombinacion));


        int[] asignaciones = costos.asignarClientesACentrosActivos(matrizCostos, mejorCombinacion, grafo);


        System.out.println("Asignación de clientes a centros:");
        for (int i = 0; i < asignaciones.length; i++) {
            System.out.println("Cliente " + i + " -> Centro " + asignaciones[i]);
        }
    }
}
