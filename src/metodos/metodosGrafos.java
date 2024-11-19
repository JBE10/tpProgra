package metodos;

import apis.*;
import impl.*;


import static metodos.metodosABB.inorden;
import static main.java.metodos.metodosConjuntos.len;

public class metodosGrafos {
    public static ConjuntoTDA AdyacentesDobles(GrafoTDA g, int v){

        ConjuntoTDA c=new ConjuntoLD();

        c.inicializarConjunto();

        ConjuntoTDA aux=g.vertices();

        while (!aux.conjuntoVacio()){

            int x= aux.elegir();
            aux.sacar(x);

            if (g.existeArista(v,x)){
                ConjuntoTDA auxX=g.vertices();
                aux.sacar(x);

                while (!auxX.conjuntoVacio()){
                    int w= auxX.elegir();
                    auxX.sacar(w);
                    if (g.existeArista(x,w)){
                        c.agregar(w);
                    }

                }
            }
        }

        return c;
    }
    public static ConjuntoTDA Adyacentes(GrafoTDA g, int v) {
        ConjuntoTDA c = new ConjuntoLD();
        c.inicializarConjunto();

        ConjuntoTDA aux = g.vertices();


        while (!aux.conjuntoVacio()) {
            int x = aux.elegir();
            aux.sacar(x);


            if (g.existeArista(v, x)) {
                c.agregar(x);
            }
        }

        return c;
    }



    public static int MayorCosto(GrafoTDA g,int v){
        ConjuntoTDA vertices=g.vertices();
        vertices.sacar(v);
        int costo=0;
        while (!vertices.conjuntoVacio()){
            int vertice= vertices.elegir();
            vertices.sacar(vertice);
            if (g.existeArista(v,vertice)){
                if (g.pesoArista(v,vertice)>costo){
                    costo= g.pesoArista(v,vertice);

                }
            }
        }
        return costo;
    }

    public static ConjuntoTDA Predecesores(GrafoTDA grafo,int v){
        ConjuntoTDA vertices= grafo.vertices();
        vertices.sacar(v);

        ConjuntoTDA predecesor=new ConjuntoLD();
        predecesor.inicializarConjunto();

        while (!vertices.conjuntoVacio()){
            int x=vertices.elegir();
            vertices.sacar(x);
            if (grafo.existeArista(x,v)){
                predecesor.agregar(x);
            }
        }
        return predecesor;
    }



    public static ConjuntoTDA Aislados(GrafoTDA grafo){
        ConjuntoTDA aislado = new ConjuntoLD();
        aislado.inicializarConjunto();
        ConjuntoTDA vertices = grafo.vertices();

        while (!vertices.conjuntoVacio()){
            int v = vertices.elegir();
            vertices.sacar(v);

            ConjuntoTDA entradas = Predecesores(grafo, v);
            boolean salidas = false;

            ConjuntoTDA salida = grafo.vertices();
            while (!salida.conjuntoVacio()){
                int w = salida.elegir();
                salida.sacar(w);

                if (grafo.existeArista(v, w)){
                    salidas = true;
                    break;
                }
            }
            if (entradas.conjuntoVacio() && !salidas){
                aislado.agregar(v);
            }
        }
        return aislado;
    }


    public static ConjuntoTDA Puente(GrafoTDA grafo,int v , int w){
        ConjuntoTDA puentes=new ConjuntoLD();

        puentes.inicializarConjunto();


        ConjuntoTDA vertices= grafo.vertices();
        vertices.sacar(w);

        while (!vertices.conjuntoVacio()){
            int vertice= vertices.elegir();
            vertices.sacar(vertice);
            if (grafo.existeArista(v,vertice)){
                ConjuntoTDA entradas=Predecesores(grafo, w);
                while (!entradas.conjuntoVacio()){
                    int entrada= entradas.elegir();
                    entradas.sacar(entrada);
                    if (entrada==vertice){
                        puentes.agregar(vertice);
                    }
                }
            }
        }
        return puentes;
    }

