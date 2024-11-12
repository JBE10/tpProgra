package lectura;
import apis.*;
import impl.*;


import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.ArrayList;
import java.util.Scanner; // Import the Scanner class to read text files

public class CargarGrafo {


    public static GrafoTDA cargarUsuarios(){
        GrafoTDA grafo= new GrafoLA() ;
        grafo.inicializarGrafo();
        try {
            File nodo = new File("C:\\Users\\luber\\Documents\\uade\\aypIII\\TPO3_FINAL\\src\\lectura\\clientesYCentros.txt");
            Scanner myReader = new Scanner(nodo);


            while (myReader.hasNextLine()) {

                String data = myReader.nextLine();
                String[] parts = data.split(",");
                int id = Integer.parseInt(parts[0]);


                if (id>=50){
                    grafo.agregarVertice(id,true,Integer.parseInt(parts[1]),Integer.parseInt(parts[2]),0);
                }
                else{
                    grafo.agregarVertice(id,false,0,0,Integer.parseInt(parts[1]));
                }
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
            File nodo = new File("C:\\Users\\luber\\Documents\\uade\\aypIII\\TPO3_FINAL\\src\\lectura\\rutas.txt");
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


        caminoCorto.inicializarGrafo();
        NodoGrafo n=grafo.vert2Nodo(origen);
        caminoCorto.agregarVertice(origen, false,0,0,n.getVolumenProduccion());

        caminoCorto.agregarArista(origen, origen, 0);

        while (!vertices.conjuntoVacio()) {
            int aux = vertices.elegir();
            NodoGrafo nodoAux=grafo.vert2Nodo(aux);
            vertices.sacar(aux);
            if (aux != origen) {
                caminoCorto.agregarVertice(aux, false,0,0,nodoAux.getVolumenProduccion());
                caminoCorto.agregarArista(origen, aux, Integer.MAX_VALUE);
            }
        }


        nodosPorRecorrer = metodos.metodosGrafos.Adyacentes(grafo, origen);
        while (!nodosPorRecorrer.conjuntoVacio()) {
            int aux = nodosPorRecorrer.elegir();
            nodosPorRecorrer.sacar(aux);
            int pesoArista = grafo.pesoArista(origen, aux);
            adyacentesOrdenados.acolarPrioridad(aux, pesoArista);
            caminoCorto.eliminarArista(origen, aux);
            caminoCorto.agregarArista(origen, aux, pesoArista);
        }


        while (!adyacentesOrdenados.colaVacia()) {
            int origenDijkstra = adyacentesOrdenados.primero();
            adyacentesOrdenados.desacolar();


            int distanciaOrigenDijkstra = caminoCorto.pesoArista(origen, origenDijkstra);


            adyacentes = metodos.metodosGrafos.Adyacentes(grafo, origenDijkstra);
            while (!adyacentes.conjuntoVacio()) {
                int verticeAuxiliar = adyacentes.elegir();
                adyacentes.sacar(verticeAuxiliar);


                int nuevaDistancia = distanciaOrigenDijkstra + grafo.pesoArista(origenDijkstra, verticeAuxiliar);


                if (nuevaDistancia < caminoCorto.pesoArista(origen, verticeAuxiliar)) {
                    caminoCorto.eliminarArista(origen, verticeAuxiliar);
                    caminoCorto.agregarArista(origen, verticeAuxiliar, nuevaDistancia);


                    adyacentesOrdenados.acolarPrioridad(verticeAuxiliar, nuevaDistancia);
                }
            }
        }

        return caminoCorto;
    }





}
