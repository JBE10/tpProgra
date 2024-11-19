package main.java.metodos;

import apis.ConjuntoTDA;
import impl.ConjuntoLD;

public class metodosConjuntos {

    public static void pasar(ConjuntoTDA c1, ConjuntoTDA c2){

        while (!c1.conjuntoVacio()){
            int n= c1.elegir();
            c2.agregar(n);
            c1.sacar(n);
        }
    }

    public static void Copiar(ConjuntoTDA p1, ConjuntoTDA p2) {

        ConjuntoTDA aux = new ConjuntoLD();

        aux.inicializarConjunto();

        pasar(p1, aux);

        while (!aux.conjuntoVacio()) {
            int n=aux.elegir();
            p1.agregar(n);

            p2.agregar(n);

            aux.sacar(n);
        }
    }


    public static void Mostrar(ConjuntoTDA c1){
        ConjuntoTDA aux=new ConjuntoLD();
        aux.inicializarConjunto();
        Copiar(c1,aux);
        while (!aux.conjuntoVacio()){
            int n= aux.elegir();
            System.out.print(n+ " ");
            aux.sacar(n);
        }
        System.out.println(" ");
    }


    public static int len(ConjuntoTDA c1){
        ConjuntoTDA aux=new ConjuntoLD();
        aux.inicializarConjunto();
        Copiar(c1,aux);

        int contardor=0;
        while (!aux.conjuntoVacio()){
            int elegir=aux.elegir();
            contardor++;

            aux.sacar(elegir);
        }

        return contardor;
    }

}
