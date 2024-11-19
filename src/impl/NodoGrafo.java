    package main.java.impl;

    public class NodoGrafo {

        int nodo;
        boolean centro;
        NodoArista arista;
        NodoGrafo sigNodo;
        int costoUnitarioEnviarMercaderia;
        int costoFijoAnualCentroDeDistribucion;
        int volumenProduccion;

        public boolean getCentro(){
            return this.centro;
        }
        public int getNodo(){
            return this.nodo;
        }
        public int getCostoUnitarioEnviarMercaderia(){
            return this.costoUnitarioEnviarMercaderia;
        }
        public int getCostoFijoAnualCentroDeDistribucion(){
            return this.costoFijoAnualCentroDeDistribucion;
        }
        public int getVolumenProduccion(){
            return this.volumenProduccion;
        }




        NodoGrafo() {
        }

        NodoGrafo(int nodo, boolean centro,int costoUnitarioEnviarMercaderia,int costoFijoAnualCentroDeDistribucion,int volumenProduccion){
            this.nodo = nodo;
            this.centro = centro;
            this.costoFijoAnualCentroDeDistribucion=costoFijoAnualCentroDeDistribucion;
            this.costoUnitarioEnviarMercaderia=costoUnitarioEnviarMercaderia;
            this.volumenProduccion=volumenProduccion;
        }


    }
