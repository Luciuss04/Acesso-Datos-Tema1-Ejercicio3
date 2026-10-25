package com.luciuss4.tema01;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.FileReader;

public class Ejercicio6 {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader("Recursos/alumnos.json"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                sb.append(linea);
            }

            JSONTokener tokener = new JSONTokener(sb.toString());
            JSONArray jsonAlumnos = new JSONArray(tokener);

            Alumno[] alumnos = new Alumno[jsonAlumnos.length()];

            for (int i = 0; i < jsonAlumnos.length(); i++) {
                JSONObject jsonAlumno = jsonAlumnos.getJSONObject(i);

                JSONArray jsonNotas = jsonAlumno.getJSONArray("notas");
                Nota[] notas = new Nota[jsonNotas.length()];

                for (int j = 0; j < jsonNotas.length(); j++) {
                    JSONObject jsonNota = jsonNotas.getJSONObject(j);
                    notas[j] = new Nota(jsonNota.getString("asignatura"), jsonNota.getDouble("nota"));
                }

                alumnos[i] = new Alumno(
                        jsonAlumno.getString("id"),
                        jsonAlumno.getString("nombre"),
                        jsonAlumno.getBoolean("matriculado"),
                        jsonAlumno.getString("fechaNacimiento"),
                        notas
                );
            }

            Alumno alumnoNotaMax = null;
            Nota notaMax = null;

            for (Alumno alumno : alumnos) {
                for (Nota nota : alumno.getNotas()) {
                    if (notaMax == null || nota.getNota() > notaMax.getNota()) {
                        notaMax = nota;
                        alumnoNotaMax = alumno;
                    }
                }
            }

            System.out.println("a) Nota más alta: " + alumnoNotaMax.getNombre()
                    + " | " + notaMax.getAsignatura() + " | " + notaMax.getNota());

            Alumno mejorMedia = alumnos[0];

            for (Alumno alumno : alumnos) {
                if (alumno.getMedia() > mejorMedia.getMedia()) {
                    mejorMedia = alumno;
                }
            }

            System.out.printf("b) Mejor media: %s | %.2f%n", mejorMedia.getNombre(), mejorMedia.getMedia());

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}