    package impl;

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

        NodoGrafo(int nodo, boolean centro){
            this.nodo = nodo;
            this.centro = centro;
        }


    }
