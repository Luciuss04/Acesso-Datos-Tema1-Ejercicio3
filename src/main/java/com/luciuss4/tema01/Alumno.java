package com.luciuss4.tema01;

public class Alumno {

    private String id;
    private String nombre;
    private boolean matriculado;
    private String fechaNacimiento;
    private Nota[] notas;

    public Alumno(String id, String nombre, boolean matriculado, String fechaNacimiento, Nota[] notas) {
        this.id = id;
        this.nombre = nombre;
        this.matriculado = matriculado;
        this.fechaNacimiento = fechaNacimiento;
        this.notas = notas;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isMatriculado() {
        return matriculado;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public Nota[] getNotas() {
        return notas;
    }

    public double getMedia() {
        double suma = 0;
        for (Nota n : notas) {
            suma += n.getNota();
        }
        return suma / notas.length;
    }
}