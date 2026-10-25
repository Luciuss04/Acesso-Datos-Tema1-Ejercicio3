package com.luciuss4.tema01;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.TreeSet;

public class Ejercicio8 {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader("Recursos/peliculas.json"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                sb.append(linea);
            }

            JSONTokener tokener = new JSONTokener(sb.toString());
            JSONObject json = new JSONObject(tokener);
            JSONArray jsonPeliculas = json.getJSONArray("peliculas");

            ArrayList<Pelicula> peliculas = new ArrayList<>();

            for (int i = 0; i < jsonPeliculas.length(); i++) {
                JSONObject pelicula = jsonPeliculas.getJSONObject(i);
                JSONObject puntuaciones = pelicula.getJSONObject("puntuaciones");

                double imdb = puntuaciones.getDouble("imdb");
                double rt = puntuaciones.getDouble("rt") / 10;
                double media = (imdb + rt) / 2;

                peliculas.add(new Pelicula(pelicula.getString("titulo"), media));
            }

            peliculas.sort((p1, p2) -> Double.compare(p2.getMedia(), p1.getMedia()));

            System.out.println("a) Películas ordenadas por media:");
            for (Pelicula p : peliculas) {
                System.out.printf("%s | %.2f%n", p.getTitulo(), p.getMedia());
            }

            TreeSet<String> generos = new TreeSet<>();

            for (int i = 0; i < jsonPeliculas.length(); i++) {
                JSONArray jsonGeneros = jsonPeliculas.getJSONObject(i).getJSONArray("generos");

                for (int j = 0; j < jsonGeneros.length(); j++) {
                    generos.add(jsonGeneros.getString(j));
                }
            }

            System.out.println();
            System.out.println("b) Géneros:");
            for (String genero : generos) {
                System.out.println(genero);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}