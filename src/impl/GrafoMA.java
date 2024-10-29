package impl;

import apis.ConjuntoTDA;
import apis.GrafoTDA;

public class GrafoMA implements GrafoTDA {

    static int n = 100;
    int[][] MAdy;
    int[] Etiqs;
    int cantNodos;

    public GrafoMA() {
    }

    public void inicializarGrafo() {
        this.MAdy = new int[n][n];
        this.Etiqs = new int[n];
        this.cantNodos = 0;
    }

    public void agregarVertice(int v) {
        this.Etiqs[this.cantNodos] = v;

        for(int i = 0; i <= this.cantNodos; ++i) {
            this.MAdy[this.cantNodos][i] = 0;
            this.MAdy[i][this.cantNodos] = 0;
        }

        ++this.cantNodos;
    }

    public void eliminarVertice(int v) {
        int ind = this.Vert2Indice(v);

        int k;
        for(k = 0; k < this.cantNodos; ++k) {
            this.MAdy[k][ind] = this.MAdy[k][this.cantNodos - 1];
        }

        for(k = 0; k < this.cantNodos; ++k) {
            this.MAdy[ind][k] = this.MAdy[this.cantNodos - 1][k];
        }

        this.Etiqs[ind] = this.Etiqs[this.cantNodos - 1];
        --this.cantNodos;
    }

    private int Vert2Indice(int v) {
        int i;
        for(i = this.cantNodos - 1; i >= 0 && this.Etiqs[i] != v; --i) {
        }

        return i;
    }

    public ConjuntoTDA vertices() {
        ConjuntoTDA Vert = new ConjuntoTA();
        Vert.inicializarConjunto();

        for(int i = 0; i < this.cantNodos; ++i) {
            Vert.agregar(this.Etiqs[i]);
        }

        return Vert;
    }

    public void agregarArista(int v1, int v2, int peso) {
        int o = this.Vert2Indice(v1);
        int d = this.Vert2Indice(v2);
        this.MAdy[o][d] = peso;
    }

    public void eliminarArista(int v1, int v2) {
        int o = this.Vert2Indice(v1);
        int d = this.Vert2Indice(v2);
        this.MAdy[o][d] = 0;
    }

    public boolean existeArista(int v1, int v2) {
        int o = this.Vert2Indice(v1);
        int d = this.Vert2Indice(v2);
        return this.MAdy[o][d] != 0;
    }

    public int pesoArista(int v1, int v2) {
        int o = this.Vert2Indice(v1);
        int d = this.Vert2Indice(v2);
        return this.MAdy[o][d];
    }
}
