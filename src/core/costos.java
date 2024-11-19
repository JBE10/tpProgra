package core;
import apis.ColaTDA;
import apis.ConjuntoTDA;
import apis.GrafoTDA;
import impl.ColaLD;
import impl.NodoGrafo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class costos {
    public static int[] encontrarMejorCombinacion(int[][] costos, GrafoTDA grafo, boolean poda) {
        int n = costos[0].length;
        List<int[]> combinaciones = new ArrayList<>();
        generarCombinaciones(new int[n], 0, combinaciones);
        int acumuladorPoda[] = new int[1];
        int acumuladorOperaciones = 0;

        int[] mejorCombinacion = null;
        int costoMinimo = Integer.MAX_VALUE;
        int combi=0;
        for (int[] combinacion : combinaciones) {
            combi++;
            acumuladorOperaciones += Arrays.stream(combinacion).sum()*50;
            if (esCombinacionValida(combinacion)) {
                int costoTotal = calcularCostoTotal(costos, combinacion,grafo, costoMinimo, poda, acumuladorPoda);
                if (costoTotal < costoMinimo) {
                    costoMinimo = costoTotal;
                    mejorCombinacion = combinacion.clone();
                }
            }
        }

        System.out.println("Costo mínimo: " + costoMinimo);
        System.out.println("Operaciones: " + acumuladorOperaciones);
        System.out.println("Poda: " + acumuladorPoda[0]);

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

    public static int calcularCostoTotal(int[][] costos, int[] combinacion,GrafoTDA grafo, int costoMinimo, boolean poda, int [] acumuladorPoda) {
        int costoTotal = 0;
        int m=0; /*Contador de operaciones*/

        ConjuntoTDA vertices = grafo.vertices();
        ColaTDA centros = new ColaLD();
        ColaTDA clientes = new ColaLD();
        int numCentros = 0;
        int numClientes = 0;
        centros.inicializarCola();
        clientes.inicializarCola();

        /*Armamos Cola de centros y clientes*/
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

        /*Calculo costos fijos segun combinacion de centros usada*/
        while(!centros.colaVacia()){
            NodoGrafo n=grafo.vert2Nodo(centros.primero());
            centros.desacolar();
            if (combinacion[i]==1){
                costoTotal+=n.getCostoFijoAnualCentroDeDistribucion();

            }
            i++;
            /*Elimino caso de que costo fijo es mayor que el minimo*/
            if(poda && costoTotal > costoMinimo) {
                acumuladorPoda[0]+=Arrays.stream(combinacion).sum()*50;
                return Integer.MAX_VALUE;
            }
        }


        for (int[] costo : costos) {
            int costoMinimoCliente = Integer.MAX_VALUE;
            boolean centroSeleccionado = false;
            for (int j = 0; j < combinacion.length; j++) {

                /*Calculo el costo minimo del centro J que esta activo en la combinacion al cliente*/
                if (combinacion[j] == 1) {
                    m++;
                    centroSeleccionado = true;
                    costoMinimoCliente = Math.min(costoMinimoCliente, costo[j]);
                }
            }
            if (centroSeleccionado) {
                costoTotal += costoMinimoCliente;
                if(poda && costoTotal > costoMinimo) {
                    acumuladorPoda[0]+=(Arrays.stream(combinacion).sum()*50)-m;
                    return Integer.MAX_VALUE;

                }
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

    public static int[] asignarClientesACentrosActivos(int[][] costos, int[] combinacion, GrafoTDA grafo) {

        int cantClientes = 0;
        ConjuntoTDA verticesAux = grafo.vertices();
        while (!verticesAux.conjuntoVacio()) {
            int vertice = verticesAux.elegir();
            verticesAux.sacar(vertice);
            NodoGrafo nodo = grafo.vert2Nodo(vertice);
            if (!nodo.getCentro()) {
                cantClientes++;
            }
        }

        int[] asignaciones = new int[cantClientes];


        ConjuntoTDA vertices = grafo.vertices();
        ColaTDA clientes = new ColaLD();
        clientes.inicializarCola();

        while (!vertices.conjuntoVacio()) {
            int vertice = vertices.elegir();
            vertices.sacar(vertice);
            NodoGrafo nodo = grafo.vert2Nodo(vertice);
            if (!nodo.getCentro()) {
                clientes.acolar(vertice);
            }
        }


        int clienteIndex = 0;
        while (!clientes.colaVacia()) {
            int cliente = clientes.primero();
            clientes.desacolar();

            int costoMinimo = Integer.MAX_VALUE;
            int centroAsignado = -1;

            for (int centro = 0; centro < combinacion.length; centro++) {
                if (combinacion[centro] == 1 && costos[cliente][centro] < costoMinimo) {
                    costoMinimo = costos[cliente][centro];
                    centroAsignado = centro;
                }
            }


            asignaciones[clienteIndex++] = centroAsignado;
        }

        return asignaciones;
    }


}
