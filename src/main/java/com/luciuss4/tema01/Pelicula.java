package com.luciuss4.tema01;

public class Pelicula {

    private String titulo;
    private double media;

    public Pelicula(String titulo, double media) {
        this.titulo = titulo;
        this.media = media;
    }

    public String getTitulo() {
        return titulo;
    }

    public double getMedia() {
        return media;
    }
}