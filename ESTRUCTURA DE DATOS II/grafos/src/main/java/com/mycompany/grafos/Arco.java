/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grafos;

/**
 *
 * @author asus
 */
public class Arco {
    public int valor;
    public Nodo pDestino;
    public Arco prox;
    
    public Arco(int valor,Nodo destino,Arco prox){
        this.valor=valor;
        this.pDestino=destino;
        this.prox=prox;
    }

    Nodo getDestino() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
