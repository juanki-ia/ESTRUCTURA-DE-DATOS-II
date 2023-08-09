package com.mycompany.grafos;

import java.util.*;

public class Grafo {

    public Nodo prim;
    public Nodo ult;
    public int cantnodos;
    public int cantArcos;

    public Grafo() {
        this.prim = this.ult = null;
        this.cantnodos = 0;
        this.cantArcos = 0;
    }

    public void agregarNodo(String nombre) {
        Nodo nuevoNodo = new Nodo(nombre, null);
        if (prim == null) {
            prim = ult = nuevoNodo;
        } else {
            ult.prox = nuevoNodo;
            ult = nuevoNodo;
        }
        cantnodos++;
    }

    public void agregarArco(String origen, String destino, int valor) {
        Nodo nodoOrigen = buscarNodo(origen);
        Nodo nodoDestino = buscarNodo(destino);

        if (nodoOrigen != null && nodoDestino != null) {
            nodoOrigen.agregarArco(nodoDestino, valor);
            cantArcos++;
        } else {
            System.err.println("No se pudo agregar el arco: nodos no encontrados.");
        }
    }

    private Nodo buscarNodo(String nombre) {
        Nodo actual = prim;
        while (actual != null) {
            if (actual.nombre.equals(nombre)) {
                return actual;
            }
            actual = actual.prox;
        }
        return null;
    }

    public int cantidadLlegadas(String name1) {
        int cantidadLlegadas = 0;
        Nodo actual = prim;
        while (actual != null) {
            Arco arcoActual = actual.prim;
            while (arcoActual != null) {
                if (arcoActual.pDestino.nombre.equals(name1)) {
                    cantidadLlegadas++;
                }
                arcoActual = arcoActual.prox;
            }
            actual = actual.prox;
        }
        return cantidadLlegadas;
    }

    public int mayorValor() {
        int mayorValor = Integer.MIN_VALUE;
        Nodo actual = prim;
        while (actual != null) {
            Arco arcoActual = actual.prim;
            while (arcoActual != null) {
                mayorValor = Math.max(mayorValor, arcoActual.valor);
                arcoActual = arcoActual.prox;
            }
            actual = actual.prox;
        }
        return mayorValor;
    }

    public void mostrarNodosBucle() {
        Nodo actual = prim;
        while (actual != null) {
            Arco arcoActual = actual.prim;
            while (arcoActual != null) {
                if (arcoActual.pDestino == actual) {
                    System.out.println("Nodo con bucle: " + actual.nombre);
                    break; // Si encontramos un bucle en el nodo actual, no es necesario seguir buscando en sus otros arcos.
                }
                arcoActual = arcoActual.prox;
            }
            actual = actual.prox;
        }
    }

    public boolean mismosNodos(Grafo G2) {
        Nodo nodoG1 = this.prim;
        Nodo nodoG2 = G2.prim;

        while (nodoG1 != null && nodoG2 != null) {
            if (!nodoG1.nombre.equals(nodoG2.nombre)) {
                return false;
            }
            nodoG1 = nodoG1.prox;
            nodoG2 = nodoG2.prox;
        }
        return nodoG1 == null && nodoG2 == null;
    }

    public void mostrarGrafo() {
        Nodo actual = prim;
        while (actual != null) {
            Arco arcoActual = actual.prim;
            while (arcoActual != null) {
                System.out.println(actual.nombre + " -> " + arcoActual.pDestino.nombre + ":=" + arcoActual.valor);
                arcoActual = arcoActual.prox;
            }
            actual = actual.prox;
        }
    }

    public void mostrarCaminos(String name1, String name2) {
        Nodo nodoInicio = buscarNodo(name1);
        Nodo nodoDestino = buscarNodo(name2);

        if (nodoInicio == null || nodoDestino == null) {
            System.err.println("Los nodos de inicio o destino no existen en el grafo.");
            return;
        }

        LinkedList<Nodo> caminoActual = new LinkedList<>();
        caminoActual.add(nodoInicio);

        encontrarCaminos(nodoInicio, nodoDestino, caminoActual);
    }

    private void encontrarCaminos(Nodo nodoActual, Nodo nodoDestino, LinkedList<Nodo> caminoActual) {
        if (nodoActual == nodoDestino) {
            mostrarCamino(caminoActual);
        }

        Arco arcoActual = nodoActual.prim;
        while (arcoActual != null) {
            Nodo nodoSiguiente = arcoActual.pDestino;
            if (!caminoActual.contains(nodoSiguiente)) {
                LinkedList<Nodo> nuevoCamino = new LinkedList<>(caminoActual);
                nuevoCamino.add(nodoSiguiente);
                encontrarCaminos(nodoSiguiente, nodoDestino, nuevoCamino);
            }
            arcoActual = arcoActual.prox;
        }
    }

    private void mostrarCamino(LinkedList<Nodo> camino) {
        StringBuilder sb = new StringBuilder();
        for (Nodo nodo : camino) {
            sb.append(nodo.nombre).append(" -> ");
        }
        sb.setLength(sb.length() - 4);
        System.out.println(sb.toString());
    }

    public int cantidadCaminos(String name1, String name2) {
        Nodo nodoInicio = buscarNodo(name1);
        Nodo nodoDestino = buscarNodo(name2);

        if (nodoInicio == null || nodoDestino == null) {
            System.err.println("Los nodos de inicio o destino no existen en el grafo.");
            return 0;
        }

        return encontrarCaminos(nodoInicio, nodoDestino);
    }

