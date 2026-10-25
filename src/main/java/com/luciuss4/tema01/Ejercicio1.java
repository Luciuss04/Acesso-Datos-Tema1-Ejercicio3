package com.luciuss4.tema01;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class Ejercicio1 {

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File("Recursos/empleados.xml"));
            doc.getDocumentElement().normalize();

            NodeList empleados = doc.getElementsByTagName("empleado");

            for (int i = 0; i < empleados.getLength(); i++) {
                Element empleado = (Element) empleados.item(i);

                String id = empleado.getAttribute("id");
                String nombre = empleado.getElementsByTagName("nombre").item(0).getTextContent();
                String salario = empleado.getElementsByTagName("salario").item(0).getTextContent();

                System.out.println("ID: " + id + " | Nombre: " + nombre + " | Salario: " + salario);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}