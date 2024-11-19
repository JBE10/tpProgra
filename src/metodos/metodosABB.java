package main.java.metodos;

import apis.ABBTDA;
import apis.ColaTDA;

public class metodosABB {
    public static void preorden(ABBTDA a){
        if (!a.arbolVacio()){

            System.out.println(a.raiz());
            preorden(a.hijoIzq());
            preorden(a.hijoDer());

        }
    }
    public static void inorden(ABBTDA a, ColaTDA cola){

        if (!a.arbolVacio()){
            inorden(a.hijoIzq(),cola);

            cola.acolar(a.raiz());

            inorden(a.hijoDer(),cola);
        }

    }


    public static void postorden(ABBTDA a){
        if (!a.arbolVacio()){
            preorden(a.hijoDer());
            preorden(a.hijoIzq());
            System.out.println(a.raiz());



        }
    }

    public static boolean encontrar(ABBTDA a, int i) {
        boolean encontrar=false;
        if (!a.arbolVacio()){
            if (a.raiz()==i){
                encontrar=true;
                return encontrar;

            }
            encontrar(a.hijoIzq(),i);
            encontrar(a.hijoIzq(),i);

        }
        return encontrar;
    }
}
