package com.luciuss4.tema01;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.HashMap;

public class Ejercicio3 {

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File("Recursos/biblioteca.xml"));
            doc.getDocumentElement().normalize();

            NodeList libros = doc.getElementsByTagName("libro");


            System.out.println("Títulos:");
            for (int i = 0; i < libros.getLength(); i++) {
                Element libro = (Element) libros.item(i);
                String titulo = libro.getElementsByTagName("titulo").item(0).getTextContent();
                System.out.println(titulo);
            }

            HashMap<String, Integer> generos = new HashMap<>();

            NodeList listaGeneros = doc.getElementsByTagName("genero");
            for (int i = 0; i < listaGeneros.getLength(); i++) {
                String genero = listaGeneros.item(i).getTextContent();

                if (generos.containsKey(genero)) {
                    generos.put(genero, generos.get(genero) + 1);
                } else {
                    generos.put(genero, 1);
                }
            }

            System.out.println();
            System.out.println("Libros por género:");
            for (String genero : generos.keySet()) {
                System.out.println(genero + ": " + generos.get(genero));
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}