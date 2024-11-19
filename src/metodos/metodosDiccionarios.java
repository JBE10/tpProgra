package main.java.metodos;

import apis.ConjuntoTDA;
import apis.DiccionarioMultipleTDA;
import apis.DiccionarioSimpleTDA;

public class metodosDiccionarios {


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

}
