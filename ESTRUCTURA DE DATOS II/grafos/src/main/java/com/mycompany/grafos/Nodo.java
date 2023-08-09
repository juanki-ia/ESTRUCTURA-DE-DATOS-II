/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grafos;

/**
 *
 * @author asus
 */
public class Nodo {

    public String nombre;
    public Nodo prox;
    public Arco prim;
    public Arco ult;

    public Nodo(String nombre, Nodo prox) {
        this.nombre = nombre;
        this.prox = prox;
        this.prim = this.ult = null;
    }

    public void agregarArco(Nodo destino, int valor) {
        Arco nuevoArco = new Arco(valor, destino, null);
        if (prim == null) {
            prim = ult = nuevoArco;
        } else {
            ult.prox = nuevoArco;
            ult = nuevoArco;
        }
    }

    Iterable<Arco> getArcos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
