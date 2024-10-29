package impl;

import apis.ConjuntoSTDA;

import java.util.Random;


public class ConjuntoSD implements ConjuntoSTDA {
    NodoString c;
    int cant;

    public ConjuntoSD(){

    }
    @Override
    public void inicializarConjunto() {
        c=null;


    }

    @Override
    public void agregar(String var1) {
        if (!pertenece(var1)){
            NodoString aux = new NodoString();
            aux.info = var1;
            aux.sig =c;
            c = aux;
            cant++;

        }

    }

    @Override
    public void sacar(String var1) {
        if (c != null) {
            if (c.info == var1) {
                c = c.sig;
                cant--;
            }
            else {
                NodoString aux;
                for(aux = c; aux.sig != null && aux.sig.info != var1; aux = aux.sig) {
                }

                if (aux.sig != null) {
                    aux.sig = aux.sig.sig;
                    cant--;
                }
            }
        }

    }

    @Override
    public boolean conjuntoVacio() { return c==null;}

    @Override
    public String elegir(){
        Random rand = new Random();
        int x = rand.nextInt(cant);
        NodoString aux = c;


        for(int i = 0; i < x; ++i) {
            aux = aux.sig;
        }


        return aux.info;


    }
    @Override
    public boolean pertenece(String var1) {
        NodoString aux;

        for (aux=c ; aux != null && aux.info!=var1; aux=aux.sig){

        }
        return aux!=null;

    }

}
