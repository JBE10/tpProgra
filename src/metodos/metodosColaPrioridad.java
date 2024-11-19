package main.java.metodos;

import apis.ColaPrioridadTDA;
import impl.ColaPrioridadLD;

public class metodosColaPrioridad {
    public static void pasar(ColaPrioridadTDA c1, ColaPrioridadTDA c2){
        while (!c1.colaVacia()){
            c2.acolarPrioridad(c1.primero(), c1.prioridad());
            c1.desacolar();
        }
    }

    public static void Copiar(ColaPrioridadTDA p1, ColaPrioridadTDA p2) {

        ColaPrioridadTDA aux = new ColaPrioridadLD();

        aux.inicializarCola();

        pasar(p1, aux);

        while (!aux.colaVacia()) {

            p1.acolarPrioridad(aux.primero(), aux.prioridad());

            p2.acolarPrioridad(aux.primero(), aux.prioridad());

            aux.desacolar();
        }

    }
    public static void funcion(ColaPrioridadTDA c1, ColaPrioridadTDA c2){
        ColaPrioridadTDA aux=new ColaPrioridadLD();
        aux.inicializarCola();

        while (!c1.colaVacia()){
            aux.acolarPrioridad(c1.primero(),1);
            c1.desacolar();
        }
        while (!c2.colaVacia()){
            aux.acolarPrioridad(c2.primero(),1);
            c2.desacolar();
        }
        Copiar(aux,c1);
    }


    public static void Mostrar(ColaPrioridadTDA c1){
        ColaPrioridadTDA aux=new ColaPrioridadLD();
        aux.inicializarCola();
        Copiar(c1,aux);
        while (!aux.colaVacia()){
            System.out.print(aux.primero() + " ");
            aux.desacolar();
        }
        System.out.println(" ");
    }
    public static boolean comparar(ColaPrioridadTDA c1,ColaPrioridadTDA c2){
        ColaPrioridadTDA auxP=new ColaPrioridadLD();
        auxP.inicializarCola();
        ColaPrioridadTDA auxS=new ColaPrioridadLD();
        auxS.inicializarCola();
        boolean iguales=true;
        Copiar(c1,auxP);
        Copiar(c2,auxS);
        while (!auxS.colaVacia() && !auxP.colaVacia()){
            if (auxS.colaVacia()|| auxP.colaVacia()){
                iguales=false;
                break;
            }
            else {
                if (auxP.primero()!= auxS.primero()){
                    iguales=false;
                    break;
                }
            }
            auxS.desacolar();
            auxP.desacolar();
        }
        return iguales;
    }
}
