package impl;

import apis.ABBTDA;

public class AVL implements ABBTDA {
    NodoAVL nodo;

    public AVL() {
    }

    public void agregarElem(int x) {
        if (this.nodo == null) {
            this.nodo = new NodoAVL();
            this.nodo.raiz = x;
            this.nodo.hijoIzq = new AVL();
            this.nodo.hijoIzq.inicializarArbol();
            this.nodo.hijoDer = new AVL();
            this.nodo.hijoDer.inicializarArbol();
            System.out.println("Agrego:" + x);
        } else if (this.nodo.raiz > x) {
            this.nodo.hijoIzq.agregarElem(x);
            this.balancear(this);
        } else if (this.nodo.raiz < x) {
            this.nodo.hijoDer.agregarElem(x);
            this.balancear(this);
        }

    }

    public boolean arbolVacio() {
        return this.nodo == null;
    }

    public void eliminarElem(int x) {
        if (this.nodo != null) {
            if (this.nodo.raiz == x) {
                if (this.nodo.hijoIzq.arbolVacio() && this.nodo.hijoDer.arbolVacio()) {
                    this.nodo = null;
                    System.out.println("Elimino:" + x);
                } else if (!this.nodo.hijoIzq.arbolVacio()) {
                    this.nodo.raiz = this.mayor(this.nodo.hijoIzq);
                    this.nodo.hijoIzq.eliminarElem(this.nodo.raiz);
                    this.balancear(this);
                } else {
                    this.nodo.raiz = this.menor(this.nodo.hijoDer);
                    this.nodo.hijoDer.eliminarElem(this.nodo.raiz);
                    this.balancear(this);
                }
            } else if (this.nodo.raiz > x) {
                this.nodo.hijoIzq.eliminarElem(x);
                this.balancear(this);
            } else {
                this.nodo.hijoDer.eliminarElem(x);
                this.balancear(this);
            }
        }

    }

    public AVL hijoDer() {
        return this.nodo.hijoDer;
    }

    public AVL hijoIzq() {
        return this.nodo.hijoIzq;
    }

    public void inicializarArbol() {
        this.nodo = null;
    }

    public int raiz() {
        return this.nodo.raiz;
    }

    private int mayor(ABBTDA a) {
        int res;
        if (a.hijoDer().arbolVacio()) {
            res = a.raiz();
        } else {
            res = this.mayor(a.hijoDer());
        }

        return res;
    }

    private int menor(ABBTDA a) {
        int res;
        if (a.hijoIzq().arbolVacio()) {
            res = a.raiz();
        } else {
            res = this.menor(a.hijoIzq());
        }

        return res;
    }

    private int getFE() {
        int alturaIzq = this.altura(this.hijoIzq());
        int alturaDer = this.altura(this.hijoDer());
        return alturaDer - alturaIzq;
    }

    private int altura(ABBTDA a) {
        int altura = -1;
        if (!a.arbolVacio()) {
            if (a.hijoIzq().arbolVacio() && a.hijoDer().arbolVacio()) {
                altura = 0;
            } else {
                int ai = this.altura(a.hijoIzq());
                int ad = this.altura(a.hijoDer());
                altura = 1 + (ai > ad ? ai : ad);
            }
        }

        return altura;
    }

    private void balancear(AVL a) {
        if (a.getFE() >= 2) {
            System.out.print("Rotacion ");
            if (a.hijoDer().getFE() >= 0) {
                System.out.println("Simple a izquierda ");
                this.rotarIzq(a);
            } else {
                System.out.println("Doble derecha-izquierda");
                this.rotarDer(a.hijoDer());
                this.rotarIzq(a);
            }
        } else if (a.getFE() <= -2) {
            System.out.print("Rotacion ");
            if (a.hijoIzq().getFE() <= 0) {
                System.out.println("Simple a derecha ");
                this.rotarDer(a);
            } else {
                System.out.println("Doble izquierda-derecha");
                this.rotarIzq(a.hijoIzq());
                this.rotarDer(a);
            }
        }

    }

    private void rotarIzq(AVL a) {
        NodoAVL nuevoPadre = a.hijoDer().nodo;
        a.hijoDer().nodo = nuevoPadre.hijoIzq.nodo;
        nuevoPadre.hijoIzq.nodo = a.nodo;
        a.nodo = nuevoPadre;
    }

    private void rotarDer(AVL a) {
        NodoAVL nuevoPadre = a.hijoIzq().nodo;
        a.hijoIzq().nodo = nuevoPadre.hijoDer.nodo;
        nuevoPadre.hijoDer.nodo = a.nodo;
        a.nodo = nuevoPadre;
    }

    class NodoAVL {
        int raiz;
        AVL hijoIzq;
        AVL hijoDer;

        NodoAVL() {
        }
    }

}
