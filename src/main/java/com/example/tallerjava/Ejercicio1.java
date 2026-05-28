package com.example.tallerjava;

import java.util.HashMap;

public class Ejercicio1 {
    
     public static void main(String[] args) {
        
        String texto = 
        "Hola, como andas? " +
        "Hola, bien y vos? " +
        "Bien bien!"
        ;

        String palabra = Ejercicio1.palabraMasUsada(texto, 3);
        System.out.println(palabra);
    }

    public static  String palabraMasUsada(String texto, int N){
        
        // Formateo el texto y guardo las palabras separadas por espacios o caracteres
        // diferentes a letras
        texto = texto.toLowerCase();
        String[] palabras = texto.split("[^a-zA-Z]+");
        // Inicializo un HashMap donde se guardaran las ocurrencias de cada palabra
        // La clave es la palabra y el Integer la cantidad de veces que aparece
        HashMap<String, Integer> contador = new HashMap<>();

        // Cuento las veces que aparece cada palabra en el texto
        // (solo si la palabra tiene longitud mayor o igual a N)
        for (String palabra : palabras) {
            if (palabra.length() >= N){
                contador.put(palabra, contador.getOrDefault(palabra, 0) +1);
            }
        }

        // seteo un string vacio por si no hay una palabra mas usada y 
        // defino el maximo = 0 para la primer iteracion
        String masUsada = "";
        int max = 0;

        // Recorro cada entrada del mapa y voy actualizando el maximo y me quedo con la palabra
        // con mayor ocurrencia en el texto
        for (HashMap.Entry<String, Integer> entrada : contador.entrySet()) {
            if(entrada.getValue() > max) {
                max = entrada.getValue();
                masUsada = entrada.getKey();
            }
        }

        // Retorno la palabra mas usada
        return masUsada;
    }
}
