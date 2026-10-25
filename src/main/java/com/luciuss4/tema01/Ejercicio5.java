package com.luciuss4.tema01;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.FileReader;

public class Ejercicio5 {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader("Recursos/alumnos.json"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                sb.append(linea);
            }

            JSONTokener tokener = new JSONTokener(sb.toString());
            JSONArray alumnos = new JSONArray(tokener);

            for (int i = 0; i < alumnos.length(); i++) {
                JSONObject alumno = alumnos.getJSONObject(i);

                String nombre = alumno.getString("nombre");
                String fechaNacimiento = alumno.getString("fechaNacimiento");

                System.out.println("Nombre: " + nombre + " | Fecha de nacimiento: " + fechaNacimiento);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}