
package com.mycompany.grafos;


public class Grafos {

    public static void main(String[] args) {
        Grafo grafo = new Grafo();
        grafo.agregarNodo("A");
        grafo.agregarNodo("B");
        grafo.agregarNodo("C");
        grafo.agregarNodo("D");

        grafo.agregarArco("A", "B", 2);
        grafo.agregarArco("A", "D", 15);
        grafo.agregarArco("B", "C", 3);
        grafo.agregarArco("C", "D", 4);
        grafo.agregarArco("D", "D", 25);
        
        
        System.out.println("-----------------GRAFOS CREAR Y CONSULTAR-----------------");
        grafo.mostrarGrafo();
        System.out.println("la cantidad de arcos es :"+grafo.cantArcos);
        System.out.println("la cantidad de arcos que llegan a B:"+grafo.cantidadLlegadas("A"));
        System.out.println("la cantidad de nodos es:"+grafo.cantnodos);
        System.out.println("el mayor valor del grafo es:"+grafo.mayorValor());
        grafo.mostrarNodosBucle();
        
        
        System.out.println("-----------------GRAFOS RECORRIDOS----------");
        grafo.mostrarCaminos("A", "D");
        System.out.println("cantidad de caminos: A->D: "+grafo.cantidadCaminos("A", "D"));
        grafo.mostrarTotalCamino("A", "D");
        grafo.mostrarCaminoCorto("A", "D");
        grafo.mostrarCaminoLargo("A", "D");
    }
}

