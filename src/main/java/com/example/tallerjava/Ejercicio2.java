package com.example.tallerjava;

import java.math.BigInteger;

public class Ejercicio2 {

    public static void main(String[] args) {
        int n = 100;
        System.out.println("El resultado de Fibonacci de " + n + " es " + fibonacciIterativo(n));
    }
    
    // Algoritmo recursivo: 
    // Se eligió retornar un tipo long ya que en un int no entraría un valor tan grande como el que retorna fibonacci(90).
    // De todos modos el algoritmo se vuelve demasiado lento para valores grandes, pese a la gran cantidad de cálculos.
    public static long fibonacci (int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }


    // Algoritmo extendido (iterativo):
    // Se eligió retornar un BigInteger (no primitivo) para poder calcular valores de fibonacci por encima de fib(90).
    // Esta solución resuelve el problema del tiempo ya que tiene complejidad O(n), y el de overflow al utilizar este tipo de dato.
    public static BigInteger fibonacciIterativo(int n) {
        if (n == 0) {
            return BigInteger.ZERO;
        }
        if (n == 1) {
            return BigInteger.ONE;
        }

        BigInteger anterior = BigInteger.ZERO;
        BigInteger actual = BigInteger.ONE;

        for (int i = 2; i <= n; i++) {
            BigInteger siguiente = anterior.add(actual);
            anterior = actual;
            actual = siguiente;
        }

        return actual;
    }

    // DATO:
    // int: almacena hasta 32 bits - El mayor entero positivo es 2^31 - 1 = 2,147,483,647
    // long: almacena hasta 64 bits - El mayor entero positivo es 2^63 - 1 = 9,223,372,036,854,775,807

    // fibonacci de 100 excede ambos valores !

}
