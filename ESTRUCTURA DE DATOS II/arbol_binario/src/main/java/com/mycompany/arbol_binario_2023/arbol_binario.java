package com.mycompany.arbol_binario_2023;

import java.util.*;

public class arbol_binario {

    public Nodo raiz;

    public arbol_binario() {
        raiz = null;
    }

// 1.A1.generarElem(n, a, b) : Método que genera n elementos aleatorios enteros diferentes entre a y b inclusive.
    public void generarArbolAleatorio(int n, int a, int b) {
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            int elem = random.nextInt(b - a + 1) + a;
            insertar(elem);
        }
    }
//2.A1.insertar(x) : Método que inserta el elemento x, en el árbol A1 en su lugar correspondiente.  

    public void insertar(int x) {
        raiz = Insertar(raiz, x);
    }

    private Nodo Insertar(Nodo p, int x) {
        if (p == null) {
            return new Nodo(x);
        }
        if (x < p.elem) {
            p.izq = Insertar(p.izq, x);
        } else {
            p.der = Insertar(p.der, x);
        }
        return p;
    }

//3.A1.preOrden() : Método que muestra los elementos del árbol A1 en preOrden.
    public void preorden() {
        preorden(raiz);
    }

    private void preorden(Nodo x) {
        if (x == null) {
            return;
        }
        System.out.print(x.elem + " ");
        preorden(x.izq);
        preorden(x.der);
    }

//4.A1.inOrden() : Método que muestra los elementos del árbol A1 en inOrden.
    public void inorden() {
        inorden(raiz);
    }

    private void inorden(Nodo x) {
        if (x == null) {
            return;
        }
        inorden(x.izq);
        System.out.print(x.elem + " ");
        inorden(x.der);
    }

//5A1.postOrden() : Método que muestra los elementos del árbol A1 en postOrden.
    public void postorden() {
        postorden(raiz);
    }

    private void postorden(Nodo x) {
        if (x == null) {
            return;
        }
        postorden(x.izq);
        postorden(x.der);
        System.out.print(x.elem + " ");
    }

//6. A1.niveles(): Método que muestra los elementos del árbol A1, por niveles.
    public void mostrarPorNiveles() {
        LinkedList<Nodo> l1 = new LinkedList<>();
        l1.add(raiz);
        mostrarPorNivelesRecursivo(l1);
    }

    private void mostrarPorNivelesRecursivo(LinkedList<Nodo> aux) {
        if (aux.isEmpty()) {
            return;
        }

        LinkedList<Nodo> siguienteNivel = new LinkedList<>();

        for (Nodo nodo : aux) {
            System.out.print(nodo.elem + " ");

            if (nodo.izq != null) {
                siguienteNivel.add(nodo.izq);
            }

            if (nodo.der != null) {
                siguienteNivel.add(nodo.der);
            }
        }

        System.out.println();
        mostrarPorNivelesRecursivo(siguienteNivel);
    }

//7.A1.desc(): Método que muestra los elementos del árbol A1 de mayor a menor.
    public void mostrarDescendente() {
        mostrarDescendenteRecursivo(raiz);
    }

    private void mostrarDescendenteRecursivo(Nodo aux) {
        if (aux == null) {
            return;
        }

        mostrarDescendenteRecursivo(aux.der);
        System.out.print(aux.elem + " ");
        mostrarDescendenteRecursivo(aux.izq);
    }
//8.A1.seEncuentra(x) : Métodos lógico que devuelve True, si el elemento x, se encuentra en el árbol A1.

    public boolean seEncuentra(int x) {
        return seencuentra(raiz, x);
    }

    private boolean seencuentra(Nodo raiz, int x) {
        if (raiz == null) {
            return false;
        }

        if (raiz.elem == x) {
            return true;
        }

        return seencuentra(raiz.izq, x) || seencuentra(raiz.der, x);
    }

//9.A1.cantidad() : Método que devuelve la cantidad de nodos del árbol A1.
    public int cantidad() {
        return cantidadE(raiz);
    }

    private int cantidadE(Nodo raiz) {
        if (raiz == null) {
            return 0;
        }
        int izq = cantidadE(raiz.izq);
        int der = cantidadE(raiz.der);
        return izq + der + 1;
    }
//10.   A1.suma() : Método que devuelve la suma de los elementos del árbol A1.

    public int suma() {
        return sumaR(raiz);
    }

    private int sumaR(Nodo raiz) {
        if (raiz == null) {
            return 0;
        }
        int izq = sumaR(raiz.izq);
        int der = sumaR(raiz.der);
        return izq + der + raiz.elem;
    }

