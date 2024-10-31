package lectura;
import apis.*;
import impl.*;
import org.junit.Test;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
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


        vertices.sacar(origen);
        caminoCorto.inicializarGrafo();
        caminoCorto.agregarVertice(origen, false);


        while (!vertices.conjuntoVacio()) {
            int aux = vertices.elegir();
            vertices.sacar(aux);
            caminoCorto.agregarVertice(aux, false);
            caminoCorto.agregarArista(origen, aux, Integer.MAX_VALUE);
        }

        nodosPorRecorrer = metodos.Ejercicios.Adyacentes(grafo, origen);

        while (!nodosPorRecorrer.conjuntoVacio()) {
            int aux = nodosPorRecorrer.elegir();
            nodosPorRecorrer.sacar(aux);
            adyacentesOrdenados.acolarPrioridad(aux, grafo.pesoArista(origen, aux));
        }

        while (!adyacentesOrdenados.colaVacia()) {
            int origenDijkstra = adyacentesOrdenados.primero();
            adyacentesOrdenados.desacolar();

            adyacentes = metodos.Ejercicios.Adyacentes(grafo, origenDijkstra);

            while (!adyacentes.conjuntoVacio()) {
                int verticeAuxiliar = adyacentes.elegir();
                adyacentes.sacar(verticeAuxiliar);
                int distanciaAuxiliar = grafo.pesoArista(origen, origenDijkstra);

                if (distanciaAuxiliar + grafo.pesoArista(origenDijkstra, verticeAuxiliar) < caminoCorto.pesoArista(origen, verticeAuxiliar)) {
                    caminoCorto.eliminarArista(origen, verticeAuxiliar);
                    caminoCorto.agregarArista(origen, verticeAuxiliar, distanciaAuxiliar + grafo.pesoArista(origenDijkstra, verticeAuxiliar));
                }
            }
        }

        return caminoCorto;
    }



}
