package metodos;

import apis.ColaTDA;
import apis.ConjuntoTDA;
import apis.PilaTDA;
import impl.ColaLD;
import impl.PilaLD;

public class metodosCola {

    public static void pasar(ColaTDA c, ColaTDA c2) {
        while (!c.colaVacia()) {
            c2.acolar(c.primero());
            c.desacolar();

        }
    }

    public static void Copiar(ColaTDA p1, ColaTDA p2) {

        ColaTDA aux = new ColaLD();

        aux.inicializarCola();

        pasar(p1, aux);

        while (!aux.colaVacia()) {

            p1.acolar(aux.primero());

            p2.acolar(aux.primero());

            aux.desacolar();
        }
    }
    public static void Mostrar(ColaTDA c){
        ColaTDA aux=new ColaLD();
        aux.inicializarCola();
        Copiar(c, aux);
        while (!aux.colaVacia()){
            System.out.print(aux.primero()+" ");
            aux.desacolar();
        }
        System.out.println("");
    }
    public static void invertircon(ColaTDA c){
        PilaTDA aux=new PilaLD();
        while(!c.colaVacia()){
            aux.apilar(c.primero());
            c.desacolar();
        }
        while (!aux.pilaVacia()) {
            c.acolar(aux.tope());
            aux.desapilar();
        }
    }

    public static int contar(ColaTDA c1){
        ColaTDA aux=new ColaLD();
        aux.inicializarCola();

        Copiar(c1, aux);


        int N=0;

        while (!aux.colaVacia()){
            N++;
            aux.desacolar();
        }
        return N;
    }

    public static float suma(ColaTDA c1){
        ColaTDA aux=new ColaLD();
        aux.inicializarCola();
        float N=0;
        Copiar(c1,aux);
        while(!aux.colaVacia()){
            N+= aux.primero();
            aux.desacolar();
        }
        return N;
    }
    public static float promedio(ColaTDA c1){
        int Cant=contar(c1);
        float Sum=suma(c1);
        return Sum/Cant;
    }


    public static boolean capicua(ColaTDA c1){
        boolean capicua=true;
        PilaTDA p=new PilaLD();
        ColaTDA aux=new ColaLD();
        p.inicializarPila();
        aux.inicializarCola();
        Copiar(c1,p);
        Copiar(c1,aux);
        while (!aux.colaVacia()){
            if (aux.primero()!=p.tope()){
                capicua=false;
                break;
            }
            aux.desacolar();
            p.desapilar();
        }
        return capicua;
    }



    public static void pasar(ColaTDA c, PilaTDA c2) {
        while (!c.colaVacia()) {
            c2.apilar(c.primero());
            c.desacolar();

        }
    }


    public static void Copiar(ColaTDA p1, PilaTDA p2) {
        PilaTDA aux = new PilaLD();
        aux.inicializarPila();
        pasar(p1, aux);
        while (!aux.pilaVacia()) {
            p1.acolar(aux.tope());
            p2.apilar(aux.tope());
            aux.desapilar();
        }
    }



    public static boolean esinversa(ColaTDA c1,ColaTDA c2){
        ColaTDA c1aux=new ColaLD();
        c1aux.inicializarCola();

        Copiar(c1,c1aux);
        ColaTDA c2aux=new ColaLD();
        c2aux.inicializarCola();
        Copiar(c2,c2aux);

        invertircon(c2);

        boolean es=true;
        while (!c1aux.colaVacia() && !c2.colaVacia()){
            if (c1aux.colaVacia()||c1aux.colaVacia()){
                es=false;
                break;
            } else if (c1aux.primero()!= c2.primero()) {
                es=false;
                break;
            }

            c1aux.desacolar();
            c2.desacolar();
        }
        Copiar(c2aux,c2);
        return es;

    }



    public static void eliminar(ColaTDA p1){
        ColaTDA aux=new ColaLD();
        aux.inicializarCola();
        pasar(p1,aux);
        ColaTDA auxDos=new ColaLD();
        auxDos.inicializarCola();

        while (!aux.colaVacia()){
            boolean encotrar=false;
            Copiar(p1,auxDos);
            while (!auxDos.colaVacia()){
                if (auxDos.primero()==aux.primero()){
                    encotrar=true;
                    break;
                }
                auxDos.desacolar();
            }
            if (!encotrar){
                p1.acolar(aux.primero());
            }
            aux.desacolar();
        }
    }


    public static void dividir(ColaTDA p1, ColaTDA p2){
        ColaTDA aux=new ColaLD();
        aux.inicializarCola();
        pasar(p1,aux);
        int n=contar(aux);
        int s=contar(aux)/2;

        while (n>s){
            p1.acolar(aux.primero());
            aux.desacolar();
            n--;
        }
        while (!aux.colaVacia()){
            p2.acolar(aux.primero());
            aux.desacolar();
        }

    }


    public static void repetidos(ColaTDA p1, ConjuntoTDA c1){
        ColaTDA aux=new ColaLD();
        aux.inicializarCola();
        ColaTDA auxP1=new ColaLD();
        Copiar(p1,auxP1);
        pasar(auxP1,aux);

        PilaTDA auxDos=new PilaLD();
        auxDos.inicializarPila();

        while (!aux.colaVacia()){
            boolean encotrar=false;
            Copiar(auxP1,auxDos);
            while (!auxDos.pilaVacia()){
                if (auxDos.tope()==aux.primero()){
                    encotrar=true;
                    break;
                }
                auxDos.desapilar();
            }
            if (!encotrar){
                auxP1.acolar(aux.primero());
            }
            else if (encotrar) {
                c1.agregar(aux.primero());
            }

            aux.desacolar();
        }

    }




}
