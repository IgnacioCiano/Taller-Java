package com.example.tallerjava;

/**
 * Ejercicio 3 - Validacion de Arbol Binario de Busqueda (BST)
 *
 * Estrategia: validacion por rango de valores (min/max).
 * Se recorre el arbol en profundidad pasando a cada nodo un rango
 * (min, max) que su valor debe respetar. Al bajar por la izquierda
 * el valor del nodo se convierte en el nuevo tope superior (max),
 * y al bajar por la derecha se convierte en el nuevo piso inferior
 * (min). Si algun nodo queda fuera del rango, no es BST. Esto
 * garantiza que ningun descendiente viole la propiedad con
 * ancestros lejanos, algo que no se logra verificando solo
 * contra el padre directo.
 */

public class Ejercicio3 {

     public static void main(String[] args) {
        System.out.println("Ejercicio 3");
        Node n4 = new Node(3,null,null);
        Node n5 = new Node(6,null,null);
        Node n2 = new Node(5,n4,n5);
        Node n3 = new Node(3,null,null);
        Node n1 = new Node(9,n2,n3);

        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(esBST(n1));

    }

    public static boolean esBST(Node raiz) {
        return esBST(raiz, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean esBST(Node nodo, int min, int max) {
        if (nodo == null) {
            return true;
        }

        if (nodo.getData() <= min || nodo.getData() >= max) {
            return false;
        }

        return esBST(nodo.getLeft(), min, nodo.getData()) &&
            esBST(nodo.getRight(), nodo.getData(), max);
    }

    public static void imprimirArbol(Node raiz) {
        imprimirArbol(raiz, "", true);
    }

    private static void imprimirArbol(Node nodo, String prefijo, boolean esUltimo) {
        if (nodo == null) {
            return;
        }

        System.out.println(
            prefijo +
            (esUltimo ? "└── " : "├── ") +
            nodo.getData()
        );

        String nuevoPrefijo = prefijo + (esUltimo ? "    " : "│   ");

        boolean tieneDerecho = nodo.getRight() != null;

        if (nodo.getLeft() != null) {
            imprimirArbol(nodo.getLeft(), nuevoPrefijo, !tieneDerecho);
        }

        if (nodo.getRight() != null) {
            imprimirArbol(nodo.getRight(), nuevoPrefijo, true);
        }
    }

}

class Node {
    private int data;
    private Node left;
    private Node right;

    public Node(int data,Node l, Node r){
        this.data = data;
        this.left = l;
        this.right = r;
    }

    public int getData() {
        return data;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }
}