//11.   A1.menor() : Método que devuelve el elemento menor del árbol A1.
    public int menor() {
        return menor(raiz);
    }

    private int menor(Nodo raiz) {
        if (raiz == null) {
            return -1;
        }
        if (raiz.izq == null) {
            return raiz.elem;
        }
        return menor(raiz.izq);
    }

//12.   A1.mayor() : Método que devuelve el elemento mayor del árbol A1.
    public int mayor() {
        return mayor(raiz);
    }

    private int mayor(Nodo raiz) {
        if (raiz == null) {
            return -1;
        }
        if (raiz.der == null) {
            return raiz.elem;
        }
        return mayor(raiz.der);
    }

//13.   A1.preoOrden(L1) : Método que encuentra en la lista L1, el recorrido de preOrden de los elementos del árbol A1.
    public void preorden(LinkedList<Integer> l1) {
        preorden(raiz, l1);
    }

    private void preorden(Nodo x, LinkedList<Integer> l1) {
        if (x == null) {
            return;
        }
        l1.add(x.elem);
        preorden(x.izq, l1);
        preorden(x.der, l1);
    }

//14.   A1.inOrden(L1) : Método que encuentra en la lista L1, el recorrido de inOrden de los elementos del árbol A1.
    public void inorden(LinkedList<Integer> l1) {
        inorden(raiz, l1);
    }

    public void inorden(Nodo x, LinkedList<Integer> l1) {
        if (x == null) {
            return;
        }
        inorden(x.izq, l1);
        l1.add(x.elem);
        inorden(x.der, l1);
    }

//15.   A1.postOrden(L1) : Método que encuentra en la lista L1, el recorrido de postOrden de los elementos del árbol A1.    
    public void postorden(LinkedList<Integer> l1) {
        postorden(raiz, l1);
    }

    private void postorden(Nodo x, LinkedList<Integer> l1) {
        if (x == null) {
            return;
        }
        postorden(x.izq, l1);
        postorden(x.der, l1);
        l1.add(x.elem);
    }
//16.   A1.niveles(L1) : Método que encuentra en la lista L1, el recorrido por niveles de los elementos del árbol A1.

    public LinkedList<Integer> Nivel(LinkedList<Integer> l1) {

        int altura = AlturaRec(raiz);
        for (int i = 1; i <= altura; i++) {
            NivelR(l1, raiz, i);
        }

        return l1;
    }

    private void NivelR(LinkedList<Integer> l1, Nodo raiz, int nivel) {
        if (raiz == null) {
            return;
        }

        if (nivel == 1) {
            l1.add(raiz.elem);
        } else if (nivel > 1) {
            NivelR(l1, raiz.izq, nivel - 1);
            NivelR(l1, raiz.der, nivel - 1);
        }
    }
//17.   A1.mostrarNivel(): Método que muestra los elementos del árbol y el nivel en el que se encuentran. (Recorrer el árbol en cualquier orden)

    public void mostrarnivel() {
        mostrarnivel(raiz, 1);
    }

    public void mostrarnivel(Nodo aux, int n) {
        if (aux == null) {
            return;
        }
        mostrarnivel(aux.izq, n + 1);
        System.out.println(aux.elem + " " + n);
        mostrarnivel(aux.der, n + 1);
    }

//18. A1.sumarNivel(L1) : Método que encuentra en la Lista de contadores por nivel L1, la suma de los elementos de cada nivel.
    public List<Integer> obtenerSumaNiveles(List<Integer> l1) {
        SumaNivelesR(raiz, 0, l1);
        return l1;
    }

    private void SumaNivelesR(Nodo raiz, int nivel, List<Integer> sumaN) {
        if (raiz == null) {
            return;
        }

        if (nivel >= sumaN.size()) {
            sumaN.add(raiz.elem);
        } else {
            int sumaActual = sumaN.get(nivel);
            sumaN.set(nivel, sumaActual + raiz.elem);
        }

        SumaNivelesR(raiz.izq, nivel + 1, sumaN);
        SumaNivelesR(raiz.der, nivel + 1, sumaN);
    }

//19.   A1.alturaMayor(): Método que devuelve la altura del árbol A1. (Altura es la máxima longitud de la raíz a un nodo hoja en el árbol)
    public int AlturaMayor() {
        return AlturaRec(raiz);
    }

    private int AlturaRec(Nodo raiz) {
        if (raiz == null) {
            return 0;
        }

        int Izq = AlturaRec(raiz.izq);
        int Der = AlturaRec(raiz.der);

        return Math.max(Izq, Der) + 1;
    }

