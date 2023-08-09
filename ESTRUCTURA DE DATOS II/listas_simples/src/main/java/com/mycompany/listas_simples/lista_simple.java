/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.listas_simples;

/**
 *
 * @author asus
 */
public class lista_simple {

    public Nodo prim;
    public Nodo ult;
    public int cantelem;

    public lista_simple() {
        this.prim = this.ult = null;
        this.cantelem = 0;
    }

    public boolean vacia() {
        return cantelem == 0;
    }

    public String toStringL() {
        Nodo p = prim;
        String aux = "[";
        while (p != null) {
            aux = aux + p.elem;
            if (p.prox != null) {
                aux = aux + "-";
            }
            p = p.prox;
        }
        aux = aux + "]";
        return aux;
    }
    
}
