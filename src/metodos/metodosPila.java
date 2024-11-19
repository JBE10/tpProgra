package metodos;

import apis.PilaTDA;
import impl.PilaLD;
import apis.ConjuntoTDA;
public class metodosPila {

    public static void pasar(PilaTDA p, PilaTDA p2) {
        while (!p.pilaVacia()) {
            p2.apilar(p.tope());
            p.desapilar();

        }
    }

    public static void Copiar(PilaTDA p1, PilaTDA p2) {
        PilaTDA aux = new PilaLD();
        aux.inicializarPila();
        pasar(p1, aux);
        while (!aux.pilaVacia()) {
            p1.apilar(aux.tope());
            p2.apilar(aux.tope());
            aux.desapilar();
        }
    }
    public static void Mostrar(PilaTDA p1){
        PilaTDA aux=new PilaLD();
        aux.inicializarPila();
        Copiar(p1,aux);
        while (!aux.pilaVacia()){
            System.out.print(aux.tope()+" ");
            aux.desapilar();
        }
        System.out.println(" ");
    }

    public static void invertir(PilaTDA p1){
        PilaTDA aux=new PilaLD();
        aux.inicializarPila();
        Copiar(p1,aux);
        while(!p1.pilaVacia()){
            p1.desapilar();
        }
        pasar(aux,p1);
    }
    public static int contar(PilaTDA p1){
        PilaTDA aux=new PilaLD();
        aux.inicializarPila();
        Copiar(p1,aux);
        int N=0;
        while (!aux.pilaVacia()){
            N++;
            aux.desapilar();
        }
        return N;
    }

    public static float suma(PilaTDA p1){
        PilaTDA aux=new PilaLD();
        aux.inicializarPila();
        float N=0;
        Copiar(p1,aux);
        while(!aux.pilaVacia()){
            N+= aux.tope();
            aux.desapilar();
        }
        return N;
    }
    public static float promedio(PilaTDA p1){
        int Cant=contar(p1);
        float Sum=suma(p1);
        return Sum/Cant;
    }


    public static boolean capicua(PilaTDA c1) {
        boolean capicua = true;
        PilaTDA aux = new PilaLD();
        PilaTDA p = new PilaLD();
        aux.inicializarPila();
        p.inicializarPila();
        Copiar(c1,aux);
        pasar(aux,p);
        Copiar(c1,aux);
        while (!p.pilaVacia()){
            if (p.tope()!=aux.tope()){
                capicua=false;
                break;
            }
            aux.desapilar();
            p.desapilar();
        }

        return capicua;
    }


    public static void eliminar(PilaTDA p1){
        PilaTDA aux=new PilaLD();
        aux.inicializarPila();
        pasar(p1,aux);
        PilaTDA auxDos=new PilaLD();
        auxDos.inicializarPila();

        while (!aux.pilaVacia()){
            boolean encotrar=false;
            Copiar(p1,auxDos);
            while (!auxDos.pilaVacia()){
                if (auxDos.tope()==aux.tope()){
                    encotrar=true;
                    break;
                }
                auxDos.desapilar();
            }
            if (!encotrar){
                p1.apilar(aux.tope());
            }
            aux.desapilar();
        }
    }

    public static void dividir(PilaTDA p1, PilaTDA p2){
        PilaTDA aux=new PilaLD();
        aux.inicializarPila();
        pasar(p1,aux);
        int n=contar(aux);
        int s=contar(aux)/2;

        while (n>s){
            p1.apilar(aux.tope());
            aux.desapilar();
            n--;
        }
        while (!aux.pilaVacia()){
            p2.apilar(aux.tope());
            aux.desapilar();
        }

    }
    public static void repetidos(PilaTDA p1, ConjuntoTDA c1){
        PilaTDA aux=new PilaLD();
        aux.inicializarPila();
        PilaTDA auxP1=new PilaLD();
        Copiar(p1,auxP1);
        pasar(auxP1,aux);

        PilaTDA auxDos=new PilaLD();
        auxDos.inicializarPila();

        while (!aux.pilaVacia()){
            boolean encotrar=false;
            Copiar(auxP1,auxDos);
            while (!auxDos.pilaVacia()){
                if (auxDos.tope()==aux.tope()){
                    encotrar=true;
                    break;
                }
                auxDos.desapilar();
            }
            if (!encotrar){
                auxP1.apilar(aux.tope());
            }
            else if (encotrar) {
                c1.agregar(aux.tope());
            }

            aux.desapilar();
        }

    }



}