//20.   A1.alturaMenor(): Método que devuelve la menor altura del árbol A1.
    public int AlturaMenor() {
        return AlturamenorR(raiz);
    }

    private int AlturamenorR(Nodo raiz) {
        if (raiz == null) {
            return 0;
        }

        int Izq = AlturaRec(raiz.izq);
        int Der = AlturaRec(raiz.der);

        return Math.min(Izq, Der) + 1;
    }

//21.   A1.mostrarTerm(): Método que muestra los elementos de los nodos terminales del árbol A1. Mostrar los elementos de menor a mayor.
    public void mostrarTerm() {
        mostrarTermR(raiz);
    }

    private void mostrarTermR(Nodo raiz) {
        if (raiz == null) {
            return;
        }

        if (raiz.izq == null && raiz.der == null) {
            System.out.print(raiz.elem + " ");
        }

        mostrarTermR(raiz.izq);
        mostrarTermR(raiz.der);
    }

//22.   A1.cantidadTerm(): Método que devuelve la cantidad de nodos terminales del árbol A1.
    public int cantidadTerm() {
        return cantidadTermR(raiz);
    }

    private int cantidadTermR(Nodo raiz) {
        if (raiz == null) {
            return 0;
        }

        if (raiz.izq == null && raiz.der == null) {
            return 1;
        }

        int izq = cantidadTermR(raiz.izq);
        int der = cantidadTermR(raiz.der);
        return izq + der;
    }
//23.   A1.lineal() : Método lógico que devuelve True, si el árbol A1 es un árbol degenerado o lIneal. (Se puede dar cuando se genera el árbol con una secuencia ordenada de elementos)

    public boolean Lineal() {
        return LinealR(raiz);
    }

    private boolean LinealR(Nodo raiz) {
        if (raiz == null) {
            return true;
        }

        if (raiz.izq != null && raiz.der != null) {
            return false;
        }

        boolean Izq = LinealR(raiz.izq);
        boolean Der = LinealR(raiz.der);

        return Izq && Der;
    }

//24. A1.inmediatoSup(x) : Método que devuelve el elemento inmediato superior a x, si x se encuentra en A1, caso contrario devuelve el mismo elemento.
    public int inmediatoSup(int x) {
        return inmediatoSup(raiz, x, x);
    }

    private int inmediatoSup(Nodo p, int x, int res) {
        if (p == null) {
            return res;
        }
        if (x < p.elem) {
            return inmediatoSup(p.izq, x, p.elem);
        }
        if (x > p.elem) {
            return inmediatoSup(p.der, x, res);
        }
        if (x == p.elem) {
            if (p.der != null) {
                Nodo temp = p.der;
                while (temp.izq != null) {
                    temp = temp.izq;
                }
                return temp.elem;
            }
            return res;
        }
        return res;
    }

//25. A1.inmediatoInf(x) : Método que devuelve el elemento inmediato inferior a x, si x se encuentra en A1, caso contrario devuelve el mismo elemento.
    public int inmediatoInf(int x) {
        return inmediatoInf(raiz, x, x);
    }

    private int inmediatoInf(Nodo p, int x, int res) {
        if (p == null) {
            return res;
        }
        if (x < p.elem) {
            return inmediatoInf(p.izq, x, res);
        }
        if (x > p.elem) {
            return inmediatoInf(p.der, x, p.elem);
        }
        if (x == p.elem) {
            if (p.izq != null) {
                Nodo temp = p.izq;
                while (temp.der != null) {
                    temp = temp.der;
                }
                return temp.elem;
            }
            return res;
        }
        return res;
    }

//26.   Implementar al menos 5 Ejercicios adicionales cualesquiera, de consultas sobre uno o más árboles binarioos de búsqueda. Citar fuentes.
//ejercicio 1:
    //MUESTRA LOS ELEMENTOS DEL ULTIMO NIVEL DEL ARBOL BINARIO
    public void UltimoNivel() {
        UltimoNivel(raiz, this.AlturaMayor());
    }

    private void UltimoNivel(Nodo p, int altura) {
        if (p != null) {
            if (altura == 1) {
                System.out.println(p.elem + " ");
            } else {
                UltimoNivel(p.izq, altura - 1);
                UltimoNivel(p.der, altura - 1);
            }
        }
    }

