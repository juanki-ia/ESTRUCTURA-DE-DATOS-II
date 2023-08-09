package com.mycompany.listas_arreglos;



public class lista_con_arreglos {

    private final int max;
    private int cantElem;
    private final int elem[];


    public lista_con_arreglos() {
        this.max = 20;
        this.cantElem = 0;
        this.elem = new int[this.max];
    }

    public String toStringL() {
        int i = 0;
        String s1 = "[";
        while (i < cantElem) {
            s1 = s1 + elem[i];
            if (i < cantElem - 1) {
                s1 = s1 + ", ";
            }
            i++;
        }
        s1 = s1 + "]";
        return s1;
    }

    public void insertarPrim(int x) {
        insertarIesimo(x, 0);
    }

    public void insertarUlt(int x) {
        elem[cantElem] = x;
        cantElem++;
    }

    public void insertarIesimo(int x, int i) {
        for (int j = cantElem - 1; j >= i; j--) {
            elem[j + 1] = elem[j];
        }
        elem[i] = x;
        cantElem++;
    }

    public void eliminarPrim() {
        eliminarIesimo(0);
    }

    public void eliminarUlt() {
        eliminarIesimo(cantElem - 1);
    }

    public void eliminarIesimo(int i) {
        for (int j = i + 1; j < cantElem; j++) {
            elem[j - 1] = elem[j];
        }
        this.cantElem--;
    }

    public void eliminarPares() {
        for (int i = this.cantElem - 1; i >= 0; i--) {
            if (esPar(elem[i])) {
                eliminarIesimo(i);
            }
        }
    }

    public void eliminarTodo(int x) {
        int i = 0;
        while (i < this.cantElem) {
            if (this.elem[i] == x) {
                eliminarIesimo(i);
            } else {
                i++;
            }
        }
    }

    public int frecuencia(int x) {
        int cont = 0;
        for (int i = 0; i < cantElem; i++) {
            if (x == elem[i]) {
                cont++;
            }
        }
        return cont;
    }

    public int mayorElem() {
        int may = elem[0];
        for (int i = 0; i < cantElem; i++) {
            if (elem[i] > may) {
                may = elem[i];
            }
        }
        return may;
    }

    public int menorElem() {
        int men = elem[0];
        for (int i = 0; i < cantElem; i++) {
            if (elem[i] < men) {
                men = elem[i];
            }
        }
        return men;
    }

    public boolean existepar() {
        for (int i = 0; i < cantElem; i++) {
            if (esPar(elem[i])) {
                return true;
            }
        }
        return false;
    }

    public boolean esPar(int x) {
        return x % 2 == 0;
    }
}
