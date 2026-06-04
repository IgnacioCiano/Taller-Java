package com.example.tallerjava;

import java.util.ArrayList;

public class Ejercicio4 {

    public static void main(String[] args) {
        ArrayList<String> array = new ArrayList<>();
        array.add(".");
        array.add("f");
        array.add("e");
        array.add("a");
        array.add("a");
        array.add("f");
        array.add(".");
        array.add("e");

        int X = 1;
        int Y = 3;

        System.out.println("Se pueden realizar " + fotoArtistica(array, X, Y) + " fotografias artisticas");

    }

    public static int fotoArtistica(ArrayList<String> array, int x, int y) {
        int cant = 0;

        // Recorro cada posición buscando fotógrafos
        for (int fotografo = 0; fotografo < array.size(); fotografo++) {
            if (!isFotografo(array.get(fotografo))) {
                continue;
            }

            // Desde cada fotógrafo pruebo ambas direcciones: izquierda y derecha.
            for (int direccion : new int[] {-1, 1}) {
                // Busco un artista entre X e Y posiciones de distancia.
                for (int distanciaArtista = x; distanciaArtista <= y; distanciaArtista++) {
                    int artista = fotografo + (direccion * distanciaArtista);
                    if (artista < 0 || artista >= array.size() || !isArtista(array.get(artista))) {
                        continue;
                    }

                    // Si hay un artista válido, busco un escenario en la misma dirección.
                    for (int distanciaEscenario = x; distanciaEscenario <= y; distanciaEscenario++) {
                        int escenario = artista + (direccion * distanciaEscenario);
                        if (escenario >= 0 && escenario < array.size() && isEscenario(array.get(escenario))) {
                            // Encontré una combinación fotógrafo -> artista -> escenario.
                            cant++;
                        }
                    }
                }
            }
        }

        return cant;
    }

    public static  boolean isFotografo(String letra){
        return letra.equalsIgnoreCase("f");
        
    }

    public static boolean isArtista(String letra){
        return letra.equalsIgnoreCase("a");
    }

    public static boolean isEscenario(String letra){
        return letra.equalsIgnoreCase("e");
    }

}