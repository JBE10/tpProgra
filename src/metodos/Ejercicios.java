package metodos;
import apis.*;
import impl.*;


public class Ejercicios {
    /*----------------------------------------------------------------PILA----------------------------------------------------------------*/


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
    public static void repetidos(PilaTDA p1,ConjuntoTDA c1){
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




    /*----------------------------------------------------------------COLA----------------------------------------------------------------*/

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


    public static void repetidos(ColaTDA p1,ConjuntoTDA c1){
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




    /*----------------------------------------------------------------COLA CON PRIORIDADD----------------------------------------------------------------*/
    public static void pasar(ColaPrioridadTDA c1,ColaPrioridadTDA c2){
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
    /*----------------------------------------------------------------CONJUNTOS----------------------------------------------------------------*/
    public static void pasar(ConjuntoTDA c1,ConjuntoTDA c2){

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

    /*----------------------------------------------------------------DICCIONARIOS SIMPLES----------------------------------------------------------------*/


    public static void Mostrar(DiccionarioSimpleTDA d1){
        ConjuntoTDA claves=d1.claves();
        if (claves.conjuntoVacio()){
            System.out.println("Diccionario vacio");
        }
        while (!claves.conjuntoVacio()){
            int clave= claves.elegir();
            System.out.println("El valor de la clave: "+clave+" es "+d1.recuperar(clave));
            claves.sacar(clave);
        }
    }

    /*----------------------------------------------------------------DICCIONARIOS MULTIPLES----------------------------------------------------------------*/

    public static void Mostrar(DiccionarioMultipleTDA d1) {
        ConjuntoTDA claves = d1.claves();

        if (claves.conjuntoVacio()) {
            System.out.println("Diccionario vacío");
        }

        while (!claves.conjuntoVacio()) {
            int clave = claves.elegir();
            ConjuntoTDA valores = d1.recuperar(clave);
            claves.sacar(clave);

            System.out.print("Clave: " + clave + " Valores: ");

            while (!valores.conjuntoVacio()) {
                int elegir = valores.elegir();
                valores.sacar(elegir);
                System.out.print(elegir);

                if (!valores.conjuntoVacio()) {
                    System.out.print(", ");
                } else {
                    System.out.println();
                }
            }
        }
    }

    /*----------------------------------------------------------------ABB----------------------------------------------------------------*/
    public static void preorden(ABBTDA a){
        if (!a.arbolVacio()){

            System.out.println(a.raiz());
            preorden(a.hijoIzq());
            preorden(a.hijoDer());

        }
    }
    public static void inorden(ABBTDA a,ColaTDA cola){

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
    /*----------------------------------------------------------------GRAFOS----------------------------------------------------------------*/

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

    public static DiccionarioSimpleTDA PredecesoresDic(GrafoTDA grafo,int v){
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