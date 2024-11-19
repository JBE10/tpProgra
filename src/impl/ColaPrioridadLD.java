package main.java.impl;

import apis.ColaPrioridadTDA;

public class ColaPrioridadLD implements ColaPrioridadTDA {
    NodoPrioridad inicio;

    public ColaPrioridadLD() {
    }

    public void inicializarCola() {
        this.inicio = null;
    }

    public void acolarPrioridad(int x, int prioridad) {
        NodoPrioridad nuevo = new NodoPrioridad();
        nuevo.prioridad = prioridad;
        nuevo.dato = x;
        if (!this.colaVacia() && prioridad <= this.inicio.prioridad) {
            NodoPrioridad ant = null;

            NodoPrioridad act;
            for(act = this.inicio; act != null && prioridad <= act.prioridad; act = act.sig) {
                ant = act;
            }

            nuevo.sig = act;
            ant.sig = nuevo;
        } else {
            nuevo.sig = this.inicio;
            this.inicio = nuevo;
        }

    }

    public void desacolar() {
        this.inicio = this.inicio.sig;
    }

    public boolean colaVacia() {
        return this.inicio == null;
    }

    public int primero() {
        return this.inicio.dato;
    }

    public int prioridad() {
        return this.inicio.prioridad;
    }

    private class NodoPrioridad {
        int dato;
        int prioridad;
        NodoPrioridad sig;

        private NodoPrioridad() {
        }
    }
}