    public static int Grado(GrafoTDA grafo,int v){
        int grado=0;
        ConjuntoTDA restas=Predecesores(grafo, v);
        ConjuntoTDA vectores= grafo.vertices();
        int resta=len(restas);
        while (!vectores.conjuntoVacio()){
            int vector= vectores.elegir();
            vectores.sacar(vector);

            if (grafo.existeArista(v,vector)){
                grado++;
            }
        }
        grado=grado-resta;
        return grado;
    }

    public static ColaTDA MenorMayorVertice(GrafoTDA grafo){

        ABBTDA arbol=new AVL();
        ConjuntoTDA vertices= grafo.vertices();
        while (!vertices.conjuntoVacio()) {
            int vertice = vertices.elegir();
            vertices.sacar(vertice);
            arbol.agregarElem(vertice);
        }
        ColaTDA tabla=new ColaLD();
        tabla.inicializarCola();
        inorden(arbol,tabla);

        return tabla;
    }

    public static DiccionarioSimpleTDA PredecesoresDic(GrafoTDA grafo, int v){
        DiccionarioSimpleTDA diccionario=new DicSimpleL();
        diccionario.inicializarDiccionario();



        ConjuntoTDA c=Predecesores(grafo, v);
        while(!c.conjuntoVacio()){
            int x=c.elegir();
            c.sacar(x);
            int peso= grafo.pesoArista(x,v);
            diccionario.agregar(x,peso);
        }
        return diccionario;
    }
    public static DiccionarioSimpleTDA GradoDic(GrafoTDA grafo){
        ConjuntoTDA vertices=grafo.vertices();
        DiccionarioSimpleTDA dicgrado=new DicSimpleL();
        dicgrado.inicializarDiccionario();
        while (!vertices.conjuntoVacio()){
            int vertice= vertices.elegir();
            vertices.sacar(vertice);
            int grado=Grado(grafo, vertice);
            dicgrado.agregar(vertice,grado);

        }
        return dicgrado;
    }

    public static DiccionarioMultipleTDA PesoDic(GrafoTDA grafo) {

        DiccionarioMultipleTDA diccionario=new DicMultipleL();
        diccionario.inicializarDiccionario();
        ConjuntoTDA vertices=grafo.vertices();
        while (!vertices.conjuntoVacio()) {
            int vertice=vertices.elegir();
            vertices.sacar(vertice);
            ConjuntoTDA aux=grafo.vertices();
            aux.sacar(vertice);
            ConjuntoTDA pre=Predecesores(grafo, vertice);
            boolean bandera=false;
            while (!aux.conjuntoVacio()) {
                int clave=aux.elegir();
                aux.sacar(clave);
                if (grafo.existeArista(vertice, clave)) {
                    bandera=true;
                    diccionario.agregar(vertice, grafo.pesoArista(vertice, clave));
                }
            }
            if (pre.conjuntoVacio()&&!bandera){
                diccionario.agregar(vertice,0);
            }

            while (!pre.conjuntoVacio()) {
                int auxDos=pre.elegir();
                pre.sacar(auxDos);
                int valor=-1*grafo.pesoArista(auxDos, vertice);
                diccionario.agregar(vertice, valor);
            }

        }
        return diccionario;
    }

    public static ColaTDA PesoCola(GrafoTDA grafo,int v) {

        ABBTDA arboldesodenada=new AVL();
        arboldesodenada.inicializarArbol();
        ConjuntoTDA verticesPrecesor=Predecesores(grafo, v);
        ConjuntoTDA vertices=grafo.vertices();
        ColaTDA colainOrden=new ColaLD();
        colainOrden.inicializarCola();

        while (!vertices.conjuntoVacio()) {
            int vertice=vertices.elegir();
            vertices.sacar(vertice);
            if (grafo.existeArista(v, vertice)) {
                arboldesodenada.agregarElem(grafo.pesoArista(v, vertice));
            }
        }
        while (!verticesPrecesor.conjuntoVacio()) {
            int verticepre=verticesPrecesor.elegir();
            verticesPrecesor.sacar(verticepre);
            arboldesodenada.agregarElem(grafo.pesoArista(verticepre, v));

        }
        inorden(arboldesodenada, colainOrden);

        return colainOrden;
    }



}
