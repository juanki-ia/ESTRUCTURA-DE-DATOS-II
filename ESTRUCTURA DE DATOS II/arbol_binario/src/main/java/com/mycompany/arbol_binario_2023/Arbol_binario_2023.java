/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.arbol_binario_2023;


public class Arbol_binario_2023 {
    
    public static void main(String[] args) {
        arbol_binario a=new arbol_binario();
        
        a.insertar(10);
        a.insertar(5);
        a.insertar(15);
        a.insertar(20);
        a.insertar(3);
        System.out.print("inorden:");
        a.inorden();
        System.out.println("");
        System.out.println(a.AlturaMayor());
        
    }
    
}
