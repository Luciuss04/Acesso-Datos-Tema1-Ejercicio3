package com.luciuss4.tema01;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Ejercicio7 {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader("Recursos/inventario.json"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                sb.append(linea);
            }

            JSONTokener tokener = new JSONTokener(sb.toString());
            JSONObject inventario = new JSONObject(tokener);
            JSONArray productos = inventario.getJSONArray("productos");

            Scanner sc = new Scanner(System.in);
            System.out.print("Introduce el id del producto: ");
            String idProducto = sc.nextLine();

            boolean encontrado = false;

            for (int i = 0; i < productos.length(); i++) {
                JSONObject producto = productos.getJSONObject(i);

                if (producto.getString("id").equalsIgnoreCase(idProducto)) {
                    encontrado = true;

                    JSONObject ubicacion = producto.getJSONObject("ubicacion");
                    int pasillo = ubicacion.getInt("pasillo");
                    String estante = ubicacion.getString("estante");

                    System.out.println("Producto: " + producto.getString("nombre"));
                    System.out.println("Ubicación: pasillo " + pasillo + ", estante " + estante);
                }
            }

            if (!encontrado) {
                System.out.println("No existe ningún producto con id " + idProducto);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}