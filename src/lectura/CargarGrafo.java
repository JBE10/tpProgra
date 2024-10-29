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
    public static GrafoTDA dijkstra(GrafoTDA grafo, int origen){
        GrafoTDA caminoCorto = new GrafoLA();
        ConjuntoTDA vertices = grafo.vertices();
        ConjuntoTDA adyacentes;
        ColaPrioridadTDA adyacentesOrdenados= new ColaPrioridadLD();
        int origenDijkstra = origen;
        ConjuntoTDA nodosPorRecorrer = new ConjuntoLD();


        /*Tengo todos los vertices en un grafo sin aristas*/
        vertices.sacar(origen);
        caminoCorto.inicializarGrafo();
        caminoCorto.agregarVertice(origen);

        /*Tengo todas las aristas */
        while(!vertices.ConjuntoVacio()){
            int aux;
            aux = vertices.elegir();
            caminoCorto.AgregarVertice(aux);
            caminoCorto.AgregarArista(origen, aux, Integer.MAX_VALUE);
            vertices.Sacar(aux);

        }

        nodosPorRecorrer = metodos.MetodosGrafo.adyacenetes(grafo, origen);

        while(!nodosPorRecorrer.ConjuntoVacio()){
            int aux = nodosPorRecorrer.Elegir();
            nodosPorRecorrer.Sacar(aux);
            adyacentesOrdenados.AcolarPrioridad(aux, grafo.PesoArista(origen, aux));
        }

        while(!adyacentesOrdenados.ColaVacia()){

            adyacentes = metodos.MetodosGrafo.adyacenetes(grafo, origenDijkstra);

            while(!adyacentes.ConjuntoVacio()){
                int verticeAuxiliar = adyacentes.Elegir();
                adyacentes.Sacar(verticeAuxiliar);
                int distanciaAuxiliar;
                if(grafo.ExisteArista(origen, origenDijkstra))
                    distanciaAuxiliar = grafo.PesoArista(origen, origenDijkstra);
                else{
                    distanciaAuxiliar=0;
                }
                if(distanciaAuxiliar + grafo.PesoArista(origenDijkstra, verticeAuxiliar) < caminoCorto.PesoArista(origen, verticeAuxiliar)){
                    caminoCorto.EliminarArista(origen, verticeAuxiliar);
                    caminoCorto.AgregarArista(origenDijkstra, verticeAuxiliar, grafo.PesoArista(origenDijkstra, verticeAuxiliar));

                }


            }

            origenDijkstra=adyacentesOrdenados.Primero();
            adyacentesOrdenados.Desacolar();

        }

        return caminoCorto;
    }


}
