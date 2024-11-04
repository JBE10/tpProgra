package lectura;
import apis.*;
import impl.*;
import org.junit.Test;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.ArrayList;
import java.util.Scanner; // Import the Scanner class to read text files

public class CargarGrafo {


    public static GrafoTDA cargarUsuarios(){
        GrafoTDA grafo= new GrafoLA() ;
        grafo.inicializarGrafo();
        try {
            File nodo = new File("/Users/bautiespino/Documents/Paradigma Orienado a Objetos/Progra III TP/tpProograIII/src/lectura/clientesYCentros.txt");
            Scanner myReader = new Scanner(nodo);


            while (myReader.hasNextLine()) {

                String data = myReader.nextLine();
                String[] parts = data.split(",");
                int id = Integer.parseInt(parts[0]);

                if (id>=50){
                    grafo.agregarVertice(id,true);
                }
                else{
                    grafo.agregarVertice(id,false);
                }
                System.out.println(id);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return grafo;
    }
    public static void cargarAristas(GrafoTDA grafo){

        try {
            File nodo = new File("/Users/bautiespino/Documents/Paradigma Orienado a Objetos/Progra III TP/tpProograIII/src/lectura/rutas.txt");
            Scanner myReader = new Scanner(nodo);


            while (myReader.hasNextLine()) {

                String data = myReader.nextLine();
                String[] parts = data.split(",");
                int nodoOrigen = Integer.parseInt(parts[0]);
                int nodoDestino = Integer.parseInt(parts[1]);
                int peso = Integer.parseInt(parts[2]);
                grafo.agregarArista(nodoOrigen,nodoDestino,peso);
                grafo.agregarArista(nodoDestino,nodoOrigen,peso);

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    public static GrafoTDA dijkstra(GrafoTDA grafo, int origen) {
        GrafoTDA caminoCorto = new GrafoLA();
        ConjuntoTDA vertices = grafo.vertices();
        ConjuntoTDA adyacentes;
        ColaPrioridadTDA adyacentesOrdenados = new ColaPrioridadLD();
        adyacentesOrdenados.inicializarCola();

        ConjuntoTDA nodosPorRecorrer = new ConjuntoLD();
        nodosPorRecorrer.inicializarConjunto();

        // Paso 1: Inicializar el grafo de caminos cortos y establecer distancias iniciales
        caminoCorto.inicializarGrafo();
        caminoCorto.agregarVertice(origen, false);
        caminoCorto.agregarArista(origen, origen, 0); // Distancia del origen a sí mismo es 0

        while (!vertices.conjuntoVacio()) {
            int aux = vertices.elegir();
            vertices.sacar(aux);
            if (aux != origen) { // Evita agregar el origen a sí mismo con MAX_VALUE
                caminoCorto.agregarVertice(aux, false);
                caminoCorto.agregarArista(origen, aux, Integer.MAX_VALUE); // Inicializar a MAX_VALUE
            }
        }

        // Paso 2: Inicializar la cola de prioridad con los adyacentes del origen
        nodosPorRecorrer = metodos.Ejercicios.Adyacentes(grafo, origen);
        while (!nodosPorRecorrer.conjuntoVacio()) {
            int aux = nodosPorRecorrer.elegir();
            nodosPorRecorrer.sacar(aux);
            int pesoArista = grafo.pesoArista(origen, aux);
            adyacentesOrdenados.acolarPrioridad(aux, pesoArista);
            caminoCorto.eliminarArista(origen, aux);
            caminoCorto.agregarArista(origen, aux, pesoArista); // Guardar distancia inicial
        }

        // Paso 3: Procesar cada nodo en la cola de prioridad
        while (!adyacentesOrdenados.colaVacia()) {
            int origenDijkstra = adyacentesOrdenados.primero();
            adyacentesOrdenados.desacolar();

            // Obtener la distancia acumulada hasta `origenDijkstra`
            int distanciaOrigenDijkstra = caminoCorto.pesoArista(origen, origenDijkstra);

            // Revisar y actualizar los adyacentes de `origenDijkstra`
            adyacentes = metodos.Ejercicios.Adyacentes(grafo, origenDijkstra);
            while (!adyacentes.conjuntoVacio()) {
                int verticeAuxiliar = adyacentes.elegir();
                adyacentes.sacar(verticeAuxiliar);

                // Calcular nueva distancia a `verticeAuxiliar` a través de `origenDijkstra`
                int nuevaDistancia = distanciaOrigenDijkstra + grafo.pesoArista(origenDijkstra, verticeAuxiliar);

                // Si encontramos un camino más corto, lo actualizamos
                if (nuevaDistancia < caminoCorto.pesoArista(origen, verticeAuxiliar)) {
                    caminoCorto.eliminarArista(origen, verticeAuxiliar); // Remover distancia anterior
                    caminoCorto.agregarArista(origen, verticeAuxiliar, nuevaDistancia); // Agregar nueva distancia

                    // Agregar `verticeAuxiliar` con su nueva distancia a la cola de prioridad
                    adyacentesOrdenados.acolarPrioridad(verticeAuxiliar, nuevaDistancia);
                }
            }
        }

        return caminoCorto;
    }

    public static Integer[][] grafoAMatriz(GrafoTDA grafo) {
        ConjuntoTDA vertices = grafo.vertices();
        int n = vertices.cardinal();
        Integer[][] matriz = new Integer[n][n];
        int[] verticeArray = new int[n];
        int index = 0;

        while (!vertices.conjuntoVacio()) {
            int vertice = vertices.elegir();
            verticeArray[index++] = vertice;
            vertices.sacar(vertice);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matriz[i][j] = grafo.pesoArista(verticeArray[i], verticeArray[j]);
            }
        }

        return matriz;
    }




}