//ejercicio 2:
    //MUESTRA LOS ELEMENTOS QUE SON PARES DEL ARBOL BINARIO
    private void mostrarPares(Nodo raiz) {
        if (raiz == null) {
            return;
        }
        mostrarPares(raiz.izq);
        mostrarPares(raiz.der);
        if (raiz.elem % 2 == 0) {
            System.out.print(raiz.elem + " ");
        }

    }

    public void mostrarpares() {
        mostrarPares(raiz);
    }
//ejercicio 3:
    //VERIFICA SI DOS ARBOLES SON IGUALES

    public boolean ArbolesIguales(Nodo raiz1, Nodo raiz2) {
        if (raiz1 == null && raiz2 == null) {
            return true;
        }
        if (raiz1 == null || raiz2 == null) {
            return false;
        }
        return (raiz1.elem == raiz2.elem)
                && ArbolesIguales(raiz1.izq, raiz2.izq)
                && ArbolesIguales(raiz1.der, raiz2.der);
    }
//ejercicio 4:

    public void mostrarPrefijos(Nodo raiz) {
        if (raiz == null) {
            return;
        }
        System.out.print(raiz.elem + " ");
        mostrarPrefijos(raiz.izq);
        mostrarPrefijos(raiz.der);
    }
//ejercicio 5:
    //EJERCICIO QUE MUESTRA EL UNICO HIJO QUE TIENE UN NODO

    public void mostrar_un_hijo() {
        mostrar_un_hijo(raiz);
    }

    private void mostrar_un_hijo(Nodo pr) {
        if (pr == null) {
            return;
        } else {
            if (pr.elem != 0) {
                if (pr.izq != null && pr.der == null) {
                    System.out.println(pr.izq.elem + " ");
                } else {
                    if (pr.izq == null && pr.der != null) {
                        System.out.println(pr.der.elem + " ");
                    }
                }
            }
            mostrar_un_hijo(pr.izq);
            mostrar_un_hijo(pr.der);
        }
    }

    //----------------METODOS DE ELIMINAR--------------------
//A1.eliminar(x) : Método que elimina el elemento x, del árbol A1.
    public void eliminar(int x) {
        raiz = eliminar(raiz, x);
    }

    private Nodo eliminar(Nodo p, int x) {
        if (p == null) {
            return null;
        }
        if (x == p.elem) {
            return eliminarNodo(p);
        }
        if (x < p.elem) {
            p.izq = eliminar(p.izq, x);
        } else {
            p.der = eliminar(p.der, x);
        }
        return p;
    }

    public Nodo eliminarNodo(Nodo p) {
        if (p.izq == null && p.der == null) {
            return null;
        }
        if (p.izq != null && p.der == null) {
            return p.izq;
        }
        if (p.izq == null && p.der != null) {
            return p.der;
        }
        //eliminar nodo raiz;
        int y = inmediatoInf(p.izq);
        p.elem = y;
        p.izq = eliminar(p.izq, y);
        return p;
    }

    public int inmediatoInf(Nodo p) {
        if (p.der == null) {
            return p.elem;
        } else {
            return inmediatoInf(p.der);
        }
    }
//A1.eliminarHojas() : Método que elimina los nodos hoja de árbol A1.

    public void eliminarHojas() {
        raiz = eliminarhoja(raiz);
    }

    private Nodo eliminarhoja(Nodo raiz) {
        if (raiz == null) {
            return null;
        }
        if (raiz.izq == null && raiz.der == null) {
            raiz = eliminarNodo(raiz);
        } else {
            raiz.izq = eliminarhoja(raiz.izq);
            raiz.der = eliminarhoja(raiz.der);
        }
        return raiz;
    }

//A1.eliminarPares() : Método que elimina los elementos pares del árbol A1.
    public void eliminarPares() {
        raiz = eliminarPares(raiz);
    }

    private Nodo eliminarPares(Nodo raiz) {
        if (raiz == null) {
            return null;
        }
        if (raiz.elem % 2 == 0) {
            raiz = eliminarPares(raiz);
        } else {
            raiz.izq = eliminarPares(raiz.izq);
            raiz.der = eliminarPares(raiz.der);
        }
        return raiz;
    }

//A1.eliminar(L1) : Método que elimina los elementos de la lista L1 que se encuentran en el árbol A1.
    public void eliminarElementosEnArbol(LinkedList<Integer> L1) {
        eliminarElementosEnArbolRecursivo(raiz, L1);
    }

    private void eliminarElementosEnArbolRecursivo(Nodo raiz, LinkedList<Integer> L1) {
        if (raiz == null) {
            return;
        }

        eliminarElementosEnArbolRecursivo(raiz.izq, L1);
        eliminarElementosEnArbolRecursivo(raiz.der, L1);

        if (L1.contains(raiz.elem)) {
            L1.remove(Integer.valueOf(raiz.elem));
        }
    }
