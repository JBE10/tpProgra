package lectura;

import apis.ConjuntoTDA;
import apis.GrafoTDA;
import impl.ConjuntoLD;
import impl.NodoGrafo;
import impl.*;
import apis.*;

public class Matriz {

    public static int[][] crearMatrizDistanciasMinimas(GrafoTDA grafo) {
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

        int[][] matrizDistancias = new int[numClientes][numCentros];

        int i = 0;
        while (!centros.colaVacia()) {
            int numero = centros.primero();
            centros.desacolar();
            GrafoTDA grafoDijkstra = lectura.CargarGrafo.dijkstra(grafo, numero);
            ColaTDA aux = new ColaLD();
            aux.inicializarCola();
            metodos.Ejercicios.Copiar(clientes, aux);

            int j = 0;
            while (!aux.colaVacia()) {
                int cliente = aux.primero();
                aux.desacolar();
                matrizDistancias[j][i] = grafoDijkstra.pesoArista(numero, cliente);
                j += 1;
            }
            i += 1;
        }

        return matrizDistancias;
    }


    public static void imprimirMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}
