/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.arbol_binario_2023;

/**
 *
 * @author asus
 */
public class Nodo {
    public Nodo izq;
    public Nodo der;
    public int elem;
    
    public Nodo(int ele){
        this.izq=this.der=null;
        this.elem=ele;
    }
}