//A1.eliminarMenor(): Método que elimina el elemento menor del árbol A1.

    public void eliminarMenor() {
        eliminarMenor(raiz);
    }

    private void eliminarMenor(Nodo raiz) {
        if (raiz == null) {
            return;
        }
        int y = menor();
        eliminar(y);
    }

//A1.eliminarMayor(): Método que elimina el elemento mayor del árbol A1.
    public void eliminarMayor() {
        eliminarMayor(raiz);
    }

    private void eliminarMayor(Nodo raiz) {
        if (raiz == null) {
            return;
        }
        int y = mayor();
        eliminar(y);
    }
//A1.eliminarNivel( n ) : Método que elimina los nodos del árbol A1 del nivel n.

    public void eliminarNivel(int n) {
        raiz = eliminarNivelRecursivo(raiz, n, 1);
    }

    private Nodo eliminarNivelRecursivo(Nodo raiz, int nivel, int nivelActual) {
        if (raiz == null) {
            return null;
        }

        if (nivelActual == nivel) {
            return null;
        }

        raiz.izq = eliminarNivelRecursivo(raiz.izq, nivel, nivelActual + 1);
        raiz.der = eliminarNivelRecursivo(raiz.der, nivel, nivelActual + 1);

        return raiz;
    }

//A1.eliminarRaices() : Método que elimina los nodos raíces del árbol A1.
    public void eliminarRaices() {
        raiz = eliminarRaicesRecursivo(raiz);
    }

    private Nodo eliminarRaicesRecursivo(Nodo raiz) {
        if (raiz == null) {
            return null;
        }

        if (raiz.izq == null && raiz.der == null) {
            return null;
        }

        raiz.izq = eliminarRaicesRecursivo(raiz.izq);
        raiz.der = eliminarRaicesRecursivo(raiz.der);

        return raiz;
    }
//Completar a 15 ejercicios interesantes. En lo posible citar fuente.
    //ejercicios:
//elimina los elementos impares

    public void eliminarImpares() {
        raiz = eliminarImparesRecursivo(raiz);
    }

    private Nodo eliminarImparesRecursivo(Nodo raiz) {
        if (raiz == null) {
            return null;
        }

        if (raiz.elem % 2 != 0) {
            return null;
        }

        raiz.izq = eliminarImparesRecursivo(raiz.izq);
        raiz.der = eliminarImparesRecursivo(raiz.der);

        return raiz;
    }
//elimina el elemento que tenga 2 hijos

    public void eliminarDosHijos() {
        raiz = eliminarNodosDosHijosRecursivo(raiz);
    }

    private Nodo eliminarNodosDosHijosRecursivo(Nodo raiz) {
        if (raiz == null) {
            return null;
        }

        if (raiz.izq != null && raiz.der != null) {
            return null; // Eliminar el nodo con dos hijos
        }

        raiz.izq = eliminarNodosDosHijosRecursivo(raiz.izq);
        raiz.der = eliminarNodosDosHijosRecursivo(raiz.der);

        return raiz;
    }
//elimina los elementos repetidos del arbol binario

    public void eliminarElementosRepetidos() {
        LinkedList<Integer> l1 = new LinkedList<>();
        raiz = eliminarElementosRepetidosRecursivo(raiz, l1);
    }

    private Nodo eliminarElementosRepetidosRecursivo(Nodo raiz, LinkedList<Integer> l1) {
        if (raiz == null) {
            return null;
        }

        if (l1.contains(raiz.elem)) {
            return null;
        }

        l1.add(raiz.elem);

        raiz.izq = eliminarElementosRepetidosRecursivo(raiz.izq, l1);
        raiz.der = eliminarElementosRepetidosRecursivo(raiz.der, l1);

        return raiz;
    }
//elimina los elementos que tengan un hijo

    public void eliminarUnHijo() {
        raiz = eliminarNodosUnHijoRecursivo(raiz);
    }

    private Nodo eliminarNodosUnHijoRecursivo(Nodo raiz) {
        if (raiz == null) {
            return null;
        }

        if (raiz.izq == null && raiz.der != null) {
            return raiz.der; 
        } else if (raiz.izq != null && raiz.der == null) {
            return raiz.izq; 
        }

        raiz.izq = eliminarNodosUnHijoRecursivo(raiz.izq);
        raiz.der = eliminarNodosUnHijoRecursivo(raiz.der);

        return raiz;
    }

    
    
}
