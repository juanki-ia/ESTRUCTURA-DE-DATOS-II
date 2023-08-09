/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.listas_arreglos;

/**
 *
 * @author asus
 */
public class Listas_arreglos {

    public static void main(String[] args) {
        lista_con_arreglos l = new lista_con_arreglos();
        l.insertarPrim(3);
        l.insertarUlt(5);
        l.insertarPrim(15);
        l.insertarPrim(5);
        System.out.println(l.toStringL());
        l.eliminarTodo(5);
        System.out.println(l.toStringL());

    }
}