    private int encontrarCaminos(Nodo nodoActual, Nodo nodoDestino) {
        if (nodoActual == nodoDestino) {
            // Si llegamos al nodo destino, encontramos un camino
            return 1;
        }

        int cantidad = 0;
        Arco arcoActual = nodoActual.prim;
        while (arcoActual != null) {
            Nodo nodoSiguiente = arcoActual.pDestino;
            cantidad += encontrarCaminos(nodoSiguiente, nodoDestino);
            arcoActual = arcoActual.prox;
        }

        return cantidad;
    }

    public void mostrarTotalCamino(String name1, String name2) {
        Nodo nodoInicio = buscarNodo(name1);
        Nodo nodoDestino = buscarNodo(name2);

        if (nodoInicio == null || nodoDestino == null) {
            System.err.println("Los nodos de inicio o destino no existen en el grafo.");
            return;
        }

        LinkedList<Nodo> caminoActual = new LinkedList<>();
        caminoActual.add(nodoInicio);

        encontrarTotalCaminos(nodoInicio, nodoDestino, 0, caminoActual);
    }

    private void encontrarTotalCaminos(Nodo nodoActual, Nodo nodoDestino, int costoActual, LinkedList<Nodo> caminoActual) {
        if (nodoActual == nodoDestino) {
            // Si llegamos al nodo destino, mostramos el camino y el costo total
            mostrarCaminoConCosto(caminoActual, costoActual);
            return;
        }

        Arco arcoActual = nodoActual.prim;
        while (arcoActual != null) {
            Nodo nodoSiguiente = arcoActual.pDestino;
            if (!caminoActual.contains(nodoSiguiente)) {
                // Evitamos ciclos infinitos evitando visitar nodos ya presentes en el camino actual
                int nuevoCosto = costoActual + arcoActual.valor;
                LinkedList<Nodo> nuevoCamino = new LinkedList<>(caminoActual);
                nuevoCamino.add(nodoSiguiente);
                encontrarTotalCaminos(nodoSiguiente, nodoDestino, nuevoCosto, nuevoCamino);
            }
            arcoActual = arcoActual.prox;
        }
    }

    private void mostrarCaminoConCosto(LinkedList<Nodo> camino, int costoTotal) {
        StringBuilder sb = new StringBuilder();
        for (Nodo nodo : camino) {
            sb.append(nodo.nombre).append(" -> ");
        }
        sb.setLength(sb.length() - 4);
        sb.append(": ").append(costoTotal);
        System.out.println(sb.toString());
    }


    public void mostrarCaminoCorto(String name1, String name2) {
        Nodo nodoInicio = buscarNodo(name1);
        Nodo nodoDestino = buscarNodo(name2);

        if (nodoInicio == null || nodoDestino == null) {
            System.err.println("Los nodos de inicio o destino no existen en el grafo.");
            return;
        }

        Queue<LinkedList<Nodo>> cola = new LinkedList<>();
        LinkedList<Nodo> caminoActual = new LinkedList<>();
        caminoActual.add(nodoInicio);
        cola.add(caminoActual);

        while (!cola.isEmpty()) {
            LinkedList<Nodo> camino = cola.poll();
            Nodo nodoActual = camino.getLast();

            if (nodoActual == nodoDestino) {
                // Si llegamos al nodo destino, mostramos el camino actual
                mostrarCamino(camino);
                return;
            }

            Arco arcoActual = nodoActual.prim;
            while (arcoActual != null) {
                Nodo nodoSiguiente = arcoActual.pDestino;
                if (!camino.contains(nodoSiguiente)) {
                    // Evitamos ciclos infinitos evitando visitar nodos ya presentes en el camino actual
                    LinkedList<Nodo> nuevoCamino = new LinkedList<>(camino);
                    nuevoCamino.add(nodoSiguiente);
                    cola.add(nuevoCamino);
                }
                arcoActual = arcoActual.prox;
            }
        }

        System.out.println("No se encontró ningún camino desde " + name1 + " hasta " + name2);
    }


    public void mostrarCaminoLargo(String name1, String name2) {
        Nodo nodoInicio = buscarNodo(name1);
        Nodo nodoDestino = buscarNodo(name2);

        if (nodoInicio == null || nodoDestino == null) {
            System.err.println("Los nodos de inicio o destino no existen en el grafo.");
            return;
        }

        LinkedList<Nodo> caminoActual = new LinkedList<>();
        caminoActual.add(nodoInicio);

        LinkedList<Nodo> caminoMasLargo = new LinkedList<>();

        encontrarCaminoLargo(nodoInicio, nodoDestino, caminoActual, caminoMasLargo);

        if (!caminoMasLargo.isEmpty()) {
            mostrarCamino(caminoMasLargo);
        } else {
            System.out.println("No se encontró ningún camino desde " + name1 + " hasta " + name2);
        }
    }

    private void encontrarCaminoLargo(Nodo nodoActual, Nodo nodoDestino, LinkedList<Nodo> caminoActual,
            LinkedList<Nodo> caminoMasLargo) {
        if (nodoActual == nodoDestino) {
            // Si llegamos al nodo destino, comparamos el camino actual con el más largo
            if (caminoActual.size() > caminoMasLargo.size()) {
                caminoMasLargo.clear();
                caminoMasLargo.addAll(caminoActual);
            }
            return;
        }

        Arco arcoActual = nodoActual.prim;
        while (arcoActual != null) {
            Nodo nodoSiguiente = arcoActual.pDestino;
            if (!caminoActual.contains(nodoSiguiente)) {
                // Evitamos ciclos infinitos evitando visitar nodos ya presentes en el camino actual
                LinkedList<Nodo> nuevoCamino = new LinkedList<>(caminoActual);
                nuevoCamino.add(nodoSiguiente);
                encontrarCaminoLargo(nodoSiguiente, nodoDestino, nuevoCamino, caminoMasLargo);
            }
            arcoActual = arcoActual.prox;
        }
    }
}
