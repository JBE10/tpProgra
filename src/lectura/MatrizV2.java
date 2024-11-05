package lectura;
import apis.ColaTDA;
import apis.ConjuntoTDA;
import apis.GrafoTDA;
import impl.ColaLD;
import impl.NodoGrafo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class MatrizV2 {
    public static int[] encontrarMejorCombinacion(int[][] costos, GrafoTDA grafo) {
        int n = costos[0].length; // Número de centros
        List<int[]> combinaciones = new ArrayList<>();
        generarCombinaciones(new int[n], 0, combinaciones);

        int[] mejorCombinacion = null;
        int costoMinimo = Integer.MAX_VALUE;

        for (int[] combinacion : combinaciones) {

            if (esCombinacionValida(combinacion)) {
                int costoTotal = calcularCostoTotal(costos, combinacion,grafo);
                if (costoTotal < costoMinimo) {
                    costoMinimo = costoTotal;
                    mejorCombinacion = combinacion.clone();
                }
            }
        }

        System.out.println("Costo mínimo: " + costoMinimo);
        return mejorCombinacion;
    }

    public static void generarCombinaciones(int[] vector, int index, List<int[]> combinaciones) {
        if (index == vector.length) {
            combinaciones.add(vector.clone());
            return;
        }

        vector[index] = 0;
        generarCombinaciones(vector, index + 1, combinaciones);

        vector[index] = 1;
        generarCombinaciones(vector, index + 1, combinaciones);
    }

    public static int calcularCostoTotal(int[][] costos, int[] combinacion,GrafoTDA grafo) {
        int costoTotal = 0;

        ConjuntoTDA vertices = grafo.vertices();
        ColaTDA centros = new ColaLD();
        ColaTDA clientes = new ColaLD();
        int numCentros = 0;
        int numClientes = 0;
        centros.inicializarCola();
        clientes.inicializarCola();

        while (!vertices.conjuntoVacio()) {
            int vertice = vertices.elegir();
            vertices.sacar(vertice);
            NodoGrafo nodo = grafo.vert2Nodo(vertice);
            if (nodo.getCentro()) {
                numCentros += 1;
                centros.acolar(vertice);
            } else {
                numClientes += 1;
                clientes.acolar(vertice);
            }
        }
        int i=0;
        while(!centros.colaVacia()){
            NodoGrafo n=grafo.vert2Nodo(centros.primero());
            centros.desacolar();
            if (combinacion[i]==1){
                costoTotal+=n.getCostoFijoAnualCentroDeDistribucion();

            }
            i++;
        }


        for (int[] costo : costos) {
            int costoMinimoCliente = Integer.MAX_VALUE;
            boolean centroSeleccionado = false;
            for (int j = 0; j < combinacion.length; j++) {
                if (combinacion[j] == 1) {
                    centroSeleccionado = true;
                    costoMinimoCliente = Math.min(costoMinimoCliente, costo[j]);
                }
            }
            if (centroSeleccionado) {
                costoTotal += costoMinimoCliente;
            } else {

                costoTotal += Integer.MAX_VALUE;
            }
        }
        return costoTotal;
    }

    public static boolean esCombinacionValida(int[] combinacion) {
        for (int valor : combinacion) {
            if (valor == 1) {
                return true;
            }
        }
        return false;
    }

}
